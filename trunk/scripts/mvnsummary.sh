#!/bin/bash

export logFile="$3/compile.log"

echo Test result summary of $logFile 

echo

grep "Tests run:" $logFile | grep "Time elapsed:" -v

exit $salida