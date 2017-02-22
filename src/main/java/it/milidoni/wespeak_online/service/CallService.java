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
import it.milidoni.wespeak_online.entity.Call;
import it.milidoni.wespeak_online.entity.User;
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
public class CallService extends CRUDService {

    public CallService() {
        super(ProjectEntityManager.getEntityManager(), Call.class);
    }

    public void book(int idCall, int idInterlocutor, String interlocutorComment) throws ServiceException {
        Call c = read(idCall);
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Call unbook(int idCall) throws ServiceException {
        Call c = read(idCall);
        c.setInterlocutor(null);
        c.setInterlocutorComment(null);
        return update(c);
    }

    public List<User> listFromTopicId(int idTopic) {
        List<User> l = null;
        Query q = em.createQuery(""
                + "SELECT u "
                + "FROM Call u "
                + "WHERE u.topic.id = :idTopic");
        q.setParameter("idTopic", idTopic);
        try {
            l = q.getResultList();
        } catch (Exception ex) {
            Logger.getLogger(UserService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    
    public List<Call> listNextCalls(int idUser) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.        
    }

    @Override
    public void validate(Object o, int i, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforePersist(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterPersist(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeMerge(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterMerge(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void beforeRemove(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void afterRemove(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void checkRemovable(Object o, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void bind(Object o, Object o1, HashMap<String, Object> hm) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
