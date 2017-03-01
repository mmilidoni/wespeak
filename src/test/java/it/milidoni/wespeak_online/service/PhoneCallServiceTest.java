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
import it.milidoni.wespeak_online.entity.Topic;
import it.milidoni.wespeak_online.entity.User;
import it.milidoni.wespeak_online.util.TestUtil;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class PhoneCallServiceTest {

    private static final EntityManager em = ProjectEntityManager.getTestEntityManager();
    private static User owner = null;
    private static User interlocutor = null;
    private static Topic topic = null;

    public PhoneCallServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() throws ServiceException {
        TestUtil.cleanTables(em);
        UserService us = new UserService(em);
        owner = new User();
        owner.setEmail("owner@example.com");
        owner.setPassword("ciccio");
        us.create(owner);
        interlocutor = new User();
        interlocutor.setEmail("interlocutor@example.com");
        interlocutor.setPassword("ciccio");
        us.create(interlocutor);

        TopicService ts = new TopicService(em);
        topic = new Topic();
        topic.setName("topic_CallServiceTest");
        ts.create(topic);

    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testActivate() {
        PhoneCallService cs = new PhoneCallService(em);

        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH, 3);

        PhoneCall call = new PhoneCall();
        call.setDateTime(gc.getTime());
        call.setTopic(topic);
        call.setOwner(owner);
        try {
            cs.create(call);
            PhoneCall callTest = cs.activate(call.getId(), owner.getId(),
                    topic.getId(), gc.getTime());
            assertTrue(call.getId().equals(callTest.getId())
                    && call.getTopic().getId().equals(callTest.getTopic().getId())
                    && callTest.getDateTime().getTime() > 0);
        } catch (ServiceException ex) {
            Logger.getLogger(PhoneCallServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }
    }

    @Test
    public void testDeactivate() {
        PhoneCallService cs = new PhoneCallService(em);
        PhoneCall call = new PhoneCall();
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH, 10);
        call.setDateTime(new Date(gc.getTimeInMillis()));
        call.setTopic(topic);
        call.setOwner(owner);
        try {
            cs.create(call);
        } catch (ServiceException ex) {
            Logger.getLogger(PhoneCallServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertFalse(true);
        }

        try {
            PhoneCall callTest = cs.deactivate(call.getId());
            assertNotNull(callTest);
        } catch (ServiceException ex) {
            Logger.getLogger(PhoneCallServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertFalse(true);
        }
    }

    @Test
    public void testBook() {
        PhoneCallService cs = new PhoneCallService(em);

        PhoneCall call = new PhoneCall();
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH, 3);

        call.setDateTime(gc.getTime());
        call.setTopic(topic);
        call.setOwner(owner);
        try {
            call = cs.create(call);
            call = cs.book(call.getId(), interlocutor.getId(), "comments");
            assertTrue(call.getId() > 0
                    && call.getInterlocutor().getId() > 0
                    && !call.getInterlocutorComment().isEmpty());
        } catch (ServiceException ex) {
            Logger.getLogger(PhoneCallServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertFalse(true);
        }
    }

    @Test
    public void testUnbook() throws Exception {
        PhoneCallService cs = new PhoneCallService(em);

        PhoneCall call = new PhoneCall();
        GregorianCalendar gc = new GregorianCalendar();
        gc.add(GregorianCalendar.MONTH, 3);

        call.setDateTime(gc.getTime());
        call.setTopic(topic);
        call.setOwner(owner);
        try {
            call = cs.create(call);
            call = cs.unbook(call.getId());
            assertNull(call.getInterlocutor());
            assertNull(call.getInterlocutorComment());
        } catch (ServiceException ex) {
            Logger.getLogger(PhoneCallServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertFalse(true);
        }
    }

    @Ignore
    @Test
    public void testListFromTopicId() {
        System.out.println("listFromTopicId");
        int idTopic = 0;
        PhoneCallService instance = new PhoneCallService(em);
        List<User> expResult = null;
        List<User> result = instance.listFromTopicId(idTopic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    @Ignore
    @Test
    public void testListNextCalls() {
        System.out.println("listNextCalls");
        int idUser = 0;
        PhoneCallService instance = new PhoneCallService(em);
        List<PhoneCall> expResult = null;
        List<PhoneCall> result = instance.listNextCalls(idUser);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
