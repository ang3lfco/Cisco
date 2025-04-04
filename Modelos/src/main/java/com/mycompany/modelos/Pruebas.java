/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.modelos;

import Entidades.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class Pruebas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cisco");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        List<Laboratorio> labs = new ArrayList<>();
        List<Computadora> equipos = new ArrayList<>();
        List<HorarioEspecial> horarios = new ArrayList<>();
        
        Instituto itson = new Instituto("Instituto Tecnológico de Sonora", "Itson", labs);
        Laboratorio cisco = new Laboratorio("Cisco", LocalTime.of(8, 0, 0), LocalTime.of(20, 0, 0), "cisco123", itson, equipos, horarios);  
        labs.add(cisco);
        
        em.persist(itson);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
