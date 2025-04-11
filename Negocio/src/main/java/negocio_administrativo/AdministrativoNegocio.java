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
import Dtos.CargaLaboratorioDTO;
import Dtos.ComputadoraDTO;
import Dtos.ConsultarCarreraDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.ConsultarLaboratorioDTO;
import Dtos.ConsultarSoftwareDTO;
import Dtos.EditarEquipoDTO;
import Dtos.EditarEstudianteDTO;
import Dtos.EditarLaboratoriosDTO;
import Dtos.EstudianteTablaDTO;
import Dtos.InstitutoDTO;
import Dtos.LaboratorioDTO;
import Dtos.LaboratoriosTablaDTO;
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
import java.util.logging.Level;
import java.util.logging.Logger;

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
            equipo.setEtiqueta(computadoraDTO.getEtiqueta());
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
    
    @Override
    public EditarEstudianteDTO getEstudiantePorIdEstudiante(String idEstudiante) throws NegocioException {
        try{
            Estudiante e = estudianteDAO.getEstudiantePorId(idEstudiante);
            EditarEstudianteDTO estudiante = Conversiones.EntidadAEditarEstudianteDto(e);
            return estudiante;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void editarEstudiante(EditarEstudianteDTO estudianteDTO) throws NegocioException {
        try{
            Carrera carrera = carreraDAO.getCarreraPorNombre(estudianteDTO.getCarrera());
            Estudiante estudianteOriginal = estudianteDAO.getEstudiantePorId(estudianteDTO.getIdEstudiante());
            estudianteOriginal.setNombre(estudianteDTO.getNombre());
            estudianteOriginal.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
            estudianteOriginal.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
            estudianteOriginal.setEstado(estudianteDTO.getEstado());
            if(estudianteDTO.getContraseña() != null || !estudianteDTO.getContraseña().isEmpty()){
                estudianteOriginal.setContraseña(Encriptador.encriptarContraseña(estudianteDTO.getContraseña()));
            }
            estudianteOriginal.setCarrera(carrera);
            estudianteDAO.editar(estudianteOriginal);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ComputadoraDTO> getComputadoras() throws NegocioException {
        try{
            List<ComputadoraDTO> computadoras = computadoraDAO.consultarComputadoras();
            
            return computadoras;

        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<LaboratoriosTablaDTO> getLaboratorios() throws NegocioException {
        try{
            List<LaboratoriosTablaDTO> laboratorios = laboratorioDAO.consultarLaboratorios();
            return laboratorios;

        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void eliminarEstudiante(String idEstudiante) throws NegocioException {
        try{
            Estudiante eliminacion = estudianteDAO.getEstudiantePorId(idEstudiante);
            estudianteDAO.eliminar(eliminacion.getId());
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void editarComputadora(EditarEquipoDTO equipo,EditarEquipoDTO equipoEditado){
        try {
            Computadora compu = computadoraDAO.getComputadoraPorLab(
                    equipo.getLaboratorio(),
                    equipo.getDireccionIp(),
                    equipo.getTipo());
            
            compu.setNumero(equipoEditado.getNumero());
            compu.setDireccionIp(equipoEditado.getDireccionIp());
            compu.setTipo(equipoEditado.getTipo());
            
            computadoraDAO.editarComputadora(compu);
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(AdministrativoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminarComputadora(EditarEquipoDTO equipo){
        try {
            Computadora compu = computadoraDAO.getComputadoraPorLab(
                    equipo.getLaboratorio(),
                    equipo.getDireccionIp(),
                    equipo.getTipo());
            
            computadoraDAO.eliminarComputadora(compu.getId());
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(AdministrativoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public ConsultarLaboratorioDTO getLaboratorioPorNombre(String nombre) throws NegocioException {
        try{
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(nombre);
            return new ConsultarLaboratorioDTO(String.valueOf(lab.getId()), lab.getNombre(), lab.getContraseña());
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void editarLaboratorio(EditarLaboratoriosDTO laboratorio, EditarLaboratoriosDTO editado){
        try {
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(laboratorio.getNombre());
            lab.setNombre(editado.getNombre());
            lab.setContraseña(editado.getContraseña());
            lab.setHoraInicio(editado.getHoraInicio());
            lab.setHoraFin(editado.getHoraFin());
            
            laboratorioDAO.editarLaboratorio(lab);
        } catch (PersistenciaException ex) {
            Logger.getLogger(AdministrativoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void eliminarLaboratorio(EditarLaboratoriosDTO labDTO){
        try {
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(labDTO.getNombre());
            
            laboratorioDAO.eliminarLaboratorio(lab.getId());
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(AdministrativoNegocio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public boolean validarContraseña(String original, String encriptada){
        return Encriptador.verificarContraseña(original, encriptada);
    }
    
    @Override
    public void agregarInstitutoConLaboratorios(InstitutoDTO institutoDTO) throws NegocioException {
        try{
            List<Laboratorio> labs = new ArrayList<>();
            Instituto instituto = new Instituto(institutoDTO.getNombre(), institutoDTO.getSiglas(), labs);
            List<Computadora> equipos = new ArrayList<>();
            List<HorarioEspecial> horarios = new ArrayList<>();
            for(LaboratorioDTO labDto : institutoDTO.getLaboratorios()){
                Laboratorio l = new Laboratorio(labDto.getNombre(), labDto.getHoraInicio(), labDto.getHoraFin(), Encriptador.encriptarContraseña(labDto.getContraseña()), instituto, equipos, horarios);
                labs.add(l);
            }
            institutoDAO.agregarInstituto(instituto);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarLaboratorioConInstituto(CargaLaboratorioDTO laboratorioDTO) throws NegocioException{
        try{
            Instituto instituto = Conversiones.convertirInstitutoDTOAInstituto(laboratorioDTO.getInstituto());
            Laboratorio laboratorio = new Laboratorio(
                    laboratorioDTO.getNombre(),
                    laboratorioDTO.getHoraInicio(), 
                    laboratorioDTO.getHoraFin(),
                    laboratorioDTO.getContraseña(),
                    instituto,
                    new ArrayList<>(),
                    new ArrayList<>()
            );
            laboratorioDAO.agregarLaboratorio(laboratorio);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ConsultarLaboratorioDTO> getListaLaboratorios() throws NegocioException {
        try{
            List<Laboratorio> entidades = laboratorioDAO.getLaboratorios();
            List<ConsultarLaboratorioDTO> dtos = new ArrayList<>();
            for(Laboratorio l : entidades){
                ConsultarLaboratorioDTO ldto = new ConsultarLaboratorioDTO(String.valueOf(l.getId()), l.getNombre(), l.getContraseña());
                dtos.add(ldto);
            }
            return dtos;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ConsultarSoftwareDTO> getListaSoftwares() throws NegocioException {
        try{
            List<Software> entidades = softwareDAO.getSoftwares();
            List<ConsultarSoftwareDTO> dtos = new ArrayList<>();
            for(Software s : entidades){
                ConsultarSoftwareDTO sdto = new ConsultarSoftwareDTO(s.getNombre(), s.getVersion());
                dtos.add(sdto);
            }
            return dtos;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public List<ConsultarCarreraDTO> getListaCarreras() throws NegocioException {
        try{
            List<Carrera> carreras = carreraDAO.getCarreras();
            List<ConsultarCarreraDTO> dtos = new ArrayList<>();
            for(Carrera c : carreras){
                ConsultarCarreraDTO cdto = new ConsultarCarreraDTO(c.getId(), c.getNombre(), c.getTiempoDiario());
                dtos.add(cdto);
            }
            return dtos;
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
}
