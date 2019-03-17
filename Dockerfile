FROM tomcat:8.0.20-jre8

COPY DeltaCRMWeb-master/src/main/DeltaCRMWeb-master.war /usr/local/tomcat/webapps/myapp.war
