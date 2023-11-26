FROM openjdk:11
EXPOSE 8080
RUN mkdir /home/app
#ADD grocery/target/grocery.jar grocery.jar
COPY build/libs/grocery-0.0.1-SNAPSHOT.jar  grocery.jar
ENTRYPOINT ["java","-jar","grocery.jar"]