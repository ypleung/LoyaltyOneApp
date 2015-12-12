/*
 * Created on 8 Dec 2015 ( Time 12:48:55 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.jcodeshare.webtemplate.data.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.Type;

import org.springframework.format.annotation.DateTimeFormat;


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

    @Column(name = "user_id", nullable=false)
    private Integer userId;

    @Column(name = "create_date", nullable=false)
    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date createDate;

    @Column(name = "create_ts", nullable=false, columnDefinition="DATETIME")
    @Temporal(TemporalType.DATE)
    private Date createTs;



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

    public void setUserId( Integer userId ) {
        this.userId = userId;
    }
    public Integer getUserId() {
        return this.userId;
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
        sb.append(userId);
        sb.append("|");
        sb.append(createDate);
        sb.append("|");
        sb.append(createTs);
        return sb.toString(); 
    } 


}
