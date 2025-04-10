/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_administrativo;

import Dtos.AgregarBloqueoDTO;
import Dtos.AgregarComputadoraDTO;
import Dtos.AgregarEstudianteDTO;
import Dtos.AgregarHorarioEspecialDTO;
import Dtos.AgregarLaboratorioDTO;
import Dtos.AgregarSoftwareDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.EstudianteTablaDTO;
import Entidades.Bloqueo;
import Entidades.Carrera;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import Entidades.Laboratorio;
import Entidades.Software;
import conversiones.Conversiones;
import encriptamiento.Encriptador;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAdministrativoNegocio;
import interfaces.IBloqueoDAO;
import interfaces.ICarreraDAO;
import interfaces.IComputadoraDAO;
import interfaces.IEstudianteDAO;
import interfaces.IHorarioEspecialDAO;
import interfaces.IInstitutoDAO;
import interfaces.ILaboratorioDAO;
import interfaces.ISoftwareDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class AdministrativoNegocio implements IAdministrativoNegocio{
    private IComputadoraDAO computadoraDAO;
    private ILaboratorioDAO laboratorioDAO;
    private ISoftwareDAO softwareDAO;
    private IBloqueoDAO bloqueoDAO;
    private IEstudianteDAO estudianteDAO;
    private IHorarioEspecialDAO horarioEspecialDAO;
    private ICarreraDAO carreraDAO;
    private IInstitutoDAO institutoDAO;
    
    public AdministrativoNegocio(IComputadoraDAO computadoraDAO, ILaboratorioDAO laboratorioDAO, ISoftwareDAO softwareDAO, IBloqueoDAO bloqueoDAO, IEstudianteDAO estudianteDAO, IHorarioEspecialDAO horarioEspecialDAO, ICarreraDAO carreraDAO, IInstitutoDAO institutoDAO){
        this.computadoraDAO = computadoraDAO;
        this.laboratorioDAO = laboratorioDAO;
        this.softwareDAO = softwareDAO;
        this.bloqueoDAO = bloqueoDAO;
        this.estudianteDAO = estudianteDAO;
        this.horarioEspecialDAO = horarioEspecialDAO;
        this.carreraDAO = carreraDAO;
        this.institutoDAO = institutoDAO;
    }
    
    @Override
    public void agregarEquipo(AgregarComputadoraDTO computadoraDTO) throws NegocioException{
        try{
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(computadoraDTO.getLaboratorio());
            Computadora equipo = Conversiones.computadoraDTOEnEntidad(computadoraDTO, lab);
            computadoraDAO.agregarComputadora(equipo);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarSoftware(AgregarSoftwareDTO softwareDTO) throws NegocioException{
        try{
            Software software = Conversiones.softwareDTOEnEntidad(softwareDTO);
            softwareDAO.agregar(software);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarBloqueo(AgregarBloqueoDTO bloqueoDTO) throws NegocioException{
        try{
            Estudiante estudiante = estudianteDAO.getEstudiantePorId(bloqueoDTO.getIdEstudiante());
            Bloqueo bloqueo = Conversiones.bloqueoDTOEnEntidad(bloqueoDTO, estudiante);
            bloqueoDAO.agregar(bloqueo);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void desbloquear(String idEstudiante) throws NegocioException{
        try{
            bloqueoDAO.desbloquear(idEstudiante);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarHorarioEspecial(AgregarHorarioEspecialDTO horarioEspecialDTO, String nombreLab) throws NegocioException {
        try {
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(nombreLab);
            HorarioEspecial horario = Conversiones.horarioEspecialDTOEnEntidad(horarioEspecialDTO, lab);
            horarioEspecialDAO.agregarHorarioEspecial(horario);
        } 
        catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarInstalacion(int numeroComputadora, String nombreSoftware) throws NegocioException {
        try{
            Computadora c = computadoraDAO.getComputadoraPorNumero(numeroComputadora);
            Software s = softwareDAO.getSoftwarePorNombre(nombreSoftware);
            
            c.getSoftwares().add(s);
            computadoraDAO.editarComputadora(c);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ConsultarEstudianteDTO> getEstudiantes() throws NegocioException {
        try{
            List<Estudiante> estudiantes = estudianteDAO.getEstudiantes();
            List<ConsultarEstudianteDTO> eDto = new ArrayList<>();
            for(Estudiante e : estudiantes){
                eDto.add(Conversiones.entidadEnConsultarEstudianteDTO(e));
            }
            return eDto;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarEstudiante(AgregarEstudianteDTO estudianteDTO) throws NegocioException{
        try{
            Carrera carrera = carreraDAO.getCarreraPorId(estudianteDTO.getIdCarrera());
            Estudiante e = Conversiones.AgregarEstudianteDtoAEntidad(estudianteDTO, carrera);
            e.setContraseña(Encriptador.encriptarContraseña(e.getContraseña()));
            estudianteDAO.agregar(e);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarLaboratorio(AgregarLaboratorioDTO laboratorioDTO) throws NegocioException{
        try{
            Instituto i = institutoDAO.getInstitutoPorId(laboratorioDTO.getIdInstituto());
            Laboratorio lab = Conversiones.AgregarLaboratorioDtoAEntidad(laboratorioDTO, i);
            lab.setContraseña(Encriptador.encriptarContraseña(lab.getContraseña()));
            laboratorioDAO.agregarLaboratorio(lab);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<EstudianteTablaDTO> getEstudiantesTabla() throws NegocioException {
        try{
            List<EstudianteTablaDTO> estudiantesDTO = new ArrayList<>();
            List<Estudiante> estudiantesDAO = estudianteDAO.getEstudiantes();
            
            for(Estudiante e : estudiantesDAO){
                EstudianteTablaDTO estudiante = Conversiones.estudianteEntidadEnEstudianteTablaDTO(e);
                estudiantesDTO.add(estudiante);
            }
            return estudiantesDTO;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
}
