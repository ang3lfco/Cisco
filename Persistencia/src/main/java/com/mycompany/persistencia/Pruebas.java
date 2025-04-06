/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import Entidades.*;
import daos.ConexionBD;
import daos.EstudianteDAO;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
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
    public static void main(String[] args) throws PersistenciaException {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Cisco");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
        
        IConexionBD conexionBD = new ConexionBD();
        EstudianteDAO estudianteDAO = new EstudianteDAO(conexionBD);
        
        EntityManager em = conexionBD.obtenerEntityManager();
        Carrera isw = em.createQuery("SELECT c FROM Carrera c WHERE c.nombre = :nombre", Carrera.class)
                        .setParameter("nombre", "Ingeniería en Software")
                        .getSingleResult();
        
        List<Estudiante> estudiantes = new ArrayList<>();
        List<Bloqueo> bloqueos = new ArrayList<>();
        List<Reserva> reservas = new ArrayList<>();
        
//        Carrera isw = new Carrera("Ingeniería en Software", 180, estudiantes);
        Estudiante e = new Estudiante("00000278954","Juan","Perez","Gomez","Activo","juanito123", isw, bloqueos, reservas);
        estudianteDAO.agregar(e);
        em.close();

//        em.persist(isw);
//        em.getTransaction().commit();
//        em.close();
//        emf.close();
    }
}
