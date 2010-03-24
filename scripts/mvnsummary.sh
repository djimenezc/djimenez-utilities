#!/bin/bash

export logFile="$3/compile.log"

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
			
			cat $projectFolder/$testFile
			echo
		done
		
		echo -------------------------------------------------------------------------------
		echo
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