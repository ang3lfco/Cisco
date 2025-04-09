/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_reservacion;

import Dtos.AgregarHorarioEspecialDTO;
import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Laboratorio;
import Entidades.Reserva;
import conversiones.Conversiones;
import static conversiones.Conversiones.convertirComputadoraDTOAComputadora;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang3lfco
 */
public class ReservacionNegocio implements IReservacionNegocio {

    private IReservaDAO reservaDAO;
    private IComputadoraDAO computadoraDAO;
    private IEstudianteDAO estudianteDAO;
    private IHorarioEspecialDAO horarioEspecialDAO;

    public ReservacionNegocio(IReservaDAO reservaDAO, IComputadoraDAO computadoraDAO, IEstudianteDAO estudianteDAO) {
        this.reservaDAO = reservaDAO;
        this.computadoraDAO = computadoraDAO;
        this.estudianteDAO = estudianteDAO;
    }

    public ReservacionNegocio(IReservaDAO reservaDAO, IComputadoraDAO computadoraDAO, IEstudianteDAO estudianteDAO, IHorarioEspecialDAO horarioEspecialDAO) {
        this.reservaDAO = reservaDAO;
        this.computadoraDAO = computadoraDAO;
        this.estudianteDAO = estudianteDAO;
        this.horarioEspecialDAO = horarioEspecialDAO;
    }

    @Override
    public void agregarReserva(ReservaDTO reserva) throws NegocioException {
        try {
            Reserva reservaEntidad = this.convertirReservaDTOAEntidad(reserva);

            reservaDAO.agregarReserva(reservaEntidad);
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
    public void editarComputadora(ComputadoraDTO pc) throws NegocioException {
        try {
            Computadora entidad = this.convertirComputadoraDTOAComputadora(pc);

            computadoraDAO.editarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }

    @Override
    public List<ComputadoraDTO> numeroComputadorasDTO(Long id, String tipo) throws NegocioException {
        try {
            List<ComputadoraDTO> lista = computadoraDAO.consultarNumeroComputadorasPorLaboratorio(id, tipo);

            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }

    @Override
    public List<SoftwareDTO> softareDeComputadoraDTO(String ip) throws NegocioException {
        try {
            List<SoftwareDTO> lista = computadoraDAO.consultarSoftwareDeComputadoras(ip);

            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }

    @Override
    public ComputadoraDTO computadoraPorIp(String ip) throws NegocioException {
        try {
            ComputadoraDTO dto = computadoraDAO.consultarComputadorasPorIP(ip);

            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
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
    public HorarioEspecialDTO buscarHorarioEspecialPorDia(LocalDate hoy) throws NegocioException {
        try {
            if (horarioEspecialDAO.buscarHorarioPorDia(hoy) == null) {
                return null;
            }

            HorarioEspecialDTO he = horarioEspecialDAO.buscarHorarioPorDia(hoy);
            return he;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }

    @Override
    public void agregarHorarioEspecial(HorarioEspecialDTO horarioEspecialDTO) throws NegocioException {
        try {
            HorarioEspecial hEntidad = this.convertirHorarioDTOAEntidad(horarioEspecialDTO);

            horarioEspecialDAO.agregarHorarioEspecial(hEntidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }

    public EstudianteIngresaDTO buscarIDEstudiante(String id) throws NegocioException {
        try {
            if (estudianteDAO.buscarPorIDAlumno(id) == null) {
                return null;
            }
            EstudianteIngresaDTO estudiante = estudianteDAO.buscarPorIDAlumno(id);
            return estudiante;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }

    private Reserva convertirReservaDTOAEntidad(ReservaDTO dto) {

        Estudiante estudiante = new Estudiante();
        Computadora computadora = new Computadora();
        HorarioEspecial horario = new HorarioEspecial();

        estudiante.setId(dto.getEstudiante().getId());
        computadora.setId(dto.getComputadora().getId());
        horario.setId(dto.getHorario().getId());

        Reserva reservaEntidad = new Reserva(
                dto.getId(),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                computadora,
                estudiante,
                horario
        );

        return reservaEntidad;
    }

    private HorarioEspecial convertirHorarioDTOAEntidad(HorarioEspecialDTO dto) {

        Laboratorio lab = new Laboratorio();
        lab.setId(dto.getLaboratorio().getId());

        HorarioEspecial entidad = new HorarioEspecial(
                dto.getId(),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                lab
        );

        return entidad;
    }

    public Computadora convertirComputadoraDTOAComputadora(ComputadoraDTO computadoraDTO) {
        if (computadoraDTO == null) {
            return null;
        }
        
        Laboratorio lab = new Laboratorio();
        lab.setId(computadoraDTO.getId());

        Computadora computadora = new Computadora();
        computadora.setId(computadoraDTO.getId());
        computadora.setNumero(computadoraDTO.getNumero());
        computadora.setEstado(computadoraDTO.isEstado());
        computadora.setDireccionIp(computadoraDTO.getDireccionIp());
        computadora.setTipo(computadoraDTO.getTipo());
        computadora.setLaboratorio(lab);
        
        return computadora;
    }
}
