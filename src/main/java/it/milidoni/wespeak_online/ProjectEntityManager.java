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
package it.milidoni.wespeak_online;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class ProjectEntityManager {

    private static final String PERSISTENCE_UNIT_NAME = "wespeak_sperimental";
    private static final String PERSISTENCE_TEST_UNIT_NAME = "wespeak_sperimental_test";
    private volatile static EntityManager em = null;
    private volatile static EntityManager emTest = null;

    private ProjectEntityManager() {
    }

    public static EntityManager getEntityManager() {
        if (em == null) {
            //posso sincronizzare solo questa parte del metodo perché l'istanza è di tipo volatile
            synchronized (ProjectEntityManager.class) {
                if (em == null) {
                    em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
                }
            }
        }
        return em;
    }

    public static EntityManager getTestEntityManager() {
        if (emTest == null) {
            synchronized (ProjectEntityManager.class) {
                if (emTest == null) {
                    emTest = Persistence.createEntityManagerFactory(PERSISTENCE_TEST_UNIT_NAME).createEntityManager();
                }
            }
        }
        return emTest;
    }
}
