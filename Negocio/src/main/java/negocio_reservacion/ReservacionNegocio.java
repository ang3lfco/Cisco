/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_reservacion;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.Reserva;
import static conversiones.Conversiones.convertirComputadoraDTOAComputadora;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IEstudianteDAO;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
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

    public ReservacionNegocio(IReservaDAO reservaDAO, IComputadoraDAO computadoraDAO, IEstudianteDAO estudianteDAO) {
        this.reservaDAO = reservaDAO;
        this.computadoraDAO = computadoraDAO;
        this.estudianteDAO = estudianteDAO;
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
            Computadora entidad = convertirComputadoraDTOAComputadora(pc);

            computadoraDAO.editarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ComputadoraDTO> numeroComputadorasDTO(Long id) throws NegocioException{
        try {
            List<ComputadoraDTO> lista = computadoraDAO.consultarNumeroComputadorasPorLaboratorio(id);
            
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public List<SoftwareDTO> softareDeComputadoraDTO(String ip) throws NegocioException{
        try {
            List<SoftwareDTO> lista = computadoraDAO.consultarSoftwareDeComputadoras(ip);
            
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public ComputadoraDTO computadoraPorIp(String ip) throws NegocioException{
        try {
            ComputadoraDTO lista = computadoraDAO.consultarComputadorasPorIP(ip);
            
            return lista;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public EstudianteIngresaDTO buscarIDEstudiante(String id) throws NegocioException{
        try {
            EstudianteIngresaDTO estudiante = estudianteDAO.buscarPorIDAlumno(id);
            return estudiante;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }

    private Reserva convertirReservaDTOAEntidad(ReservaDTO dto) {

        Estudiante estudiante = new Estudiante();
        Computadora computadora = new Computadora();

        estudiante.setId(dto.getEstudiante().getId());
        computadora.setId(dto.getComputadora().getId());

        Reserva reservaEntidad = new Reserva(
                dto.getId(),
                dto.getFecha(),
                dto.getHoraInicio(),
                dto.getHoraFin(),
                computadora,
                estudiante
        );

        return reservaEntidad;
    }
}
