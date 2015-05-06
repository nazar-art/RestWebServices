package com.lelyak.resources;

import com.lelyak.model.Message;
import com.lelyak.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
//    @Produces(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages() {
        return messageService.getAllMessages();
    }

    @GET
    @Path("/{messageId}")
//    @Produces(MediaType.APPLICATION_XML)
    public Message getMessage(@PathParam("messageId") long id) {
        return messageService.getMessage(id);
//		return "Got path param: " + messageId;
    }

    @POST
    public Message addMessage(Message message) {
        // return "POST works";
        return messageService.addMessage(message);
    }

    @PUT
    @Path("/{messageId}")
    public Message updateMessage(@PathParam("messageId") long id, Message message) {
        message.setId(id); // update message with id from url
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public void deleteMessage(@PathParam("messageId") long id, Message message) {
        messageService.removeMessage(id);
    }

}
