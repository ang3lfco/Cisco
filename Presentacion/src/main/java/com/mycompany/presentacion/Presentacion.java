/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.presentacion;

import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.ReservaDAO;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import negocio_reservacion.ReservacionNegocio;
import vista_reservacion.frmMenuComputadoras;

/**
 *
 * @author ang3lfco
 */
public class Presentacion {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        IConexionBD conexion = new ConexionBD();
        IReservaDAO rDAO = new ReservaDAO(conexion);
        IComputadoraDAO cDAO = new ComputadoraDAO(conexion);
        IReservacionNegocio rNegocio = new ReservacionNegocio(rDAO,cDAO);
        frmMenuComputadoras compus = new frmMenuComputadoras(rNegocio,1L);
        
        compus.setVisible(true);
    }
}
