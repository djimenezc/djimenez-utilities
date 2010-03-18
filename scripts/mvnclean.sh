#/bin/bash

export srcFolder=$1
export projects=$2
export errorLogFile=/tmp/n2a-compile-error.log
export logFile=/tmp/n2a-compile.log

trasformCommaList()
{
	echo $1 | sed -e 's/,/ /g'
}

function log()
{
    # Hechamos al /var/log/messages nuestros mensajes    
    logger "$(basename ${0})" -p local0.info "${1}"
    echo "$(date) - $(basename ${0}) - ${1} "
}

# ------------------------------------------------------------------------
function logInfo()
{
    log "[INFO]:  ${1}"
}

# ------------------------------------------------------------------------
function logError()
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
	
	
	
	for project in $projects
	do
		echo Limpiando proyecto: $project 

		cd $srcFolder/$project
		mvn clean >> $logFile
	        res=$?
		
		if [ ! $res -eq 0 ];then
			cd - 1> $errorLogFile
			logError "Compilando el proyecto $project"            
			exit -1
       		 fi
		echo Proyecto $project limpiado con éxito
       		 cd - 1> /dev/null
	done
}

main;
