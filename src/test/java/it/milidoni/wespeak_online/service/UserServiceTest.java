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
import it.milidoni.wespeak_online.entity.User;
import it.zenitlab.crudservice.exception.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public UserServiceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
    public void testSaveUser() {
        System.out.println("testSaveUser");
        try {
            UserService us = new UserService(ProjectEntityManager.getTestEntityManager());
            User u = new User();
            u.setEmail("michele2@test.com");
            u.setPassword("ciccio");
            User u2 = us.create(u);
            assertTrue(u2.getId() > 0);
        } catch (ServiceException ex) {
            Logger.getLogger(UserServiceTest.class.getName()).log(Level.SEVERE, null, ex);
            assertTrue(false);
        }

    }

    /**
     * Test of getUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testGetUser() throws Exception {
        System.out.println("getUser");
        String email = "";
        String password = "";
        UserService instance = new UserService();
        User expResult = null;
        User result = instance.getUser(email, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasFavouriteUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testHasFavouriteUser() throws Exception {
        System.out.println("hasFavouriteUser");
        Integer idUserA = null;
        Integer idUserB = null;
        UserService instance = new UserService();
        Boolean expResult = null;
        Boolean result = instance.hasFavouriteUser(idUserA, idUserB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasFavouriteTopic method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testHasFavouriteTopic() throws Exception {
        System.out.println("hasFavouriteTopic");
        Integer idUser = null;
        Integer idTopic = null;
        UserService instance = new UserService();
        Boolean expResult = null;
        Boolean result = instance.hasFavouriteTopic(idUser, idTopic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFavouriteUser method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testToggleFavouriteUser() throws Exception {
        System.out.println("toggleFavouriteUser");
        Integer idUserA = null;
        Integer idUserB = null;
        UserService instance = new UserService();
        Boolean expResult = null;
        Boolean result = instance.toggleFavouriteUser(idUserA, idUserB);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toggleFavouriteTopic method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testToggleFavouriteTopic() throws Exception {
        System.out.println("toggleFavouriteTopic");
        Integer idUser = null;
        Integer idTopic = null;
        UserService instance = new UserService();
        Boolean expResult = null;
        Boolean result = instance.toggleFavouriteTopic(idUser, idTopic);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of listFromTimezoneId method, of class UserService.
     */
    @Ignore
    @org.junit.Test
    public void testListFromTimezoneId() {
        System.out.println("listFromTimezoneId");
        int idTimezone = 0;
        UserService instance = new UserService();
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
        UserService instance = new UserService();
        List<User> expResult = null;
        List<User> result = instance.listFromCountryId(idCountry);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cambioPassword method, of class UserService.
     * @throws java.lang.Exception
     */
    @Ignore
    @org.junit.Test
    public void testCambioPassword() throws Exception {
        System.out.println("cambioPassword");
        String username = "";
        String vecchiaPassword = "";
        String nuovaPassword = "";
        UserService instance = new UserService();
        boolean expResult = false;
        boolean result = instance.cambioPassword(username, vecchiaPassword, nuovaPassword);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
