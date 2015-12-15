package com.jcodeshare.webtemplate.service;

import com.jcodeshare.webtemplate.service.CommentsController;
import com.jcodeshare.webtemplate.service.webdata.FormData;
import com.jcodeshare.webtemplate.service.webdata.FormActionResult;

import org.junit.Before;
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

import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

//import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
//import org.codehaus.jackson.map.annotate.JsonSerialize;
import com.fasterxml.jackson.annotation.JsonInclude;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ser.std.NullSerializer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:loyaltyservice-test.xml" })
@WebAppConfiguration
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class })
public class CommentsControllerTest {

    @Autowired
    CommentsController commentsController;
    
    private MockMvc mockMvc;
    
    //@Resource
    //private FilterChainProxy springSecurityFilterChain;
    
    @Resource
    private WebApplicationContext webApplicationContext;
 
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//                .addFilter(springSecurityFilterChain)
                .build();
    }
    private final Logger logger = LoggerFactory.getLogger(CommentsControllerTest.class);

    @Test
    public void testGetText() throws Exception {
        String inputString = "Comment 1 added to Database";
        FormData data = new FormData();
        data.setComment(inputString);
        
//        mockMvc = MockMvcBuilders.standaloneSetup(
//           new CommentsController()).build();

        this.mockMvc.perform(
                   post("/addComment").contentType(MediaType.APPLICATION_JSON).content(data.toString())
                   );
        
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_NULL_MAP_VALUES, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        //mapper.getSerializerProvider().setNullValueSerializer(new MyNullKeySerializer());
        
        logger.info("JSON STRING: \n" +data.toString());
        logger.info("JSON JACKSON: \n" + mapper.writeValueAsString(data));
//        NEED TO FIGURE OUT how to handle nested @autowired
//        MvcResult result = this.mockMvc.perform(post("/addComment")
//                .contentType(new 
//                        MediaType(
//                                MediaType.APPLICATION_JSON.getType(), 
//                                MediaType.APPLICATION_JSON.getSubtype(), 
//                                Charset.forName("utf8"))
//                )
//                .contentType(MediaType.APPLICATION_JSON)
//                .accept(MediaType.APPLICATION_JSON)
//                .content(
//                        mapper.writeValueAsBytes(data)
//                        )
//                ).andExpect(status().isOk()).andReturn();

//        String returnString = result.getResponse().getContentAsString(); 
//        logger.info("Call to /addComment returned: " +returnString);
//        ObjectMapper objectMapper = new ObjectMapper();
         
        //convert json string to object
//        FormActionResult returnData = objectMapper.readValue(returnString.getBytes(), FormActionResult.class);
//        String expectedString = returnData.getFormData().getComment();
//        logger.debug("COMMENT ADDED: " + expectedString);
//        
//        assertTrue("Expected data: \"" + inputString + "\"  actual data=\"" + expectedString + "\" ", 
//                inputString.equals(expectedString));
              
    }
    
    class MyNullKeySerializer extends JsonSerializer<Object>
    {
      @Override
      public void serialize(Object nullKey, JsonGenerator jsonGenerator, SerializerProvider unused) 
          throws IOException, JsonProcessingException
      {
        jsonGenerator.writeFieldName("");
      }
    }
    

}

