package com.jcodeshare.webtemplate.data.service;

import com.jcodeshare.webtemplate.data.service.CommentsService;
import com.jcodeshare.webtemplate.data.model.Users;
import com.jcodeshare.webtemplate.data.model.Comments;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:loyaltyservice-test.xml" })
public class CommentsServiceTest extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    CommentsService service;

    @Autowired
    UsersService userService;
    
    private final Logger logger = LoggerFactory
            .getLogger(CommentsServiceTest.class);

    @Test
    public void testCommentsService() throws Exception {

        Users user = userService.findById(Users.DEFAULT_USER_ID);
        /*
         * Create a comment1
         */
        String postComment = "CommentsServiceTest: blah for comment 1";
        Comments comments1 = new Comments();
        comments1.setCreateDate(new Date());
        comments1.setCreateTs(new Date());
        comments1.setComment(postComment);
        comments1.setUser(user);

        /*
         * Create comment2
         */
        String postComment2 = "CommentsServiceTest: blah for comment 2";
        Comments comments2 = new Comments();
        comments2.setCreateDate(new Date());
        comments2.setCreateTs(new Date());
        comments2.setComment(postComment2);
        comments2.setUser(user);

        /*
         * Persist both Comments
         */
        service.saveComments(comments1);
        service.saveComments(comments2);

        logger.info("What is user.id: " + user.getId());
        /*
         * Get all Comments list from database
         */
        List<Comments> allComments = userService.findAllComments(user);
        for (Comments comment : allComments) {

            if (comment.getId() == comments1.getId()) { assertTrue("commentsService.findByUser() found comment 1: " + comments1,  comments1.getComment().equals(postComment)); }
            if (comment.getId() == comments2.getId()) { assertTrue("commentsService.findByUser() found comment 2: " + comments2,  comments2.getComment().equals(postComment2)); }
        }        


        /*
         * Get all Comments list from database
         */
        allComments = service.findAllComments();
        boolean comment1Added = false;
        boolean comment2Added = false;
        for (Comments comment : allComments) {
            
            if (comment.getId() == comments1.getId()) { comment1Added = true; }
            if (comment.getId() == comments2.getId()) { comment2Added = true; }
        }
        assertTrue("commentsService.saveUser() did not save comment1: " + comments1, comment1Added);
        assertTrue("commentsService.saveUser() did not save comment2: " + comments2, comment2Added);

        /*
         * delete an comment
         */
        service.deleteCommentsById(comments1.getId());
        
        allComments = service.findAllComments();
        comment1Added = false;
        for (Comments comment : allComments) {

            if (comment.getId() == comments1.getId()) { comment1Added = true; }
            if (comment.getId() == comments2.getId()) { comment2Added = true; }
        }        
        assertFalse("commentsService.deleteCommentsById() did not delete comment1: " + comments1, comment1Added);
        
        /*
         * update an comment
         */

        String newOne = "CommentsServiceTest: new for comment 2";
        Comments comments = service.findById(comments2.getId());
        comments.setComment(newOne);
        service.updateComments(comments);
            
        /*
         * Get all Comments list from database
         */
        List<Comments> CommentsList = service.findAllComments();
        String stored = null;
        for (Comments comment : CommentsList) {
            if (comment.getId() == comments2.getId()) { stored = comment.getComment(); }
        }
        assertTrue("UserService.updateComments() did not update comment2: " + comments2, stored.equals(newOne));

        // reset
        service.deleteCommentsById(comments2.getId());
        logger.debug("CommentsServiceTest completed! ");

    }
    

}
