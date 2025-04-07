/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negocio;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.ReservaDTO;
import daos.ConexionBD;
import daos.ReservaDAO;
import excepciones.NegocioException;
import interfaces.IConexionBD;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_reservacion.ReservacionNegocio;

/**
 *
 * @author ang3lfco
 */
public class Negocio {

    public static void main(String[] args) {
        IConexionBD conexion = new ConexionBD();
        IReservaDAO reservaDAO = new ReservaDAO(conexion);
        IReservacionNegocio reservacion = new ReservacionNegocio(reservaDAO);
        ComputadoraDTO pc = new ComputadoraDTO();
        EstudianteDTO es = new EstudianteDTO();
        pc.setId(1L);
        es.setId(1L);
        ReservaDTO r = new ReservaDTO(5L,LocalDate.now(), LocalTime.now(), LocalTime.now().plusMinutes(20L),pc,es);
        
        try {
            reservacion.editarReserva(r);
        } catch (NegocioException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
