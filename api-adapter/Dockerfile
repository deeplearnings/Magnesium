FROM 10.30.80.105:8089/base-image-jdk8-maven


ARG PROJECT_PROFILE
ARG PROJECT_WEB_PATH


ADD . /temp

RUN /dependency/apache-maven-3.5.4/bin/mvn clean install -f /temp/pom.xml  -P ${PROJECT_PROFILE}  && \
    mkdir /app && \
    mv /temp/${PROJECT_TAR_PATH}/target/server-${PROJECT_PROFILE}.tar.gz /app && \
    tar -zxvf /app/${PROJECT_TAR_PATH}/target/server-${PROJECT_PROFILE}.tar.gz && \
    rm -rf /app/${PROJECT_TAR_PATH}/target/server-${PROJECT_PROFILE}.tar.gz && \
    rm -rf /temp
