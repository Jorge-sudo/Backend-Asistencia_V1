FROM openjdk:17-jdk
COPY target/asistencia-0.0.1-SNAPSHOT.war asistencia.war
RUN mkdir uploads
VOLUME /uploads
COPY /uploads /uploads
COPY /target/classes/certificadoSSL.p12 certificadoSSL.p12
ENTRYPOINT ["java","-jar","/asistencia.war"]