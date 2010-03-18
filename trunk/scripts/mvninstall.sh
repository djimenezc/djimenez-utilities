#/bin/bash


# export PATH=$PATH:/home/djc001es/programs/maven-2.2.1/bin
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
