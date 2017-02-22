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
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class UserService extends CRUDService {

    public UserService() {
        super(ProjectEntityManager.getEntityManager(), User.class);
    }

    public User getUser(String email, String password) throws ServiceException {
        Query q = em.createQuery("select u from User u where email=:email");
        q.setParameter("email", email);
        User u = (User) q.getSingleResult();
        if (u != null) {
            try {
                if (PasswordStorage.verifyPassword(password, PasswordStorage.createHash(u.getPassword()))) {
                    return u;
                }
            } catch (PasswordStorage.CannotPerformOperationException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
            } catch (PasswordStorage.InvalidHashException ex) {
                Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
                throw new ServiceException("Email o password non validi");
            }
        }
        throw new ServiceException("Errore generico");
    }

    public Boolean hasFavouriteUser(Integer idUserA, Integer idUserB) throws ServiceException {
        User u = read(idUserA);
        for (User subject : u.getUserList()) {
            if (idUserB.equals(subject.getId())) {
                return true;
            }
        }
        return false;
    }

    public Boolean hasFavouriteTopic(Integer idUser, Integer idTopic) throws ServiceException {
        User u = read(idUser);
        for (Topic topic : u.getTopicList()) {
            if (idTopic.equals(topic.getId())) {
                return true;
            }
        }
        return false;
    }

    public Boolean toggleFavouriteUser(Integer idUserA, Integer idUserB) throws ServiceException {
        User u = read(idUserA);
        if (hasFavouriteUser(idUserA, idUserB)) {
            u.getUserList().remove((User) read(idUserB));
        } else {
            u.getUserList().add((User) read(idUserB));
        }
        return em.merge(u) != null;
    }

    public Boolean toggleFavouriteTopic(Integer idUser, Integer idTopic) throws ServiceException {
        User u = read(idUser);
        TopicService ts = new TopicService();

        if (hasFavouriteTopic(idUser, idTopic)) {
            u.getTopicList().remove((Topic) ts.read(idTopic));
        } else {
            u.getTopicList().add((Topic) ts.read(idTopic));
        }
        return em.merge(u) != null;
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

    public boolean cambioPassword(String username, String vecchiaPassword, String nuovaPassword) throws ServiceException {
        em.getTransaction().begin();
        try {
            Query q = em.createQuery("select u from Utente u where username=:username and password=:password");
            q.setParameter("username", username);
            q.setParameter("password", PasswordStorage.verifyPassword(vecchiaPassword, PasswordStorage.createHash(vecchiaPassword)));
            List<User> l = q.getResultList();
            if (l.isEmpty()) {
                return false;
            }
            User u = l.get(0);
            u.setPassword(PasswordStorage.createHash(nuovaPassword));
            em.getTransaction().commit();
            return true;
        } catch (PasswordStorage.CannotPerformOperationException e) {
            em.getTransaction().rollback();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
            return false;
        } catch (PasswordStorage.InvalidHashException e) {
            em.getTransaction().rollback();
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
