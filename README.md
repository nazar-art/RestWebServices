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
         
    For matrix param use next url (add to header value - customHeaderValue => test header value):
    
         http://localhost:8080/webapi/injectdemo/annotations;param=value
         
    For access context param:
         http://localhost:8080/webapi/injectdemo/context
         
    For access message comment by id, just use:
         http://localhost:8080/webapi/messages/2/comments/2
     
##### If you are Intellij user configure only `http://localhost:8080/` 
This will be enough.  
Use `Postman` browser extension for response returning.
      