package com.jcodeshare.webtemplate.data.service;

import com.jcodeshare.webtemplate.data.service.UsersService;
import com.jcodeshare.webtemplate.data.model.Users;

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


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:loyaltyservice-test.xml" })
public class UsersServiceTest extends AbstractJUnit4SpringContextTests {
    
    @Autowired
    UsersService service;
    
    private final Logger logger = LoggerFactory
            .getLogger(UsersServiceTest.class);

    @Test
    public void testUsersService() throws Exception {

        /*
         * Create Users1
         */
        Users users1 = new Users();
        users1.setUsername("yp");
        users1.setPassword("xxx");

        /*
         * Create Users2
         */
        Users users2 = new Users();
        users2.setUsername("loyaltyone");
        users2.setPassword("xxx");

        /*
         * Persist both Userss
         */
        service.saveUsers(users1);
        service.saveUsers(users2);

        /*
         * Get all Users list from database
         */
        List<Users> allUsers = service.findAllUsers();
        boolean user1Added = false;
        boolean user2Added = false;
        for (Users user : allUsers) {
            logger.debug("found user: " + user);
            if (user.getId() == users1.getId()) { user1Added = true; }
            if (user.getId() == users2.getId()) { user2Added = true; }
        }
        assertTrue("usersService.saveUser() did not save user1: " + users1, user1Added);
        assertTrue("usersService.saveUser() did not save user2: " + users2, user2Added);

        /*
         * delete an user
         */
        service.deleteUsersById(users1.getId());
        
        allUsers = service.findAllUsers();
        user1Added = false;
        for (Users user : allUsers) {
            logger.debug("found user: " + user);
            if (user.getId() == users1.getId()) { user1Added = true; }
            if (user.getId() == users2.getId()) { user2Added = true; }
        }        
        assertFalse("usersService.deleteUsersById() did not delete user1: " + users1, user1Added);
        
        /*
         * update an user
         */

        String newPass = "newone";
        Users users = service.findById(users2.getId());
        users.setPassword(newPass);
        service.updateUsers(users);

        /*
         * Get all Users list from database
         */
        List<Users> UsersList = service.findAllUsers();
        String storedPass = null;
        for (Users user : UsersList) {
            if (user.getId() == users2.getId()) { storedPass = user.getPassword(); }
        }
        assertTrue("UserService.updateUsers() did not update user2: " + users2, storedPass.equals(newPass));

        // reset
        service.deleteUsersById(users2.getId());
        logger.debug("UsersServiceTest completed! ");

    }
    

}
