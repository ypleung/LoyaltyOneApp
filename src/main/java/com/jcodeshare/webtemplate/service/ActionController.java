package com.jcodeshare.webtemplate.service;

import java.util.Date;

import com.jcodeshare.webtemplate.data.model.Users;
import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.service.webdata.FormActionResult;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class ActionController {

    @RequestMapping(value = "/getText")
    public FormActionResult returnInputForm(@RequestBody FormData form) {
        
        FormActionResult result = new FormActionResult();       
        result.setCode("200");
        result.setMsg("");
        result.setFormData(form);
        return result;

    }
    
    @RequestMapping(value = "/users")
    public FormActionResult seeUsers(@RequestBody FormData form) {
        
        FormActionResult result = new FormActionResult();       
        result.setCode("200");
        result.setMsg("");
        result.setFormData(form);
        return result;

    }

}


