package com.jcodeshare.webtemplate.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jcodeshare.webtemplate.data.model.Users;

@Controller
/*
 * Default Static Page Controller
 */
public class PageController {
    
    private final Logger logger = LoggerFactory.getLogger(CommentsController.class);
    private final static String userCookie = "username";
    
    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String getHome(HttpServletRequest request, ModelMap model, @CookieValue(value = "userCookie", defaultValue = Users.DEFAULT_USERNAME) String userCookie, HttpServletResponse response) {
        // Waste cookie on page reload.
        response.addCookie(new Cookie("userCookie", Users.DEFAULT_USERNAME));
        return getPage(request,model);
    }
    
    @RequestMapping(value = "/comments", method = { RequestMethod.GET, RequestMethod.POST })
    public String getCommentsSection(HttpServletRequest request, ModelMap model) {
        logger.info("In PageController.getCommentsSection");
        return getPage(request,model);
    }
    
    public String getPage(HttpServletRequest request, ModelMap model) {
        String section = (String) request.getParameter("section");
        logger.info("In PageController.getPage get section variable: '" + section + "'");
        if ((section == null) || section.length() == 0)
            section = "index";
        return section;
    }
}

// # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php 

