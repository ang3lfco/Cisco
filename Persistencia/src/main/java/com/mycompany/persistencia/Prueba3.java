/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.persistencia;

import daos.BloqueoDAO;
import daos.ConexionBD;
import excepciones.PersistenciaException;
import interfaces.IBloqueoDAO;
import interfaces.IConexionBD;

/**
 *
 * @author ang3lfco
 */
public class Prueba3 {
    public static void main(String[] args) throws PersistenciaException {
        IConexionBD conexionBD = new ConexionBD();
        IBloqueoDAO bdao = new BloqueoDAO(conexionBD);
        
        bdao.desbloquear("00000278954");
        conexionBD.cerrarEntityManagerFactory();
    }
}
