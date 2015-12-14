package com.jcodeshare.webtemplate.data.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jcodeshare.webtemplate.data.dao.CommentsDao;
import com.jcodeshare.webtemplate.data.dao.UsersDao;
import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;

@Service("usersService")
public class UsersServiceImpl implements UsersService {
    
    // Cannot get autowire working here!
    @ Autowired
    @ Qualifier("usersDao")
    UsersDao dao;
     
    public void saveUsers(Users users) {
        dao.saveUsers(users);
    }

    public List<Users> findAllUsers() {
        return dao.findAllUsers();
    }

    public void deleteUsersById(int id) {
        dao.deleteUsersById(id);
    }

    public Users findById(int id) {
        return dao.findById(id);
    }
    
    public Users findByUsername(String username) {
        return dao.findByUsername(username);
    }
    
    public void updateUsers(Users users){
        dao.updateUsers(users);
    }
    
    public void setDao(UsersDao dao){
        this.dao = dao;
    }

    public List<Comments> findAllComments(Users user) {
        return dao.findAllComments(user);
    }
}
