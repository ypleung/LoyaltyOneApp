package com.jcodeshare.webtemplate.service;

import java.util.Date;
import java.lang.Integer;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.service.webdata.FormActionResult;
import com.jcodeshare.webtemplate.data.service.CommentsService;
import com.jcodeshare.webtemplate.data.service.UsersService;
import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class CommentsController {
   
    private final Logger logger = LoggerFactory.getLogger(CommentsController.class);

    
    // Autowire does not seem to work in tests so I tried putting a setter in and declaring a bean
    @Autowired
    CommentsService commentsService;
    
    @Autowired
    UsersService usersService;
    
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public FormActionResult addComment(@RequestBody FormData form, @CookieValue(value = "userCookie", defaultValue = Users.DEFAULT_USERNAME) String userCookie, HttpServletResponse response) {
        
        logger.info("Calling AddComment Action: with form: " + form);
        Users user = usersService.findByUsername(userCookie);
        logger.info("ADD COMMENT: " + user);       
        Comments comments = new Comments();
        comments.setCreateDate(new Date());
        comments.setCreateTs(new Date());
        comments.setComment(form.getComment());
        comments.setUser(user);
        try {
        String parentId = form.getParentId();
        if( parentId != null && !parentId.isEmpty()) { comments.setParentId(Integer.parseInt(parentId));  };
        } catch (Exception e) {
            logger.info("Did we throw exception here?");
        }
        
        logger.info("Calling AddComment Autowire work: " + commentsService);
        logger.info("Calling AddComment Action: created a comment entity: " + comments);
        commentsService.saveComments(comments);
        String commentId = "" + comments.getId();
        form.setCommentId(commentId);
       
        logger.info("Calling AddComment Action: saved a comment entity: " + comments);
        
        form.setUsername(userCookie);
        form.setCommentDate(comments.getCreateTs()+"");
        FormActionResult result = new FormActionResult();       
        result.setCode("200");
        result.setMsg("");
        result.setFormData(form);
        
        return result;
    }
    
    public void setCommentsService(CommentsService commentsService) {
        commentsService = commentsService;
    }
    
    public void setUsersService(CommentsService commentsService) {
        commentsService = commentsService;
    }
}
