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
      dest=$OPTARG
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
hostname=$@
if [ "x$dest" == "x" ]; then
  dest=$hostname
fi
if [ "x$grails_env" == "x" ]; then
  grails_env=development
fi

echo "Deploying latest revision of storitz.com .war files"
echo "  src: $HOME/src/$hostname"
echo "  destination: $HOME/tomcat-instances/*/$dest"
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

echo "Deploying .war file to Tomcat instances:"
for server in `ls -1 $HOME/tomcat-instances/`; do
  dir="$HOME/tomcat-instances/$server/$dest"
  echo -n "  $dir ... "
  cp $HOME/src/$hostname/target/storitz-0.1.war $dir/ROOT.war
  if [ $? -ne 0 ]; then
    exit $?;
  fi
  if [ ! -d $dir/ROOT ]; then
    mkdir $dir/ROOT
    if [ $? -ne 0 ]; then
      exit $?;
    fi
  fi
  cd $dir/ROOT
  output=`jar xf ../ROOT.war`
  if [ $? -eq 0 ]; then
    echo "done."
  else
    echo "failed."
    echo $ouput
    exit $?
  fi
done
echo "Deployment complete. Tomcat instances may be restarted."
