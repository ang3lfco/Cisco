/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_reservacion;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.ReservaDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.Reserva;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;

/**
 *
 * @author ang3lfco
 */
public class ReservacionNegocio implements IReservacionNegocio {

    private IReservaDAO reservaDAO;

    public ReservacionNegocio(IReservaDAO reservaDAO) {
        this.reservaDAO = reservaDAO;
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
