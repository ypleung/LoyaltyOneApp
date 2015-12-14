package com.jcodeshare.webtemplate.data.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jcodeshare.webtemplate.data.model.Comments;
import com.jcodeshare.webtemplate.data.model.Users;
import com.jcodeshare.webtemplate.data.dao.AbstractDao;
import org.springframework.beans.factory.annotation.Autowired;

@Repository("commentsDao")
@Transactional
public class CommentsDaoImpl extends AbstractDao implements CommentsDao {

    @Autowired
    SessionFactory sessionFactory;
    
    public void saveComments(Comments comments) {
        persist(comments);
    }

    @SuppressWarnings("unchecked")
    public List<Comments> findAllComments() {
        Criteria criteria = getSession().createCriteria(Comments.class);
        return (List<Comments>) criteria.list();
    }

    public void deleteCommentsById(int id) {
        Query query = getSession().createSQLQuery(
                "delete from Comments where id = :id");
        query.setInteger("id", id);
        query.executeUpdate();
    }

    public Comments findById(int id) {
        Criteria criteria = getSession().createCriteria(Comments.class);
        criteria.add(Restrictions.eq("id", id));
        return (Comments) criteria.uniqueResult();
    }
    
    public void updateComments(Comments Comments) {
        getSession().update(Comments);
    }
    
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
 
    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

}
