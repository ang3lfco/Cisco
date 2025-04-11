/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import Entidades.*;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.ReservaDAO;
import daos.SoftwareDAO;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IReservaDAO;
import interfaces.ISoftwareDAO;
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
        IConexionBD bd = new ConexionBD();
        IReservaDAO reservaDAO = new ReservaDAO(bd);
        IComputadoraDAO soft = new ComputadoraDAO(bd);
        
//        for (int i = 0; i < soft.consultarSoftwareDeComputadoras("192.168.0.14").size(); i++) {
//            System.out.println(soft.consultarSoftwareDeComputadoras("192.168.0.14").get(i).getNombre());
//        }
        
       }
}
