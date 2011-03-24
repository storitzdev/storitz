#!/bin/sh
# update inventory

set `date`
DATE=$6-$2-$3
PIDFILE=/tmp/update-inventory.pid

# Important. Change this to preview or production, as appropriate
ENVNAME=

if test "$ENVNAME" = ""; then
    echo "ENVNAME is not set!"
    return 1
fi

export GRAILS_HOME=/home/deploy/grails-1.3.6

if test -f "$PIDFILE"; then
	echo "process is already running with PID=`cat $PIDFILE`"
	echo "If you are sure there is no running process then delete $PIDFILE and retry"
	exit 1
fi

# save our pid to PIDFILE
echo $$ > $PIDFILE

cd /home/deploy/projects/storitz
$GRAILS_HOME/bin/grails -Dgrails.env=${ENVNAME}_script run-script scripts/UpdateInventoryScript.groovy > /home/deploy/logs/UpdateInventory.${DATE}.log 2>&1

rm $PIDFILE
