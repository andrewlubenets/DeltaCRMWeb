FROM tomcat

ADD DeltaCRMWeb-master/src/main/DeltaCRMWeb-master.war /usr/local/tomcat/webapps/myapp.war

CMD ["run"]
