FROM tomcat

COPY DeltaCRMWeb-master/src/main/ /usr/local/tomcat/webapps/

CMD ["run"]
