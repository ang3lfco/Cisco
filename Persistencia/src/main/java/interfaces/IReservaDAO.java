/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Entidades.Reserva;
import excepciones.PersistenciaException;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReservaDAO {
    void agregarReserva(Reserva reserva) throws PersistenciaException;
    void eliminarReserva(Long id) throws PersistenciaException;
    void editarReserva(Reserva reserva) throws PersistenciaException;
    
}
