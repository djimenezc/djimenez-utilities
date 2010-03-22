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
		echo Compilando proyecto: $project 

		cd $srcFolder/$project
 		mvn install >> $logFile
	        res=$?
		
		if [ ! $res -eq 0 ];then
			cd - 1>> $logFile
			logError "Compilando el proyecto $project"            
			echo Mirar la traza del error en $logFile
			exit -1
       		 fi
# 		echo Proyecto $project compilado con éxito
       		 cd - 1> /dev/null
	done
}

main;
