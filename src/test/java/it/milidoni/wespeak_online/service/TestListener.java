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
import javax.persistence.EntityManager;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class TestListener extends org.junit.runner.notification.RunListener {

    public TestListener() {
        System.out.println("TestListener");
        String[] tables = {"resource", "call", "topic", "user"};
        EntityManager em = ProjectEntityManager.getTestEntityManager();
        em.getTransaction().begin();
        for (String table : tables) {
            em.createNativeQuery(
                    " delete from `" + table + "`"
            ).executeUpdate();
        }
        em.getTransaction().commit();
    }

}
