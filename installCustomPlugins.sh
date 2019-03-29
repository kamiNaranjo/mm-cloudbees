#!/bin/bash

PLUGINS_HOME=/var/jenkins_home/plugins
ARTIFACTORY_URL=http://10.207.24.202:8081/artifactory/jenkinsCustomPlugins
filename=$1
IFS=$'\n'
for next in $(cat $filename); do
    curl $ARTIFACTORY_URL/$next/$next.hpi -o $PLUGINS_HOME/$next.jpi
    #unzip $ARTIFACTORY_URL/$next.jpi -d $ARTIFACTORY_URL/$next
    echo "$next read from $filename"
done
exit 0
