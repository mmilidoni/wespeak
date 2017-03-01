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
package it.milidoni.wespeak_online.service;

import it.milidoni.wespeak_online.ProjectEntityManager;
import it.milidoni.wespeak_online.entity.Topic;
import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.util.PasswordStorage;
import it.zenitlab.crudservice.CRUDService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class UserService extends CRUDService {

    public UserService() {
        super(ProjectEntityManager.getEntityManager(), User.class);
    }

    public UserService(EntityManager em) {
        super(em, User.class);
    }

    public User getUser(String email, String password) throws ServiceException {
        Query q = em.createQuery("SELECT u FROM User u WHERE u.email = :email");
        q.setParameter("email", email);
        User u = (User) q.getSingleResult();
        if (u != null) {
            try {
                if (PasswordStorage.verifyPassword(password, u.getPassword())) {
                    return u;
                } else {
                    return null;
                }
            } catch (PasswordStorage.CannotPerformOperationException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PasswordStorage.InvalidHashException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServiceException("Email o password non validi");
            }
        }
        return null;
    }

    public Boolean hasFavouriteUser(Integer idUserA, Integer idUserB) throws ServiceException {
        User u = read(idUserA);
        if (u.getFavouriteUsers()== null) {
            return false;
        }
        for (User subject : u.getFavouriteUsers()) {
            if (idUserB.equals(subject.getId())) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasFavouriteTopic(Integer idUser, Integer idTopic) throws ServiceException {
        User u = read(idUser);
        if (u.getFavouriteTopics() == null) {
            return false;
        }
        for (Topic topic : u.getFavouriteTopics()) {
            if (idTopic.equals(topic.getId())) {
                return true;
            }
        }
        return false;
    }

    public Boolean toggleFavouriteUser(Integer idUserA, Integer idUserB) throws ServiceException {
        User u = read(idUserA);
        if (hasFavouriteUser(idUserA, idUserB)) {
            u.getFavouriteUsers().remove((User) read(idUserB));
        } else {
            if (u.getFavouriteUsers() == null) {
                u.setFavouriteUsers(new ArrayList());
            }
            u.getFavouriteUsers().add((User) read(idUserB));
        }
        return em.merge(u) != null;
    }

    public Boolean toggleFavouriteTopic(Integer idUser, Integer idTopic) throws ServiceException {
        User u = read(idUser);
        TopicService ts = new TopicService(em);

        if (hasFavouriteTopic(idUser, idTopic)) {
            u.getFavouriteTopics().remove((Topic) ts.read(idTopic));
        } else {
            if (u.getFavouriteTopics() == null) {
                u.setFavouriteTopics(new ArrayList());
            }
            u.getFavouriteTopics().add((Topic) ts.read(idTopic));
        }
        return em.merge(u) != null;
    }

    public boolean changePassword(String email, String currentPassword, String newPassword) throws ServiceException {
        try {
            em.getTransaction().begin();
            User user = getUser(email, currentPassword);
            if (user == null) {
                return false;
            }
            user.setPassword(PasswordStorage.createHash(newPassword));
            em.persist(user);
            em.getTransaction().commit();
            return true;
        } catch (PasswordStorage.CannotPerformOperationException e) {
            em.getTransaction().rollback();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    public List<User> listFromTimezoneId(int idTimezone) {
        List<User> l = null;
        Query q = em.createQuery(""
                + "SELECT u "
                + "FROM User u "
                + "WHERE u.timezone.id = :idTimezone");
        q.setParameter("idTimezone", idTimezone);
        try {
            l = q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<User> listFromCountryId(int idCountry) {
        List<User> l = null;
        Query q = em.createQuery(""
                + "SELECT u "
                + "FROM User u "
                + "WHERE u.country.id = :idCountry");
        q.setParameter("idCountry", idCountry);
        try {
            l = q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    @Override
    public void validate(Object o, int i, HashMap<String, Object> hm) throws ServiceException {
        User u = (User) o;
        if (u.getEmail() == null || u.getEmail().trim().length() < 5) {
            throw new ServiceException("Email non valida");
        }
        if (u.getPassword() == null || u.getPassword().trim().length() < 5) {
            throw new ServiceException("Password non valida");
        }
    }

    @Override
    public void beforePersist(Object o, HashMap<String, Object> hm) throws ServiceException {
        try {
            User u = (User) o;
            u.setPassword(PasswordStorage.createHash(u.getPassword()));
        } catch (PasswordStorage.CannotPerformOperationException ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            throw new ServiceException(ex.getMessage());
        }
    }

    @Override
    public void afterPersist(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void beforeMerge(Object o, HashMap<String, Object> hm) throws ServiceException {
        User u = (User) o;
        Query q = em.createQuery("select u from User u where email=:email and id <> :id");
        q.setParameter("email", u.getEmail());
        q.setParameter("id", u.getId());
        if (q.getResultList().size() > 0) {
            throw new ServiceException("USERNAME IN USO");
        }
        if (!u.getPassword().trim().isEmpty()) {
            try {
                u.setPassword(PasswordStorage.createHash(u.getPassword()));
            } catch (PasswordStorage.CannotPerformOperationException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServiceException(ex.getMessage());
            }
        }
    }

    @Override
    public void afterMerge(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void beforeRemove(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void afterRemove(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void checkRemovable(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void bind(Object o, Object o1, HashMap<String, Object> hm) throws ServiceException {
        User source = (User) o;
        User target = (User) o1;

        target.setAbout(source.getAbout());
        target.setBirth(source.getBirth());
        target.setCountry(source.getCountry());
        target.setEmail(source.getEmail());
        target.setEnglishLevel(source.getEnglishLevel());
        target.setId(source.getId());
        target.setName(source.getName());
        target.setNewsletter(source.getNewsletter());
        target.setPassword(source.getPassword());
        target.setPicture(source.getPicture());
        target.setRank(source.getRank());
        target.setSex(source.getSex());
        target.setSkypeId(source.getSkypeId());
        target.setTimezone(source.getTimezone());
    }
}
