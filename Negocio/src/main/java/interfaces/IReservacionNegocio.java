/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import excepciones.NegocioException;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IReservacionNegocio {
    void agregarReserva(ReservaDTO reserva) throws NegocioException;
    void editarReserva(ReservaDTO reserva) throws NegocioException;
    List<ComputadoraDTO> numeroComputadorasDTO(Long id,String tipo) throws NegocioException;
    EstudianteIngresaDTO buscarIDEstudiante(String id) throws NegocioException;
    ComputadoraDTO computadoraPorIp(String ip) throws NegocioException;
    List<SoftwareDTO> softareDeComputadoraDTO(String ip) throws NegocioException;
    void editarComputadora(ComputadoraDTO pc) throws NegocioException;
    HorarioEspecialDTO buscarHorarioEspecialPorDia(LocalDate hoy) throws NegocioException;
    void agregarHorarioEspecial(HorarioEspecialDTO horarioEspecialDTO) throws NegocioException;
    ComputadoraDTO computadoraPorIpYTipo(String ip,String tipo) throws NegocioException;
}
