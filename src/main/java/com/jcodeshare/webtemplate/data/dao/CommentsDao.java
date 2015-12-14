package com.jcodeshare.webtemplate.data.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;

public interface CommentsDao {
    
    void saveComments(Comments comments);
     
    List<Comments> findAllComments();
     
    void deleteCommentsById(int id);
     
    Comments findById(int id);
     
    void updateComments(Comments comments);
    
    Session getSession() ;
    
    void setSessionFactory(SessionFactory sessionFactory) ;
    
}
