FROM amazoncorreto:11-alpine-jdk //de que imagen de java partimos
MAINTAINER JIC //dueño de la imagen
COPY target/portfolio-0.0.1-SNAPSHOT.jar jic-app.jar    //va a copiar el empaquetado del proyecto a github
ENTRYPOINT ["java","-jar","/jic-app.jar"]    //es la instruccion que se va a ejecutar primero
