package com.jcodeshare.webtemplate.service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;
import com.jcodeshare.webtemplate.data.service.CommentsService;
import com.jcodeshare.webtemplate.data.service.UsersService;
import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.service.webdata.FormActionResult;

import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UsersController {

    private final Logger logger = LoggerFactory
            .getLogger(CommentsController.class);
    private final static String userCookie = "username";

    // Autowire does not seem to work in tests so I tried putting a setter in
    // and declaring a bean
    @Autowired
    UsersService userService;
    
    @Autowired
    CommentsService commentService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public FormActionResult userLogin(
            @RequestBody FormData form,
            @CookieValue(value = "userCookie", defaultValue = Users.DEFAULT_USERNAME) String userCookie,
            HttpServletResponse response) {

        Users user = userService.findByUsername(form.getUsername());

        String loginMsg = "Failed to login.";
        String code = "300";
        logger.info("User: " + user);
        logger.info("Form: " + form);
        
        if ((user != null) && (user.getId() > 0)) {
            if (user.getPassword().equals(form.getPassword())) {
                response.addCookie(new Cookie("userCookie", user.getUsername()));
                loginMsg = "Login Successful";
                code = "200";
            }
        }

        FormActionResult result = new FormActionResult();
        result.setCode(code);
        result.setMsg(loginMsg);
        result.setFormData(form);
        return result;

    }
    
    @RequestMapping(value = "/getUserComments", method = RequestMethod.POST)
    public FormActionResult userRegister(
            @RequestBody FormData form,
            @CookieValue(value = "userCookie", defaultValue = Users.DEFAULT_USERNAME) String userCookie,
            HttpServletResponse response) {

        Users user = userService.findByUsername(form.getUsername());
        List comments = userService.findAllComments(user);
        
        logger.info("User: " + user);
        logger.info("Form: " + form);
        String code = "200";
        
        FormActionResult result = new FormActionResult();
        result.setCode(code);
        //result.setUserComments(comments);
        result.setFormData(form);
        return result;

    }

    
}
