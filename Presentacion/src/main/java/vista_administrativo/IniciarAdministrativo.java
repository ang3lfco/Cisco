/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista_administrativo;

import daos.BloqueoDAO;
import daos.CarreraDAO;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.HorarioEspecialDAO;
import daos.InstitutoDAO;
import daos.LaboratorioDAO;
import daos.SoftwareDAO;
import interfaces.IAdministrativoNegocio;
import interfaces.IBloqueoDAO;
import interfaces.ICarreraDAO;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IInstitutoDAO;
import interfaces.ILaboratorioDAO;
import interfaces.ISoftwareDAO;
import negocio_administrativo.AdministrativoNegocio;

/**
 *
 * @author ang3lfco
 */
public class IniciarAdministrativo {
    public static void main(String[] args) {
        IAdministrativoNegocio adminNegocio;
        IConexionBD conexion = new ConexionBD();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(conexion);
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO(conexion);
        ISoftwareDAO softwareDAO = new SoftwareDAO(conexion);
        IBloqueoDAO bloqueoDAO = new BloqueoDAO(conexion);
        IEstudianteDAO estudianteDAO = new EstudianteDAO(conexion);
        IHorarioEspecialDAO horarioEspecialDAO = new HorarioEspecialDAO(conexion);
        ICarreraDAO carreraDAO = new CarreraDAO(conexion);
        IInstitutoDAO institutoDAO = new InstitutoDAO(conexion);
        
        adminNegocio = new AdministrativoNegocio(computadoraDAO, laboratorioDAO, softwareDAO, bloqueoDAO, estudianteDAO, horarioEspecialDAO, carreraDAO, institutoDAO);
        frmAdmin admin = new frmAdmin(adminNegocio);
        admin.setVisible(true);
    }
}
