#!/bin/bash

export logFile="$3/compile.log"
export tempFile="/tmp/awkTemp.tmp"
export generalTestFile="/tmp/generalTestTemp.tmp"


PROJECT_PATH=$1

addTest()
{
	cat $1 | gawk ' BEGIN {  FS = "," } ; { print $1 " " $2 " " $3 }' | \
		gawk ' BEGIN {}; 
			{
				 split($2, a, ":")
				 split($3, b, ":")
				 split($4, c, ":")
				 
				 run = a[2] + run
				 failures = b[2] + failures
				 errors = c[2] + errors
			}; 
			END { 
				
				print "=> run:" run " failures:" failures " errors:" errors
			} '
	
}

process_test_files()
{

	PATH_PROJECT_TESTED=`find -name surefire-reports`
	
	touch $generalTestFile
	
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
		
		
		echo Total: $(addTest "$tempFile")

		cat $tempFile >> $generalTestFile
		rm $tempFile
	done

	
	totalResult=$(addTest "$generalTestFile")
	echo Total Result: $totalResult
	
	rm $generalTestFile
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