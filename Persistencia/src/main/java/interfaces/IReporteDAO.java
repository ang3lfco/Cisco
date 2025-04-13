/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ReporteDTO;
import excepciones.PersistenciaException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReporteDAO {
     List<ReporteDTO> consultarReservas(LocalDate inicio, LocalDate fin) throws PersistenciaException;
}
