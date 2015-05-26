package com.lelyak.service;

import com.lelyak.database.DatabaseClass;
import com.lelyak.model.Comment;
import com.lelyak.model.ErrorMessage;
import com.lelyak.model.Message;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CommentService {

    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public List<Comment> getAllComments(long messageId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return new ArrayList<>(comments.values());
    }

    public Comment getComment(long messageId, long commentId) {
        ErrorMessage errorMessage = new ErrorMessage("Not found", 404, "https://plus.google.com/u/0/109535268464217373186/posts"); // sent link to my Google+ page
        Response res = Response.status(Response.Status.NOT_FOUND)
                .entity(errorMessage)
                .build();

        Message message = messages.get(messageId);
        if (message == null) {
//            throw new WebApplicationException(res);
            throw new NotFoundException(res);
        }
        Map<Long, Comment> comments = message.getComments();
        Comment comment = comments.get(commentId);
        if (comment == null) {
//            throw new WebApplicationException(Response.Status.NOT_FOUND);
//            throw new WebApplicationException(res);
            throw new NotFoundException(res);
        }
        return comment;
    }

    public Comment addComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        comment.setId(comments.size() + 1);
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment updateComment(long messageId, Comment comment) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        if (comment.getId() <= 0) {
            return null;
        }
        comments.put(comment.getId(), comment);
        return comment;
    }

    public Comment removeComment(long messageId, long commentId) {
        Map<Long, Comment> comments = messages.get(messageId).getComments();
        return comments.remove(commentId);
    }

}
