package com.jcodeshare.webtemplate.data.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
    
    public abstract void setSessionFactory(SessionFactory sessionFactory) ;
 
    public abstract Session getSession() ;
 
    public void persist(Object entity) {
        getSession().persist(entity);
    }
 
    public void delete(Object entity) {
        getSession().delete(entity);
    }
    
}
