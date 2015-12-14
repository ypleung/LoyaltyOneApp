package com.jcodeshare.webtemplate.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;

@Repository("usersDao")
@Transactional
public class UsersDaoImpl extends AbstractDao implements UsersDao {

    @Autowired
    SessionFactory sessionFactory;
    
    public void saveUsers(Users Users) {
        persist(Users);
    }

    @SuppressWarnings("unchecked")
    public List<Users> findAllUsers() {
        Criteria criteria = getSession().createCriteria(Users.class);
        return (List<Users>) criteria.list();
    }

    public void deleteUsersById(int id) {
        Query query = getSession().createSQLQuery(
                "delete from Users where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Users findById(int id) {
        Criteria criteria = getSession().createCriteria(Users.class);
        criteria.add(Restrictions.eq("id", id));
        return (Users) criteria.uniqueResult();
    }
    
    public Users findByUsername(String username) {
        Criteria criteria = getSession().createCriteria(Users.class);
        criteria.add(Restrictions.eq("username", username));
        return (Users) criteria.uniqueResult();
    }
    
    public void updateUsers(Users Users) {
        getSession().update(Users);
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public List<Comments> findAllComments(Users user) {
        Criteria criteria = getSession().createCriteria(Comments.class);
        criteria.add(Restrictions.eq("user", user));
        return (List<Comments>) criteria.list();
    }
}
