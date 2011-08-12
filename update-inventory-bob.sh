#!/bin/sh
# Update Inventory for Uncle Bob's

ENVNAME=$1

if test "$ENVNAME" = ""; then
    echo "usage: update-inventory-bob.sh [development|preview_bob|production_bob]"
    exit 1
fi

set `date`
DATE=$6-$2-$3

# Running as cron we don't automatically get the local shell environment.
source /home/deploy/.bash_profile

# Used only as a last resort if the regular JRE has linkage errors.
export JAVA_HOME=/home/deploy/jre.invload

# JAVA_OPTS is picked up by grails automatically.
export JAVA_OPTS="-XX:PermSize=256m -XX:MaxPermSize=384m -Xms768m -Xmx1536m -XX:-UseGCOverheadLimit"

PIDFILE=/tmp/update-bob.pid
EMAILFILE=/tmp/update-bob.email
HOST=`hostname`

if test -f "$PIDFILE"; then
    echo "ENVNAME=$ENVNAME" > $EMAILFILE
    echo "process is already running with PID=`cat $PIDFILE`" >> $EMAILFILE
    echo "If you are sure there is no running process then delete $PIDFILE and retry" >> $EMAILFILE
    /bin/mail -s "$ENVNAME ($HOST): Unable to begin Uncle Bob's inventory update" tech@storitz.com < $EMAILFILE
    rm $EMAILFILE
    exit 1
fi

# Save our pid to PIDFILE
echo $$ > $PIDFILE

cd /home/deploy/src/storitz.`echo ${ENVNAME} | sed 's/_bob//g'`

$GRAILS_HOME/bin/grails -Dgrails.env=${ENVNAME}_script run-script scripts/UpdateInventoryBobScript.groovy > /home/deploy/logs/UpdateInventoryBob.${ENVNAME}.${DATE}.log 2>&1

# Clean up after ourselves
/bin/rm $PIDFILE
