/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.ReservaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReservacionNegocio {
    void agregarReserva(ReservaDTO reserva) throws NegocioException;
    void editarReserva(ReservaDTO reserva) throws NegocioException;
    List<ComputadoraDTO> numeroComputadorasDTO(Long id) throws NegocioException;
    EstudianteIngresaDTO buscarIDEstudiante(String id) throws NegocioException;
}
