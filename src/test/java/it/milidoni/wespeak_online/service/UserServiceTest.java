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
import it.milidoni.wespeak_online.util.TestUtil;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class UserServiceTest {

    private static final EntityManager em = ProjectEntityManager.getTestEntityManager();

    public UserServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        TestUtil.cleanTables(em);
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
    public void testSaveUser() throws ServiceException {
        String userEmail = "testSaveUser@example.com";
        String userPassword = "ciccio";
        UserService us = new UserService(em);
        User u = new User();
        u.setEmail(userEmail);
        u.setPassword(userPassword);
        User u2 = us.create(u);
        assertTrue(u2.getId() > 0);
    }

    @Test
    public void testPasswordStorage() throws PasswordStorage.CannotPerformOperationException, PasswordStorage.InvalidHashException {
        String h1 = PasswordStorage.createHash("test");
        assertTrue(PasswordStorage.verifyPassword("test", h1));
    }

    @Test
    public void testGetUser() throws ServiceException {
        UserService instance = new UserService(em);

        String userEmail = "testGetUser@example.com";
        String userPassword = "ciccio";

        User uTemp = new User();
        uTemp.setEmail(userEmail);
        uTemp.setPassword(userPassword);
        User uTest = instance.create(uTemp);

        User result = instance.getUser(userEmail, userPassword);
        assertEquals(uTest.getId(), result.getId());
    }

    @Test
    public void testFavouriteUser() throws ServiceException {
        String user1Email = "testHasFavouriteUser1@example.com";
        String user2Email = "testHasFavouriteUser2@example.com";

        UserService us = new UserService(em);

        User uTemp = new User();
        uTemp.setEmail(user1Email);
        uTemp.setPassword(user1Email);
        User user1 = us.create(uTemp);
        uTemp = new User();
        uTemp.setEmail(user2Email);
        uTemp.setPassword(user2Email);
        User user2 = us.create(uTemp);

        // user1 has not user2 as favourite
        Boolean resultFalse = us.hasFavouriteUser(user1.getId(), user2.getId());
        assertFalse(resultFalse);

        // testing toggleFavouriteUser
        us.toggleFavouriteUser(user1.getId(), user2.getId());
        // user1 has user2 as favourite
        Boolean result2 = us.hasFavouriteUser(user1.getId(), user2.getId());
        assertTrue(result2);

        // testing toggleFavouriteUser
        us.toggleFavouriteUser(user1.getId(), user2.getId());
        // user1 has not user2 as favourite
        Boolean result3 = us.hasFavouriteUser(user1.getId(), user2.getId());
        assertFalse(result3);
    }

    @Test
    public void testFavouriteTopic() throws Exception {
        String userEmail = "testHasFavouriteTopic@example.com";
        String topicName = "topic_testHasFavouriteTopic";

        // creating user
        UserService us = new UserService(em);
        User uTemp = new User();
        uTemp.setEmail(userEmail);
        uTemp.setPassword(userEmail);
        User user = us.create(uTemp);

        // creating topic
        TopicService ts = new TopicService(em);
        Topic tTemp = new Topic();
        tTemp.setName(topicName);
        Topic topic = ts.create(tTemp);

        // user has not topic as favourite
        Boolean result1 = us.hasFavouriteTopic(user.getId(), topic.getId());
        assertFalse(result1);

        // testing toggleFavouriteTopic
        us.toggleFavouriteTopic(user.getId(), topic.getId());
        // user has topic as favourite
        Boolean result2 = us.hasFavouriteTopic(user.getId(), topic.getId());
        assertTrue(result2);

        // testing toggleFavouriteTopic
        us.toggleFavouriteTopic(user.getId(), topic.getId());
        // user has not topic as favourite
        Boolean result3 = us.hasFavouriteTopic(user.getId(), topic.getId());
        assertFalse(result3);
    }

    @Test
    public void testChangePassword() throws Exception {
        UserService us = new UserService(em);
        String userEmail = "testChangePassword@example.com";
        String userPassword = "testChangePassword";
        String userNewPassword = "testChangePassword2";

        User uTemp = new User();
        uTemp.setEmail(userEmail);
        uTemp.setPassword(userPassword);
        User user = us.create(uTemp);

        assertTrue(PasswordStorage.verifyPassword(userPassword, user.getPassword()));

        us.changePassword(userEmail, userPassword, userNewPassword);
        user = us.read(user.getId());
        assertFalse(PasswordStorage.verifyPassword(userPassword, user.getPassword()));
        assertTrue(PasswordStorage.verifyPassword(userNewPassword, user.getPassword()));
    }

    /**
     * Test of listFromTimezoneId method, of class UserService.
     */
    @Ignore
    @org.junit.Test
    public void testListFromTimezoneId() {
        System.out.println("listFromTimezoneId");
        int idTimezone = 0;
        UserService instance = new UserService(em);
        List<User> expResult = null;
        List<User> result = instance.listFromTimezoneId(idTimezone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listFromCountryId method, of class UserService.
     */
    @Ignore
    @org.junit.Test
    public void testListFromCountryId() {
        System.out.println("listFromCountryId");
        int idCountry = 0;
        UserService instance = new UserService(em);
        List<User> expResult = null;
        List<User> result = instance.listFromCountryId(idCountry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
