/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia;

import Entidades.Instituto;
import daos.ConexionBD;
import daos.InstitutoDAO;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IInstitutoDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang3lfco
 */
public class Persistencia {

    public static void main(String[] args) {
        IConexionBD conexion = new ConexionBD();
        
        IInstitutoDAO ins = new InstitutoDAO(conexion);
        
        try {
            Instituto instituto = new Instituto("nombre2","alias3");
            instituto.setId(2L);
            ins.eliminarInstituto(2L);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
