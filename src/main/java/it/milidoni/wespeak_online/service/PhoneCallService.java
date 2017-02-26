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
import it.milidoni.wespeak_online.entity.PhoneCall;
import it.milidoni.wespeak_online.entity.User;
import it.zenitlab.crudservice.CRUDService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.GregorianCalendar;
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
public class PhoneCallService extends CRUDService {

    public PhoneCallService() {
        super(ProjectEntityManager.getEntityManager(), PhoneCall.class);
    }

    public PhoneCallService(EntityManager em) {
        super(em, PhoneCall.class);
    }

    public PhoneCall book(int idCall, int idInterlocutor, String interlocutorComment) throws ServiceException {
        PhoneCall c = read(idCall);
        UserService us = new UserService();
        c.setInterlocutor((User) us.read(idInterlocutor));
        c.setInterlocutorComment(interlocutorComment);
        return update(c);
    }

    public PhoneCall unbook(int idCall) throws ServiceException {
        PhoneCall c = read(idCall);
        c.setInterlocutor(null);
        c.setInterlocutorComment(null);
        return update(c);
    }

    public List<User> listFromTopicId(int idTopic) {
        List<User> l = null;
        Query q = em.createQuery(""
                + "SELECT u "
                + "FROM PhoneCall u "
                + "WHERE u.topic.id = :idTopic");
        q.setParameter("idTopic", idTopic);
        try {
            l = q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    public List<PhoneCall> listNextCalls(int idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public void validate(Object o, int i, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void beforePersist(Object o, HashMap<String, Object> hm) throws ServiceException {
        PhoneCall c = (PhoneCall) o;
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MINUTE, 5);
        if (c.getDateTime().getTime() < gc.getTimeInMillis()) {
            throw new ServiceException("You can not open a slot less than 5 minutes before from the start");
        }
    }

    @Override
    public void afterPersist(Object o, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void beforeMerge(Object o, HashMap<String, Object> hm) throws ServiceException {
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
        PhoneCall source = (PhoneCall) o;
        PhoneCall target = (PhoneCall) o;
        target.setDateTime(source.getDateTime());
        target.setId(source.getId());
        target.setInterlocutor(source.getInterlocutor());
        target.setInterlocutorComment(source.getInterlocutorComment());
        target.setOwner(source.getOwner());
        target.setOwnerComment(source.getOwnerComment());
        target.setTopic(source.getTopic());
    }

}
