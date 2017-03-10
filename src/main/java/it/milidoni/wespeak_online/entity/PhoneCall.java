/*
 * Copyright 2017 Michele Milidoni <michelemilidoni@gmail.com>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package it.milidoni.wespeak_online.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@Table(name = "phone_call", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PhoneCall.findAll", query = "SELECT p FROM PhoneCall p"),
    @NamedQuery(name = "PhoneCall.findById", query = "SELECT p FROM PhoneCall p WHERE p.id = :id"),
    @NamedQuery(name = "PhoneCall.findByDateTime", query = "SELECT p FROM PhoneCall p WHERE p.dateTime = :dateTime")})
public class PhoneCall implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    @Column(name = "date_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateTime;
    @Lob
    @Size(max = 65535)
    @Column(name = "owner_comment")
    private String ownerComment;
    @Lob
    @Size(max = 65535)
    @Column(name = "interlocutor_comment")
    private String interlocutorComment;
    @JoinColumn(name = "owner", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private User owner;
    @JoinColumn(name = "interlocutor", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User interlocutor;
    @JoinColumn(name = "topic", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Topic topic;

    public PhoneCall() {
    }

    public PhoneCall(Integer id) {
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
        if (!(object instanceof PhoneCall)) {
            return false;
        }
        PhoneCall other = (PhoneCall) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.PhoneCall[ id=" + id + " ]";
    }
    
}
