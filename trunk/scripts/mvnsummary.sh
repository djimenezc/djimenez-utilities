#!/bin/bash

export logFile="$3/compile.log"
export tempFile="/tmp/awkTemp.tmp"


PROJECT_PATH=$1

process_test_files()
{

	PATH_PROJECT_TESTED=`find -name surefire-reports`
	
	for projectFolder in $PATH_PROJECT_TESTED
	do

		#projectName=`gawk $PROJECT_FOLDER ' { print "" $1  }' `
		
		echo PROJECT-\> $projectFolder
		
		testFiles=$(echo `ls $projectFolder | grep .txt`)
		
		for testFile in $testFiles
		do
			
			cat $projectFolder/$testFile | \
			gawk '
				/Test set/ { class = $3 }
				 
				/Tests run/ { 
					
					split($1, a, ":")
					
					
					
					 print class " "  "run:"$3 " failures:" $5 " errors:"$7 
				 }' \
				| tee -a $tempFile
			
		done
		
		cat $tempFile | gawk ' BEGIN {  FS = "," } ; { print $1 " " $2 " " $3 }' | \
			gawk ' BEGIN {}; 
				{
					 split($1, a, ":")
					 split($2, b, ":")
					 split($3, c, ":")
					 
					 run = a[2] + run
					 failures = b[2] + failures
					 errors = c[2] + errors
				}; 
				END { 
					print "TOTAL=> run:" run " failures:" failures " errors:" errors
				} '

		rm $tempFile
	done

}
#grep "Tests run:" $logFile | grep "Time elapsed:" -v

printHead()
{
	echo Test result summary 
	
	echo
}

main()
{
	
	cd $PROJECT_PATH
	printHead
	process_test_files
	
}

main