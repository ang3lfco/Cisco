/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.AgregarBloqueoDTO;
import Dtos.AgregarComputadoraDTO;
import Dtos.AgregarEstudianteDTO;
import Dtos.AgregarHorarioEspecialDTO;
import Dtos.AgregarLaboratorioDTO;
import Dtos.AgregarSoftwareDTO;
import Dtos.ComputadoraDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.EstudianteTablaDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface IAdministrativoNegocio {
    void agregarEquipo(AgregarComputadoraDTO computadoraDTO) throws NegocioException;
    void agregarSoftware(AgregarSoftwareDTO softwareDTO) throws NegocioException;
    void agregarBloqueo(AgregarBloqueoDTO bloqueoDTO) throws NegocioException;
    void desbloquear(String idEstudiante) throws NegocioException;
    void agregarHorarioEspecial(AgregarHorarioEspecialDTO horarioEspecialDTO, String nombreLab) throws NegocioException;
    void agregarInstalacion(int numeroComputadora, String nombreSoftware) throws NegocioException;
    List<ConsultarEstudianteDTO> getEstudiantes() throws NegocioException;
    void agregarEstudiante(AgregarEstudianteDTO estudianteDTO) throws NegocioException;
    void agregarLaboratorio(AgregarLaboratorioDTO laboratorioDTO) throws NegocioException;
    List<EstudianteTablaDTO> getEstudiantesTabla() throws NegocioException;
}
