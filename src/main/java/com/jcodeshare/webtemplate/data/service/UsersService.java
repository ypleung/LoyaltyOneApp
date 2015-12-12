package com.jcodeshare.webtemplate.data.service;

import java.util.List;

import com.jcodeshare.webtemplate.data.model.Users;
 
public interface UsersService {
    
    void saveUsers(Users users);
    
    List<Users> findAllUsers();
 
    void deleteUsersById(int id);
 
    Users findById(int id);
    
    Users findByUsername(String username);
 
    void updateUsers(Users users);
    
}
