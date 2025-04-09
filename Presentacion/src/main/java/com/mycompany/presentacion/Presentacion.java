/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.presentacion;

import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.HorarioEspecialDAO;
import daos.ReservaDAO;
import interfaces.IComputadoraDAO;
import interfaces.IComputadoraNegocio;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import java.net.InetAddress;
import java.net.UnknownHostException;
import negocio_computadora.ComputadoraNegocio;
import negocio_reservacion.ReservacionNegocio;
import vista_computadora.frmComputadora;
import vista_reservacion.frmMenuComputadoras;
import vista_reservacion.frmReservacion;

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
        IEstudianteDAO eDAO = new EstudianteDAO(conexion);
        IHorarioEspecialDAO heDAO = new HorarioEspecialDAO(conexion);
        
        IReservacionNegocio rNegocio = new ReservacionNegocio(rDAO,cDAO,eDAO,heDAO);
        frmReservacion reservacion = new frmReservacion(rNegocio);
        
        reservacion.setVisible(true);
        
        IComputadoraNegocio cNegocio = new ComputadoraNegocio(cDAO,rDAO);
        frmComputadora computadora = new frmComputadora(cNegocio);
        
        computadora.setVisible(true);
        
        
        
        try {
            InetAddress direccion = InetAddress.getLocalHost();
            String ip = direccion.getHostAddress();
            System.out.println("La dirección IP de este equipo es: " + ip);
        } catch (UnknownHostException e) {
            System.err.println("No se pudo obtener la IP.");
            e.printStackTrace();
        }

    }
}
