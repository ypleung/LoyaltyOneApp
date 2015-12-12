package com.jcodeshare.webtemplate.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;

import com.jcodeshare.webtemplate.data.dao.CommentsDao;
import com.jcodeshare.webtemplate.data.model.Comments;

@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
    
    // Cannot get autowire working here!
    @Autowired
    @Qualifier("commentsDao")
    CommentsDao dao;
     
    public void saveComments(Comments comments) {
        dao.saveComments(comments);
    }

    public List<Comments> findAllComments() {
        return dao.findAllComments();
    }

    public void deleteCommentsById(int id) {
        dao.deleteCommentsById(id);
    }

    public Comments findById(int id) {
        return dao.findById(id);
    }

    public List<Comments> findByUserId(int userId) {
        return dao.findByUserId(userId);
    }
    
    public void updateComments(Comments comments){
        dao.updateComments(comments);
    }
    
    public void setDao(CommentsDao dao){
        this.dao = dao;
    }

}
