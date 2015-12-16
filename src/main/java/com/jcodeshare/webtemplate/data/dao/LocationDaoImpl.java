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

import com.jcodeshare.webtemplate.data.model.Location;

@Repository("locationDao")
@Transactional
public class LocationDaoImpl extends AbstractDao implements LocationDao {

    @Autowired
    SessionFactory sessionFactory;
    
    public void saveLocation(Location Location) {
        persist(Location);
    }

    @SuppressWarnings("unchecked")
    public List<Location> findAllLocation() {
        Criteria criteria = getSession().createCriteria(Location.class);
        return (List<Location>) criteria.list();
    }

    public void deleteLocationById(int id) {
        Query query = getSession().createSQLQuery(
                "delete from Location where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Location findById(int id) {
        Criteria criteria = getSession().createCriteria(Location.class);
        criteria.add(Restrictions.eq("id", id));
        return (Location) criteria.uniqueResult();
    }
    
    public void updateLocation(Location Location) {
        getSession().update(Location);
    }
    
    public void deleteLocation(Location Location) {
        getSession().delete(Location);
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
