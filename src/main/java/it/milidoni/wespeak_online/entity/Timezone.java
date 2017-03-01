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
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Timezone.findAll", query = "SELECT t FROM Timezone t"),
    @NamedQuery(name = "Timezone.findById", query = "SELECT t FROM Timezone t WHERE t.id = :id"),
    @NamedQuery(name = "Timezone.findByCode21", query = "SELECT t FROM Timezone t WHERE t.code21 = :code21"),
    @NamedQuery(name = "Timezone.findByName", query = "SELECT t FROM Timezone t WHERE t.name = :name")})
public class Timezone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(nullable = false, length = 2)
    private String code21;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(nullable = false, length = 1024)
    private String name;

    /*
    @OneToMany(mappedBy = "timezone")
    private List<User> userList;
     */
    public Timezone() {
    }

    public Timezone(Integer id) {
        this.id = id;
    }

    public Timezone(Integer id, String code21, String name) {
        this.id = id;
        this.code21 = code21;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode21() {
        return code21;
    }

    public void setCode21(String code21) {
        this.code21 = code21;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*
    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Timezone)) {
            return false;
        }
        Timezone other = (Timezone) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.Timezone[ id=" + id + " ]";
    }

}
