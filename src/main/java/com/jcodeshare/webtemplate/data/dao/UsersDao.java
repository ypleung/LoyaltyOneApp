package com.jcodeshare.webtemplate.data.dao;

import java.util.List;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;

public interface UsersDao {

    void saveUsers(Users users);

    List<Users> findAllUsers();

    void deleteUsersById(int id);

    Users findById(int id);
    
    Users findByUsername(String username);

    void updateUsers(Users Users);
    
    List<Comments> findAllComments(Users user);

}
