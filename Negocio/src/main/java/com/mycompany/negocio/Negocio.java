/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.negocio;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.ReporteDTO;
import Dtos.ReservaDTO;
import conversiones.Conversiones;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.EstudianteDAO;
import daos.ReporteDAO;
import daos.ReservaDAO;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import interfaces.IReporteDAO;
import interfaces.IReservaDAO;
import interfaces.IReservacionNegocio;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import negocio_reservacion.ReservacionNegocio;
import reportes.ReporteLaboratorio;

/**
 *
 * @author ang3lfco
 */
public class Negocio {

    public static void main(String[] args) {
        try {
            IConexionBD conexionBD = new ConexionBD();
            IReporteDAO reporte = new ReporteDAO(conexionBD);
            
            List<ReporteDTO> reportes = reporte.consultarReservas(LocalDate.of(2025, Month.APRIL, 9), LocalDate.now());
            
            ReporteLaboratorio reportePDF = new ReporteLaboratorio();
            reportePDF.Reporte(LocalDate.of(2025, Month.APRIL, 9), LocalDate.now(), reportes);
        } catch (PersistenciaException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
