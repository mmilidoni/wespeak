/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.milidoni.wespeak_online.service;

import it.milidoni.wespeak_online.ProjectEntityManager;
import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.util.PasswordStorage;
import it.zenitlab.crudservice.CRUDService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.persistence.Query;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class UserService extends CRUDService {

    public UserService() {
        super(ProjectEntityManager.getEntityManager(), UserService.class);
    }

    public User login(String email, String password) throws ServiceException {
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
            }
        }
        throw new ServiceException("Email o password non validi");
    }

    public Boolean logout(String idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public void validate(Object o, int i, HashMap<String, Object> hm) throws ServiceException {
        User u;
        try {
            u = (User) o;
        } catch (Exception e) {
            throw new ServiceException("TIPO NON VALIDO " + e.getMessage());
        }
        if (u.getEmail() == null || u.getEmail().trim().length() < 5) {
            throw new ServiceException("EMAIL NON VALIDA");
        }
        if (u.getPassword() == null || u.getPassword().trim().length() < 5) {
            throw new ServiceException("PASSWORD NON VALIDA");
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
