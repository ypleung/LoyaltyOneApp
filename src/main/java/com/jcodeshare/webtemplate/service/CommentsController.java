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
import com.jcodeshare.webtemplate.data.model.Location;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;

@RestController
public class CommentsController {
   
    private final Logger logger = LoggerFactory.getLogger(CommentsController.class);

    
    // Autowire does not seem to work in tests so I tried putting a setter in and declaring a bean
    @Autowired
    CommentsService commentsService;
    
    @Autowired
    UsersService usersService;
    
    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public FormActionResult addComment(@RequestBody FormData form, 
            @CookieValue(value = "userCookie", defaultValue = Users.DEFAULT_USERNAME) String userCookie, 
            @CookieValue(value = "cookieCity") String cookieCity, 
            @CookieValue(value = "cookieLat") String cookieLat, 
            @CookieValue(value = "cookieLong") String cookieLong,
            @CookieValue(value = "cookieTemp") String cookieTemp, 
            HttpServletResponse response) {
        
        Location location = null;
        if ((cookieCity != null) && (cookieCity.length() > 0)) {
            location = new Location();
            location.setCity(cookieCity);
            location.setLatitude(Float.parseFloat(cookieLat));
            location.setLongitude(Float.parseFloat(cookieLong));
            location.setTemperature(Float.parseFloat(cookieTemp));
        }
        
        //logger.info("ADD COMMENT: " + form);
        Users user = usersService.findByUsername(userCookie);
        //logger.info("ADD COMMENT: " + user);
        Comments comments = new Comments();
        comments.setCreateDate(new Date());
        comments.setCreateTs(new Date());
        comments.setComment(form.getComment());
        comments.setUser(user);
        
        if (location != null) { comments.setLocation(location); }  
        
        try {
            String parentId = form.getParentId();
            if (parentId != null && !parentId.isEmpty()) {
                comments.setParentId(Integer.parseInt(parentId));
            }
        } catch (Exception e) {
            logger.info("Did we throw exception here?");
        }
        
        //logger.info("ADD COMMENT: " + comments);
        //logger.info("ADD COMMENT LOCATION: " + comments.getLocation());
        commentsService.saveComments(comments);
        String commentId = "" + comments.getId();
        form.setCommentId(commentId);
       
        //logger.info("Calling AddComment Action: saved a comment entity: " + comments);
        
        form.setUsername(userCookie);
        form.setCommentDate(comments.getCreateTs()+"");
        if (comments.getLocation() != null) {

            form.setCity(location.getCity());
            form.setLatitude(location.getLatitude()+"");
            form.setLongitude(location.getLongitude()+"");
            form.setTemperature(location.getTemperature()+"");
            //logger.info("ADD COMMENT SETTING CITY: " + form.getCity());
        }
        FormActionResult result = new FormActionResult();       
        result.setCode("200");
        result.setMsg("");
        result.setFormData(form);
        Gson gson = new Gson();
        gson.toJson(result);
        
        
        return result;
    }
    
    public void setCommentsService(CommentsService commentsService) {
        commentsService = commentsService;
    }
    
    public void setUsersService(CommentsService commentsService) {
        commentsService = commentsService;
    }
}
