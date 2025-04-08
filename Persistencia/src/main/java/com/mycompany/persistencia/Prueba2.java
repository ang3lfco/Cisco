/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import Entidades.Carrera;
import Entidades.Estudiante;
import daos.ConexionBD;
import daos.EstudianteDAO;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author ang3lfco
 */
public class Prueba2 {
    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexionBD = new ConexionBD();
        IEstudianteDAO estudianteDAO = new EstudianteDAO(conexionBD);
        
//        EntityManager em = conexionBD.obtenerEntityManager();
//        Estudiante estudiante = em.createQuery("SELECT e FROM Estudiante e WHERE e.idEstudiante = :idEstudiante", Estudiante.class)
//                        .setParameter("idEstudiante", "00000278954")
//                        .getSingleResult();

        Estudiante e = estudianteDAO.getEstudiantePorId("00000278954");
        System.out.println(e.toString());
        conexionBD.cerrarEntityManagerFactory();
    }
}
