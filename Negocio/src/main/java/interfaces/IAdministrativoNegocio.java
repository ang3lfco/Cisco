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
import Dtos.CargaLaboratorioDTO;
import Dtos.ComputadoraDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.ConsultarLaboratorioDTO;
import Dtos.EditarEquipoDTO;
import Dtos.EditarEstudianteDTO;
import Dtos.EditarLaboratoriosDTO;
import Dtos.EstudianteTablaDTO;
import Dtos.InstitutoDTO;
import Dtos.LaboratoriosTablaDTO;
import Entidades.Instituto;
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
    EditarEstudianteDTO getEstudiantePorIdEstudiante(String idEstudiante) throws NegocioException;
    void editarEstudiante(EditarEstudianteDTO estudianteDTO) throws NegocioException;
    List<ComputadoraDTO> getComputadoras() throws NegocioException;
    void eliminarEstudiante(String idEstudiante) throws NegocioException;
    void editarComputadora(EditarEquipoDTO equipo,EditarEquipoDTO equipoEditado);
    void eliminarComputadora(EditarEquipoDTO equipo);
    ConsultarLaboratorioDTO getLaboratorioPorNombre(String nombre) throws NegocioException;
    boolean validarContraseña(String original, String encriptada);
    List<LaboratoriosTablaDTO> getLaboratorios() throws NegocioException;
    void editarLaboratorio(EditarLaboratoriosDTO laboratorio, EditarLaboratoriosDTO editado);
    void eliminarLaboratorio(EditarLaboratoriosDTO labDTO);
    void agregarInstitutoConLaboratorios(InstitutoDTO institutoDTO) throws NegocioException;
    void agregarLaboratorioConInstituto(CargaLaboratorioDTO laboratorioDTO) throws NegocioException;
}
