#!/bin/sh
# Update Phones

set `date`
DATE=$6-$2-$3

# Important!!! Change this to preview or production, as appropriate
ENVNAME=

if test "$ENVNAME" = ""; then
    echo "ENVNAME is not set!"
    return 1
fi

# Make sure these are correct for your environment
export JAVA_HOME=/usr/java/latest
export GRAILS_HOME=/home/deploy/grails-1.3.6

PIDFILE=/tmp/update.pid

if test -f "$PIDFILE"; then
	echo "process is already running with PID=`cat $PIDFILE`"
	echo "If you are sure there is no running process then delete $PIDFILE and retry"
	exit 1
fi

# Save our pid to PIDFILE
echo $$ > $PIDFILE

cd /home/deploy/projects/storitz


$GRAILS_HOME/bin/grails -Dgrails.env=${ENVNAME}_script run-script scripts/UpdatePhoneScript.groovy > /home/deploy/logs/UpdatePhone.${DATE}.log 2>&1

# Clean up after ourselves
rm $PIDFILE
