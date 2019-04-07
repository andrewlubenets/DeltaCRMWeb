FROM tomcat

COPY ./src/main/ /usr/local/tomcat/webapps/

CMD ["run"]
