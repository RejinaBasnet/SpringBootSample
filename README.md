# SpringBootSample

This is a simple spring boot demo that let's lets you perform simple CRUP operation using RESTful web services. It was developed using spring started web project. Maven has been utilized for dependency management.

## To run the application:
 ### Setup the data source
    You should edit the username and password for your data based server in the file application.yml to setup the project with your datasource. I have used mysql server, however you can change the configurations to use your favourite server. The project internally should be fine with whatever you use as it user JPA interfaces.
 ### Perform following command in your terminal 
    mvn spring-boot:run
 
 
 After the application has started visit localhost:8080 and provide appropriate Http request to check for the responses. The responses are in JSON.
 
 
  
