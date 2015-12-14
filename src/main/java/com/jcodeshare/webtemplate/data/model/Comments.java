/*
 * Created on 8 Dec 2015 ( Time 12:48:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.jcodeshare.webtemplate.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.ElementCollection;
import javax.persistence.TemporalType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Type;

import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.Access;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.jcodeshare.webtemplate.data.model.Users;

@Entity
@Table(name = "comments")
public class Comments {

    //private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id @GeneratedValue
    @Column(name = "id")
    private Integer id;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "comment", nullable=false)
    private String comment;

    @Column(name = "create_date", nullable=false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date createDate;

    @Column(name = "create_ts", nullable=false, columnDefinition="DATETIME")
    @Temporal(TemporalType.DATE)
    private Date createTs;

    //@Access(AccessType.PROPERTY)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  updatable = false, insertable = false)
    @JsonBackReference
    private Users user;

    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setId( Integer id ) {
        this.id = id ;
    }

    public Integer getId() {
        return this.id;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    public void setParentId( Integer parentId ) {
        this.parentId = parentId;
    }
    public Integer getParentId() {
        return this.parentId;
    }

    public void setComment( String comment ) {
        this.comment = comment;
    }
    public String getComment() {
        return this.comment;
    }
    
    public Users getUser() {
        return this.user;
    }

    public void setUser( Users user ) {
        this.user = user;
    }
    
    public void setCreateDate( Date createDate ) {
        this.createDate = createDate;
    }
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateTs( Date createTs ) {
        this.createTs = createTs;
    }
    public Date getCreateTs() {
        return this.createTs;
    }


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(parentId);
        sb.append("|");
        sb.append(comment);
        sb.append("|");
        sb.append(user);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(createTs);
        return sb.toString(); 
    } 


}
