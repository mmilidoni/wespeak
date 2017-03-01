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
import it.milidoni.wespeak_online.entity.Timezone;
import it.zenitlab.crudservice.CRUDService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class TimezoneService extends CRUDService {

    public TimezoneService() {
        super(ProjectEntityManager.getEntityManager(), Timezone.class);
    }

    @Override
    public void validate(Object o, int i, HashMap<String, Object> hm) throws ServiceException {
    }

    @Override
    public void beforePersist(Object o, HashMap<String, Object> hm) throws ServiceException {
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
        Timezone tz = (Timezone) o;
        UserService us = new UserService();
        List l = us.listFromTimezoneId(tz.getId());
        if (l != null && !l.isEmpty()) {
            throw new ServiceException("The timezone is linked to some users");
        }
    }

    @Override
    public void bind(Object o, Object o1, HashMap<String, Object> hm) throws ServiceException {
        Timezone s = (Timezone) o;
        Timezone t = (Timezone) o1;
        t.setId(s.getId());
        t.setCode21(s.getCode21());
        t.setName(s.getName());
    }
}
