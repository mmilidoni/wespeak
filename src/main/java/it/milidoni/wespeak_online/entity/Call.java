/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.milidoni.wespeak_online.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Call.findAll", query = "SELECT c FROM Call c"),
    @NamedQuery(name = "Call.findById", query = "SELECT c FROM Call c WHERE c.id = :id"),
    @NamedQuery(name = "Call.findByDateTime", query = "SELECT c FROM Call c WHERE c.dateTime = :dateTime")})
public class Call implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "owner_comment", length = 65535)
    private String ownerComment;
    @Lob
    @Size(max = 65535)
    @Column(name = "interlocutor_comment", length = 65535)
    private String interlocutorComment;
    @JoinColumn(name = "owner", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private User owner;
    @JoinColumn(name = "interlocutor", referencedColumnName = "id")
    @ManyToOne
    private User interlocutor;
    @JoinColumn(name = "topic", referencedColumnName = "id")
    @ManyToOne
    private Topic topic;

    public Call() {
    }

    public Call(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOwnerComment() {
        return ownerComment;
    }

    public void setOwnerComment(String ownerComment) {
        this.ownerComment = ownerComment;
    }

    public String getInterlocutorComment() {
        return interlocutorComment;
    }

    public void setInterlocutorComment(String interlocutorComment) {
        this.interlocutorComment = interlocutorComment;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public User getInterlocutor() {
        return interlocutor;
    }

    public void setInterlocutor(User interlocutor) {
        this.interlocutor = interlocutor;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Call)) {
            return false;
        }
        Call other = (Call) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.Call[ id=" + id + " ]";
    }
    
}
