/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.milidoni.wespeak_online;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Michele Milidoni <michelemilidoni@gmail.com>
 */
public class ProjectEntityManager {

    private static final String PERSISTENCE_UNIT_NAME = "tesilm_manytopics";
    private volatile static EntityManager em = null;

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
}
