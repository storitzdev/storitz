#!/bin/sh
# Update Inventory Extraspace

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

# JAVA_OPTS is picked up buy grails automatically. The default memory that
# grails allocates to Java is not enough to handle the Extraspace string processing requirements.
export JAVA_OPTS="-XX:PermSize=256m -XX:MaxPermSize=384m -Xms512m -Xmx1024m -XX:-UseGCOverheadLimit -Dcom.sun.management.jmxremote.port=9595 -Dcom.sun.management.jmxremote.password.file=/home/deploy/jmxremote.password"

PIDFILE=/tmp/update.pid
EMAILFILE=/tmp/update.email

if test -f "$PIDFILE"; then
    echo "ENVNAME=$ENVNAME" > $EMAILFILE
	echo "process is already running with PID=`cat $PIDFILE`" >> $EMAILFILE
	echo "If you are sure there is no running process then delete $PIDFILE and retry" >> $EMAILFILE
    /bin/mail -s "Unable to begin inventory update" tech@storitz.com < $EMAILFILE
    rm $EMAILFILE
	exit 1
fi

# Save our pid to PIDFILE
echo $$ > $PIDFILE

cd /home/deploy/projects/storitz

# Extraspace only: We already automatically update promotions along with inventory as part of the ExrsService.
#                  There is no need to run that in a separate process here.
$GRAILS_HOME/bin/grails -Dgrails.env=${ENVNAME}_script run-script scripts/UpdateInventoryExScript.groovy > /home/deploy/logs/UpdateInventoryEx.${DATE}.log 2>&1

# Clean up after ourselves
rm $PIDFILE
