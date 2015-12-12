package com.jcodeshare.webtemplate.service.webdata;

public class FormData {
    String comment;
    String username;
    String commentId;
    String parentId;
    String nesting;
    String password;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
      
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }
    
    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
    
    public String getNesting() {
        return nesting;
    }

    public void setNesting(String nesting) {
        this.nesting = nesting;
    }
    
    @Override
    public String toString() {
        return "{ \"comment\": \"" + comment + 
                  "\" , \"username\": \"" + username + 
                  "\" , \"password\": \"" + password + 
                  "\" , \"parentId\": \"" + parentId +
                  "\" , \"nesting\": \"" + nesting +
                  "\" , \"commentId\": \"" + commentId +  "\" }";
    }

    
}
