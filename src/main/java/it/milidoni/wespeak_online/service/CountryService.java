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
import it.milidoni.wespeak_online.entity.Country;
import it.zenitlab.crudservice.CRUDService;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class CountryService extends CRUDService {

    public CountryService() {
        super(ProjectEntityManager.getEntityManager(), Country.class);
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
        Country c = (Country) o;
        UserService us = new UserService();
        List l = us.listFromCountryId(c.getId());
        if (l != null && !l.isEmpty()) {
            throw new ServiceException("The country is linked to some users");
        }
    }

    @Override
    public void bind(Object o, Object o1, HashMap<String, Object> hm) throws ServiceException {
        Country s = (Country) o;
        Country t = (Country) o1;
        t.setId(s.getId());
        t.setCode2l(s.getCode2l());
        t.setCode3l(s.getCode3l());
        t.setEnabled(s.getEnabled());
        t.setFlag128(s.getFlag128());
        t.setFlag32(s.getFlag32());
        t.setLatitude(s.getLatitude());
        t.setLongitude(s.getLongitude());
        t.setName(s.getName());
        t.setNameOfficial(s.getNameOfficial());
        t.setZoom(s.getZoom());
    }
}
