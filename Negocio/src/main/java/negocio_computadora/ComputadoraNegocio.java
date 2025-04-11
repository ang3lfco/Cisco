/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_computadora;

import Dtos.ComputadoraDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.Laboratorio;
import Entidades.Reserva;
import Entidades.Software;
import conversiones.Conversiones;
import static conversiones.Conversiones.convertirComputadoraDTOAComputadora;
import encriptamiento.Encriptador;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IComputadoraNegocio;
import interfaces.IEstudianteDAO;
import interfaces.IReservaDAO;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang3lfco
 */
public class ComputadoraNegocio implements IComputadoraNegocio{
    private IComputadoraDAO computadoraDAO;
    private IReservaDAO reservaDAO;
    private IEstudianteDAO estudianteDAO;
    
    public ComputadoraNegocio(IComputadoraDAO computadoraDAO) {
        this.computadoraDAO = computadoraDAO;
    }

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, IReservaDAO reservaDAO) {
        this.computadoraDAO = computadoraDAO;
        this.reservaDAO = reservaDAO;
    }

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, IReservaDAO reservaDAO, IEstudianteDAO estudianteDAO) {
        this.computadoraDAO = computadoraDAO;
        this.reservaDAO = reservaDAO;
        this.estudianteDAO = estudianteDAO;
    }
    
    
    @Override
    public ComputadoraDTO computadoraPorIp(String ip) throws NegocioException{
        try {
            if (computadoraDAO.consultarComputadorasPorIP(ip) == null) {
                return null;
            }
            ComputadoraDTO dto = computadoraDAO.consultarComputadorasPorIP(ip);
            
            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public ReservaDTO reservaPorComputadora(String ip) throws NegocioException{
        try {
            if (reservaDAO.consultarReserva(ip) == null) {
                return null;
            }
            ReservaDTO dto = reservaDAO.consultarReserva(ip);
            
            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public void editarComputadora(ComputadoraDTO pc) throws NegocioException {
        try {
            Computadora entidad = this.convertirComputadoraDTOAComputadora(pc);

            computadoraDAO.editarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public ComputadoraDTO computadoraPorIpYTipo(String ip, String tipo) throws NegocioException {
        try {
            ComputadoraDTO dto = computadoraDAO.consultarComputadorasPorIPYTipo(ip, tipo);

            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    
    @Override
    public boolean validarContrasenhaEstudiante(String contrasenha, String idEstudiante) throws NegocioException {
        try {
            Estudiante estudiante = estudianteDAO.getEstudiantePorId(idEstudiante);
            
            if (this.validarContraseña(contrasenha, estudiante.getContraseña())) {
                return true;
            }
            
            return false;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
     public Computadora convertirComputadoraDTOAComputadora(ComputadoraDTO computadoraDTO) {
        if (computadoraDTO == null) {
            return null;
        }
        Laboratorio lab = new Laboratorio();
        lab.setId(computadoraDTO.getLaboratorio().getId());

        Computadora computadora = new Computadora();
        computadora.setId(computadoraDTO.getId());
        computadora.setNumero(computadoraDTO.getNumero());
        computadora.setEstado(computadoraDTO.isEstado());
        computadora.setDireccionIp(computadoraDTO.getDireccionIp());
        computadora.setTipo(computadoraDTO.getTipo());
        computadora.setLaboratorio(lab);
        computadora.setEtiqueta(computadoraDTO.getEtiqueta());
        
        try {
            List<SoftwareDTO> softwares = this.computadoraDAO.consultarSoftwareDeComputadoras(computadora.getDireccionIp(), computadora.getTipo());
            computadora.setSoftwares(this.softwaresDTOAEntidad(softwares));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComputadoraNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
        return computadora;
    }
     
     public boolean validarContraseña(String original, String encriptada){
        return Encriptador.verificarContraseña(original, encriptada);
    }
     
     private List<Software> softwaresDTOAEntidad(List<SoftwareDTO> dtos){
         List<Software> entidades = new ArrayList<>();
         
         
         for (SoftwareDTO softwares : dtos) {
             Software software = new Software();
                software.setId(softwares.getId());
                entidades.add(software);
            }
         return entidades;
     }
}
