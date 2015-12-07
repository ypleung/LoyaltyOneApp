package com.jcodeshare.webtemplate.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
/*
 * Default Static Page Controller
 */
public class HomeController {

    
    @RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
    public String getHome(HttpServletRequest request, ModelMap model) {
        return getPage(request,model);
    }
    
    @RequestMapping(value = "/about", method = { RequestMethod.GET, RequestMethod.POST })
    public String getAbout(HttpServletRequest request, ModelMap model) {
        return getPage(request,model);
    }
    
    @RequestMapping(value = "/contact", method = { RequestMethod.GET, RequestMethod.POST })
    public String getContact(HttpServletRequest request, ModelMap model) {
        return getPage(request,model);
    }
    
    @RequestMapping(value = "/projects", method = { RequestMethod.GET, RequestMethod.POST })
    public String getProjects(HttpServletRequest request, ModelMap model) {
        return getPage(request,model);
    }
    
    public String getPage(HttpServletRequest request, ModelMap model) {
        String section = (String) request.getParameter("section");
        if ((section == null) || section.length() == 0)
            section = "index2";
        return section;
    }
}

// # Copyright by YP Leung, 2015 Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php 

