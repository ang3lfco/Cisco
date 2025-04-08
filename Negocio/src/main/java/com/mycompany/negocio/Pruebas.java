/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.negocio;

import Dtos.AgregarComputadoraDTO;
import Dtos.ComputadoraDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Laboratorio;
import conversiones.Conversiones;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.LaboratorioDAO;
import excepciones.NegocioException;
import interfaces.IAdministrativoNegocio;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.ILaboratorioDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import negocio_administrativo.AdministrativoNegocio;

/**
 *
 * @author ang3lfco
 */
public class Pruebas {
    public static void main(String[] args) throws NegocioException {
        IConexionBD conexionBD = new ConexionBD();
        IComputadoraDAO computadoraDAO = new ComputadoraDAO(conexionBD);
        ILaboratorioDAO laboratorioDAO = new LaboratorioDAO(conexionBD);
//        IAdministrativoNegocio adminNegocio = new AdministrativoNegocio(computadoraDAO, laboratorioDAO);
        
        EntityManager em = conexionBD.obtenerEntityManager();
//        Laboratorio cisco = em.createQuery("SELECT l FROM Laboratorio l WHERE l.nombre = :nombre", Laboratorio.class)
//                        .setParameter("nombre", "Cisco")
//                        .getSingleResult();
        
//        LaboratorioDTO labDTO = Conversiones.convertirLaboratorioALaboratorioDTO(cisco);
        List<ReservaDTO> reservas = new ArrayList<>();
        List<SoftwareDTO> instalaciones = new ArrayList<>();
        AgregarComputadoraDTO equipo = new AgregarComputadoraDTO(4, true, "192.168.0.104", "Cisco");
//        adminNegocio.agregarEquipo(equipo);
        em.close();
        conexionBD.cerrarEntityManagerFactory();
    }
}
