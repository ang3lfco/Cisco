/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.modelos;

import Entidades.Instituto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class Modelos {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("Cisco");
        EntityManager entityManager = fabrica.createEntityManager();
        entityManager.getTransaction().begin();
        
        
        Instituto ins = new Instituto();
        ins.setNombre("nomre");
        ins.setSiglas("wdas");
        entityManager.persist(ins);

        entityManager.getTransaction().commit();

        entityManager.close();
        fabrica.close();
    }
}
