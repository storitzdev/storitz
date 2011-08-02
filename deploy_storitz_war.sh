#!/bin/sh

usage() {
  echo "Usage: `basename $0` [-e env] [-d dest] virtual_host";
}

if [ $# -lt 1 ]; then 
  usage;
  exit 1;
fi

while getopts ":e:d:" opt; do
  case $opt in
    e)
      grails_env=$OPTARG
      ;;
    d)
      dir=$OPTARG
      ;;
    :)
      echo "Error: $OPTARG requires an argument" >&2
      usage
      exit 1
      ;;
    \?)
      echo "Invalid option: -$OPTARG" >&2
      usage
      exit 1
      ;;
  esac
done
shift $((OPTIND-1))
if [ "x$@" == "x" ]; then
  echo "Error: hostname argument is required" >&2
  usage
  exit 1
fi
if [ "x$grails_env" == "x" ]; then
  grails_env=development
fi
hostname=$@
if [ "x$dir" == "x" ]; then
  dest="$HOME/tomcat-current/$hostname"
else
  dest="$HOME/tomcat-current/$dir"
fi

echo "DEPLOYING .war"
echo "  src: src/$hostname"
echo "  destination: $dest"
echo "  env: $grails_env"
sleep 2

cd ~/src/$hostname
svn up
echo -n "Compiling ... "
output=`grails -Dgrails.env=$grails_env war`
if [ $? -eq 0 ]; then 
  echo "done."
else
  echo "failed."
  echo $ouput
  exit $?
fi
cp target/storitz-0.1.war $dest/ROOT.war
if [ ! -d $dest/ROOT ]; then
  mkdir $dest/ROOT
fi
cd $dest/ROOT
echo -n "Unarchiving .war file ... "
output=`jar xf ../ROOT.war`
if [ $? -eq 0 ]; then 
  echo "done."
else
  echo "failed."
  echo $ouput
  exit $?
fi
echo "Application deployed to $dest/ROOT. Please restart tomcat."
