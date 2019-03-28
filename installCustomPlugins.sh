#!/bin/bash

PLUGINS_HOME=/tmp
ARTIFACTORY_URL=https://artifactory-labo.suramericana.com.co/artifactory/jenkinsCustomPlugins
filename=$1
IFS=$'\n'
for next in $(cat $filename); do
    curl $ARTIFACTORY_URL/$next/$next.hpi -o $PLUGINS_HOME/$next.jpi
    unzip $ARTIFACTORY_URL/$next.jpi -d $ARTIFACTORY_URL/$next
    echo "$next read from $filename"
done
exit 0
