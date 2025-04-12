/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Dtos.ReservaDTO;
import Dtos.minutosUsadosPorEstudianteDTO;
import Entidades.Reserva;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReservaDAO {
    void agregarReserva(Reserva reserva) throws PersistenciaException;
    void eliminarReserva(Long id) throws PersistenciaException;
    void editarReserva(Reserva reserva) throws PersistenciaException;
    List<ReservaDTO> consultarReservas() throws PersistenciaException;
    ReservaDTO consultarReserva(String ip) throws PersistenciaException;
    minutosUsadosPorEstudianteDTO minutosUsadosPorEstudiante(String id, LocalDate fecha);
}
