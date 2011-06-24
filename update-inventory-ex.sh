#!/bin/sh
# Update Inventory Extraspace

ENVNAME=$1

if test "$ENVNAME" = ""; then
    echo "usage: update-inventory-ex.sh [development|preview|production]"
    exit 1
fi

set `date`
DATE=$6-$2-$3

# Used only as a last resort if the regular JRE has linkage errors.
#export JAVA_HOME=/home/deploy/jre.invload

# JAVA_OPTS is picked up by grails automatically.
export JAVA_OPTS="-XX:PermSize=256m -XX:MaxPermSize=384m -Xms512m -Xmx1024m -XX:-UseGCOverheadLimit"

PIDFILE=/tmp/update.pid
EMAILFILE=/tmp/update.email
HOST=`hostname`

if test -f "$PIDFILE"; then
    echo "ENVNAME=$ENVNAME" > $EMAILFILE
    echo "process is already running with PID=`cat $PIDFILE`" >> $EMAILFILE
    echo "If you are sure there is no running process then delete $PIDFILE and retry" >> $EMAILFILE
    /bin/mail -s "$ENVNAME ($HOST): Unable to begin extraspace inventory update" tech@storitz.com < $EMAILFILE
    rm $EMAILFILE
    exit 1
fi

# Save our pid to PIDFILE
echo $$ > $PIDFILE

cd /home/deploy/src/storitz

$GRAILS_HOME/bin/grails -Dgrails.env=${ENVNAME}_script run-script scripts/UpdateInventoryExScript.groovy > /home/deploy/logs/UpdateInventoryEx.${ENVNAME}.${DATE}.log 2>&1

# Clean up after ourselves
rm $PIDFILE
