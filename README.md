### For running you  need to run Apache Tomcat and follow next application url (for Eclipse IDE):

    http://localhost:8080/messenger2/
    
For access resources:    
    
    http://localhost:8080/messenger2/webapi/myresource
    
For access message info by Id:
     
     http://localhost:8080/messenger2/webapi/messages/1
     
For extracting all messages by specified year use:

     http://localhost:8080/messenger2/webapi/messages?year=2015
     
For extracting all messages by specified pagination:

     http://localhost:8080/webapi/messages?start=1&size=1
     
##### If you are Intellij user configure only `http://localhost:8080/`. This will be enough.
Use `Postman` browser extension for response returning.
      