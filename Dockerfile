FROM cloudbees/cloudbees-core-mm:2.150.2.3

LABEL maintainer "devopssura@suramericana.com.co"

USER root

ARG user=jenkins

#skip setup wizard and disable CLI
ENV JVM_OPTS -Djenkins.CLI.disabled=true -server
ENV TZ="/usr/share/zoneinfo/America/New_York"

RUN mkdir -p /usr/share/jenkins/ref/init.groovy.d
RUN mkdir -p /usr/share/jenkins/ref/config

#Jenkins system configuration via init groovy scripts - see https://wiki.jenkins-ci.org/display/JENKINS/Configuring+Jenkins+upon+start+up
COPY ./init.groovy.d/* /usr/share/jenkins/ref/init.groovy.d/
COPY ./license-activated/* /usr/share/jenkins/ref/license-activated-or-renewed-after-expiration.groovy.d/
COPY ./quickstart/* /usr/share/jenkins/ref/quickstart.groovy.d/
COPY ./config/* /usr/share/jenkins/ref/config/

#install suggested and additional plugins
ENV JENKINS_UC http://jenkins-updates.cloudbees.com

#config-as-code plugin configuration
COPY config-as-code.yml /usr/share/jenkins/config-as-code.yml
ENV CASC_JENKINS_CONFIG /usr/share/jenkins/config-as-code.yml

#install suggested and additional plugins
ENV JENKINS_UC http://jenkins-updates.cloudbees.com
ENV TRY_UPGRADE_IF_NO_MARKER=true

RUN mkdir -p /usr/share/jenkins/ref/plugins
RUN chown -R ${user} /usr/share/jenkins/ref

USER ${user}

COPY ./jenkins_ref /usr/share/jenkins/ref
COPY plugins.txt plugins.txt
COPY customPlugins.txt customPlugins.txt
COPY jenkins-support /usr/local/bin/jenkins-support
COPY install-plugins.sh /usr/local/bin/install-plugins.sh
COPY installCustomPlugins.sh /usr/local/bin/installCustomPlugins.sh
RUN /usr/local/bin/install-plugins.sh $(cat plugins.txt)
RUN /usr/local/bin/installCustomPlugins.sh customPlugins.txt

