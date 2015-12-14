package com.jcodeshare.webtemplate.data.service;

import java.util.List;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;
 
public interface CommentsService {
    
    void saveComments(Comments Comments);
    
    List<Comments> findAllComments();
 
    void deleteCommentsById(int id);
 
    Comments findById(int id);
 
    void updateComments(Comments Comments);
    
}
