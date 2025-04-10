/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista_reservacion;

import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.HorarioEspecialDAO;
import daos.ReservaDAO;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import negocio_reservacion.ReservacionNegocio;

/**
 *
 * @author ReneEzequiel23
 */
public class IniciarReservacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IConexionBD conexion = new ConexionBD();
        IReservaDAO rDAO = new ReservaDAO(conexion);
        IComputadoraDAO cDAO = new ComputadoraDAO(conexion);
        IEstudianteDAO eDAO = new EstudianteDAO(conexion);
        IHorarioEspecialDAO heDAO = new HorarioEspecialDAO(conexion);
//        
        IReservacionNegocio rNegocio = new ReservacionNegocio(rDAO,cDAO,eDAO,heDAO);
        frmReservacion reservacion = new frmReservacion(rNegocio);
        
        reservacion.setVisible(true);
    }
    
}
