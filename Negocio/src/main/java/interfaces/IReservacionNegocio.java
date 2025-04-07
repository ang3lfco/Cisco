/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ReservaDTO;
import excepciones.NegocioException;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReservacionNegocio {
    void agregarReserva(ReservaDTO reserva) throws NegocioException;
    void editarReserva(ReservaDTO reserva) throws NegocioException;
}
