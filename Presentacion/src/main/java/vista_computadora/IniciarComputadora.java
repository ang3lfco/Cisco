/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vista_computadora;

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
import negocio_computadora.ComputadoraNegocio;

/**
 *
 * @author ReneEzequiel23
 */
public class IniciarComputadora {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        IConexionBD conexion = new ConexionBD();
        IReservaDAO rDAO = new ReservaDAO(conexion);
        IComputadoraDAO cDAO = new ComputadoraDAO(conexion);
        IEstudianteDAO eDAO = new EstudianteDAO(conexion);
        IHorarioEspecialDAO hDAO = new HorarioEspecialDAO(conexion);
        
        IComputadoraNegocio cNegocio = new ComputadoraNegocio(cDAO,rDAO,eDAO,hDAO);
        frmComputadora computadora = new frmComputadora(cNegocio);
        
        computadora.setVisible(true);
    }
    
}
