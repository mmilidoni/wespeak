/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.milidoni.wespeak_online.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = {"email"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByNewsletter", query = "SELECT u FROM User u WHERE u.newsletter = :newsletter"),
    @NamedQuery(name = "User.findByName", query = "SELECT u FROM User u WHERE u.name = :name"),
    @NamedQuery(name = "User.findByRank", query = "SELECT u FROM User u WHERE u.rank = :rank"),
    @NamedQuery(name = "User.findByEnglishLevel", query = "SELECT u FROM User u WHERE u.englishLevel = :englishLevel"),
    @NamedQuery(name = "User.findByBirth", query = "SELECT u FROM User u WHERE u.birth = :birth"),
    @NamedQuery(name = "User.findBySex", query = "SELECT u FROM User u WHERE u.sex = :sex"),
    @NamedQuery(name = "User.findByPicture", query = "SELECT u FROM User u WHERE u.picture = :picture"),
    @NamedQuery(name = "User.findBySkypeId", query = "SELECT u FROM User u WHERE u.skypeId = :skypeId"),
    @NamedQuery(name = "User.findByResetPasswordCode", query = "SELECT u FROM User u WHERE u.resetPasswordCode = :resetPasswordCode"),
    @NamedQuery(name = "User.findByCountry", query = "SELECT u FROM User u WHERE u.country = :country")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer id;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1024)
    @Column(nullable = false, length = 1024)
    private String email;
    @Size(max = 1024)
    @Column(length = 1024)
    private String password;
    private Short newsletter;
    @Size(max = 1024)
    @Column(length = 1024)
    private String name;
    private Integer rank;
    @Column(name = "english_level")
    private Integer englishLevel;
    @Temporal(TemporalType.DATE)
    private Date birth;
    private Short sex;
    @Lob
    @Size(max = 65535)
    @Column(length = 65535)
    private String about;
    @Size(max = 1024)
    @Column(length = 1024)
    private String picture;
    @Size(max = 1024)
    @Column(name = "skype_id", length = 1024)
    private String skypeId;
    @Size(max = 45)
    @Column(name = "reset_password_code", length = 45)
    private String resetPasswordCode;
    private Integer country;
    @JoinTable(name = "favourite_user", joinColumns = {
        @JoinColumn(name = "actor", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "subject", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<User> userList;
    @ManyToMany(mappedBy = "userList")
    private List<User> userList1;
    @JoinTable(name = "favourite_topic", joinColumns = {
        @JoinColumn(name = "user", referencedColumnName = "id", nullable = false)}, inverseJoinColumns = {
        @JoinColumn(name = "topic", referencedColumnName = "id", nullable = false)})
    @ManyToMany
    private List<Topic> topicList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private List<Call> callList;
    @OneToMany(mappedBy = "interlocutor")
    private List<Call> callList1;
    @JoinColumn(name = "timezone", referencedColumnName = "id")
    @ManyToOne
    private Timezone timezone;

    public User() {
    }

    public User(Integer id) {
        this.id = id;
    }

    public User(Integer id, String email) {
        this.id = id;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(Short newsletter) {
        this.newsletter = newsletter;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(Integer englishLevel) {
        this.englishLevel = englishLevel;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }

    public Integer getCountry() {
        return country;
    }

    public void setCountry(Integer country) {
        this.country = country;
    }

    @XmlTransient
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    @XmlTransient
    public List<User> getUserList1() {
        return userList1;
    }

    public void setUserList1(List<User> userList1) {
        this.userList1 = userList1;
    }

    @XmlTransient
    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }

    @XmlTransient
    public List<Call> getCallList() {
        return callList;
    }

    public void setCallList(List<Call> callList) {
        this.callList = callList;
    }

    @XmlTransient
    public List<Call> getCallList1() {
        return callList1;
    }

    public void setCallList1(List<Call> callList1) {
        this.callList1 = callList1;
    }

    public Timezone getTimezone() {
        return timezone;
    }

    public void setTimezone(Timezone timezone) {
        this.timezone = timezone;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.milidoni.wespeak_online.entity.User[ id=" + id + " ]";
    }
    
}
