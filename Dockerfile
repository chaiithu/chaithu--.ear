FROM jboss/wildfly
LABEL maintainer "chaithu"
WORKDIR /chaithu
COPY **/*.ear ./
CMD ["/opt/jboss/wildfly/bin/standalone.sh","-b","0.0.0.0"]