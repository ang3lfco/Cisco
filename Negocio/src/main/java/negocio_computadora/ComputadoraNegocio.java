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
import Entidades.HorarioEspecial;
import Entidades.Laboratorio;
import Entidades.Reserva;
import Entidades.Software;
import encriptamiento.Encriptador;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IComputadoraNegocio;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IReservaDAO;
import java.time.LocalDate;
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
    private IHorarioEspecialDAO heDAO;
    
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

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, IReservaDAO reservaDAO, IEstudianteDAO estudianteDAO, IHorarioEspecialDAO heDAO) {
        this.computadoraDAO = computadoraDAO;
        this.reservaDAO = reservaDAO;
        this.estudianteDAO = estudianteDAO;
        this.heDAO = heDAO;
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
    public void editarReserva(ReservaDTO reserva) throws NegocioException {
        try {
            Reserva reservaEntidad = this.convertirReservaDTOAEntidad(reserva);

            reservaDAO.editarReserva(reservaEntidad);
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
     
     private Reserva convertirReservaDTOAEntidad(ReservaDTO dto) {

        Estudiante estudiante = new Estudiante();
        Computadora computadora = new Computadora();
        HorarioEspecial horario = new HorarioEspecial();

        estudiante.setId(dto.getEstudiante().getId());
        computadora.setId(dto.getComputadora().getId());

        String etiqueta = dto.getComputadora().getEtiqueta();
        System.out.println("Etiqueta: " + etiqueta);
        computadora.setEtiqueta(etiqueta);
        
        try {
            horario.setId(heDAO.buscarHorarioPorDia(LocalDate.now()).getId());
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComputadoraNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            List<SoftwareDTO> softwares = this.computadoraDAO.consultarSoftwareDeComputadoras(
                    dto.getComputadora().getDireccionIp(),
                    dto.getComputadora().getTipo());

            computadora.setSoftwares(this.softwaresDTOAEntidad(softwares));
        } catch (PersistenciaException ex) {
            Logger.getLogger(ComputadoraNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }

        Reserva reservaEntidad = new Reserva(
                dto.getId(),
                dto.getHoraInicio(),
                dto.getMinutosSeleccionados(),
                dto.getHoraFin(),
                dto.getMinutosUsados(),
                computadora,
                estudiante,
                horario
        );

        return reservaEntidad;
    }
}
