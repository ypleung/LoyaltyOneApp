package com.jcodeshare.webtemplate.service;

import com.jcodeshare.webtemplate.service.ActionController;
import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.service.webdata.FormActionResult;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:loyaltyservice-test.xml" })
public class ActionControllerTest {

    @Autowired
    ActionController actionController;
    
    private MockMvc mockMvc;
    private final Logger logger = LoggerFactory.getLogger(ActionControllerTest.class);


    @Test
    public void testGetText() throws Exception {
        String inputString = "hello world!";
        FormData data = new FormData();
        data.setComment(inputString);
        
        mockMvc = MockMvcBuilders.standaloneSetup(
           new ActionController()).build();
        MvcResult result = this.mockMvc.perform(get("/getText").contentType(MediaType.APPLICATION_JSON).content(data.toString()))
           .andExpect(status().isOk()).andReturn();
        String returnString = result.getResponse().getContentAsString();        
        ObjectMapper objectMapper = new ObjectMapper();
        logger.info("Call to /getText returned: " +returnString);
         
        //convert json string to object
        FormActionResult returnData = objectMapper.readValue(returnString.getBytes(), FormActionResult.class);
        String expectedString = returnData.getFormData().getComment();
        logger.debug("COMMENT ADDED: " + expectedString);
        
        assertTrue("Expected data: \"" + inputString + "\"  actual data=\"" + expectedString + "\" ", 
                inputString.equals(expectedString));
        
        
        
        
    }
}
