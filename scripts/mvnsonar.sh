#/bin/bash

export srcFolder=$1
export projects=$2
export errorLogFile=$3/compile-error.log
export logFile=$3/compile.log

trasformCommaList()
{
	echo $1 | sed -e 's/,/ /g'
}

log()
{
    # Hechamos al /var/log/messages nuestros mensajes    
    logger "$(basename ${0})" -p local0.info "${1}"
    echo "$(date) - $(basename ${0}) - ${1} "
}

# ------------------------------------------------------------------------
logInfo()
{
    log "[INFO]:  ${1}"
}

# ------------------------------------------------------------------------
logError()
{
    log "[ERROR]: ${1}"
    exit 1
}

main()
{
	
	projects=$(trasformCommaList "$projects")
	
	if [ -d $projectDir/src ]; then
		rm $logFile
		rm $erroLogFile
	fi
	touch $errorLogFile
	touch $logFile
	
	
		echo Analizando proyecto 

		cd $srcFolder
		mvn sonar:sonar -Dmaven.test.skip=true >> $logFile
	        res=$?
		
		if [ ! $res -eq 0 ];then
			cd - 1> $errorLogFile
			logError "Analizando el proyecto $project"            
			exit -1
       	fi
       	
		echo Proyecto $project analizado con éxito
       		 cd - 1> /dev/null
}

echo $PATH

main;
