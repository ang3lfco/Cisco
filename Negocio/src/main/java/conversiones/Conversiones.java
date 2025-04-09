/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conversiones;

import Dtos.AgregarBloqueoDTO;
import Dtos.AgregarComputadoraDTO;
import Dtos.AgregarEstudianteDTO;
import Dtos.AgregarHorarioEspecialDTO;
import Dtos.AgregarLaboratorioDTO;
import Dtos.AgregarSoftwareDTO;
import Dtos.BloqueoDTO;
import Dtos.CarreraDTO;
import Dtos.ComputadoraDTO;
import Dtos.ConsultarEstudianteDTO;
import Dtos.EstudianteDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.InstitutoDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Bloqueo;
import Entidades.Carrera;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import Entidades.Laboratorio;
import Entidades.Reserva;
import Entidades.Software;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class Conversiones {
    // Conversión de Computadora a ComputadoraDTO
    public static ComputadoraDTO convertirComputadoraAComputadoraDTO(Computadora computadora) {
        if (computadora == null) {
            return null;
        }

        // Convertir reservas si existen
        List<ReservaDTO> reservasDTO = new ArrayList<>();
        if (computadora.getReservas() != null) {
            for (Reserva reserva : computadora.getReservas()) {
                reservasDTO.add(convertirReservaAReservaDTO(reserva));
            }
        }

        // Convertir software instalado si existe
        List<SoftwareDTO> instalacionesDTO = new ArrayList<>();
        if (computadora.getSoftwares()!= null) {
            for (Software software : computadora.getSoftwares()) {
                instalacionesDTO.add(convertirSoftwareASoftwareDTO(software));
            }
        }

        ComputadoraDTO computadoraDTO = new ComputadoraDTO(
                computadora.getId(),
                computadora.getNumero(),
                computadora.isEstado(),
                computadora.getDireccionIp(),
                convertirLaboratorioALaboratorioDTO(computadora.getLaboratorio()),
                reservasDTO,
                instalacionesDTO
        );

        return computadoraDTO;
    }

    // Conversión de ComputadoraDTO a Computadora
    public static Computadora convertirComputadoraDTOAComputadora(ComputadoraDTO computadoraDTO) {
        if (computadoraDTO == null) {
            return null;
        }
        
        Computadora computadora = new Computadora();
        computadora.setId(computadoraDTO.getId());
        computadora.setNumero(computadoraDTO.getNumero());
        computadora.setEstado(computadoraDTO.isEstado());
        computadora.setDireccionIp(computadoraDTO.getDireccionIp());
        
        // Asignación de Laboratorio desde DTO
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setId(computadoraDTO.getLaboratorio().getId());
        computadora.setLaboratorio(laboratorio);

        return computadora;
    }

    // Conversión de Laboratorio a LaboratorioDTO
    public static LaboratorioDTO convertirLaboratorioALaboratorioDTO(Laboratorio laboratorio) {
        if (laboratorio == null) {
            return null;
        }

        // Convertir la lista de computadoras a una lista de ComputadoraDTO
        List<ComputadoraDTO> computadorasDTO = new ArrayList<>();
        if (laboratorio.getComputadoras() != null) {
            for (Computadora computadora : laboratorio.getComputadoras()) {
                computadorasDTO.add(convertirComputadoraAComputadoraDTO(computadora));
            }
        }

        // Convertir la lista de horarios especiales a una lista de HorarioEspecialDTO
        List<HorarioEspecialDTO> horariosEspecialesDTO = new ArrayList<>();
        if (laboratorio.getHorariosEspeciales() != null) {
            for (HorarioEspecial horarioEspecial : laboratorio.getHorariosEspeciales()) {
                horariosEspecialesDTO.add(convertirHorarioEspecialAHorarioEspecialDTO(horarioEspecial));
            }
        }

        // Crear y retornar el LaboratorioDTO
        LaboratorioDTO laboratorioDTO = new LaboratorioDTO(
                laboratorio.getNombre(),
                laboratorio.getHoraInicio(),
                laboratorio.getHoraFin(),
                laboratorio.getContraseña(),
                convertirInstitutoAInstitutoDTO(laboratorio.getInstituto()), // Convierte Instituto a DTO
                computadorasDTO,
                horariosEspecialesDTO
        );

        return laboratorioDTO;
    }

    // Conversión de LaboratorioDTO a Laboratorio
    public static Laboratorio convertirLaboratorioDTOALaboratorio(LaboratorioDTO laboratorioDTO) {
        if (laboratorioDTO == null) {
            return null;
        }
        
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setId(laboratorioDTO.getId());
        laboratorio.setNombre(laboratorioDTO.getNombre());
        laboratorio.setHoraInicio(laboratorioDTO.getHoraInicio());
        laboratorio.setHoraFin(laboratorioDTO.getHoraFin());
        laboratorio.setContraseña(laboratorioDTO.getContraseña());
        
        // Asignación de Instituto desde DTO
        Instituto instituto = new Instituto();
        instituto.setId(laboratorioDTO.getInstituto().getId());
        laboratorio.setInstituto(instituto);
        
        return laboratorio;
    }

    // Conversión de Estudiante a EstudianteDTO
    public static EstudianteDTO convertirEstudianteAEstudianteDTO(Estudiante estudiante) {
        if (estudiante == null) {
            return null;
        }

        // Convertir la lista de Bloqueos a BloqueoDTO
        List<BloqueoDTO> bloqueosDTO = new ArrayList<>();
        if (estudiante.getBloqueos() != null) {
            for (Bloqueo bloqueo : estudiante.getBloqueos()) {
                bloqueosDTO.add(convertirBloqueoABloqueoDTO(bloqueo));
            }
        }

        // Convertir la lista de Reservas a ReservaDTO
        List<ReservaDTO> reservasDTO = new ArrayList<>();
        if (estudiante.getReservas() != null) {
            for (Reserva reserva : estudiante.getReservas()) {
                reservasDTO.add(convertirReservaAReservaDTO(reserva));
            }
        }

        // Crear y retornar el EstudianteDTO
        EstudianteDTO estudianteDTO = new EstudianteDTO(
                estudiante.getIdEstudiante(),
                estudiante.getNombre(),
                estudiante.getApellidoPaterno(),
                estudiante.getApellidoMaterno(),
                estudiante.getEstado(),
                estudiante.getContraseña(),
                convertirCarreraACarreraDTO(estudiante.getCarrera()), // Convierte Carrera a DTO
                bloqueosDTO,
                reservasDTO
        );

        return estudianteDTO;
    }

    // Conversión de EstudianteDTO a Estudiante
    public static Estudiante convertirEstudianteDTOAEstudiante(EstudianteDTO estudianteDTO) {
        if (estudianteDTO == null) {
            return null;
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setId(estudianteDTO.getId());
        estudiante.setIdEstudiante(estudianteDTO.getIdEstudiante());
        estudiante.setNombre(estudianteDTO.getNombre());
        estudiante.setApellidoPaterno(estudianteDTO.getApellidoPaterno());
        estudiante.setApellidoMaterno(estudianteDTO.getApellidoMaterno());
        estudiante.setEstado(estudianteDTO.getEstado());
        estudiante.setContraseña(estudianteDTO.getContraseña());
        
        // Asignación de Carrera desde DTO
        Carrera carrera = new Carrera();
        carrera.setId(estudianteDTO.getCarrera().getId());
        estudiante.setCarrera(carrera);

        return estudiante;
    }

    // Conversión de Reserva a ReservaDTO
    public static ReservaDTO convertirReservaAReservaDTO(Reserva reserva) {
        if (reserva == null) {
            return null;
        }

        ReservaDTO reservaDTO = new ReservaDTO(
                reserva.getId(),
                reserva.getFecha(),
                reserva.getHoraInicio(),
                reserva.getHoraFin(),
                convertirComputadoraAComputadoraDTO(reserva.getComputadora()),
                convertirEstudianteAEstudianteDTO(reserva.getEstudiante()) // Convierte Estudiante a DTO
        );
        return reservaDTO;
    }

    // Conversión de ReservaDTO a Reserva
    public static Reserva convertirReservaDTOAReserva(ReservaDTO reservaDTO) {
        if (reservaDTO == null) {
            return null;
        }

        Reserva reserva = new Reserva();
        reserva.setId(reservaDTO.getId());
        reserva.setFecha(reservaDTO.getFecha());
        reserva.setHoraInicio(reservaDTO.getHoraInicio());
        reserva.setHoraFin(reservaDTO.getHoraFin());

        // Asignación de Computadora desde DTO
        Computadora computadora = new Computadora();
        computadora.setId(reservaDTO.getComputadora().getId());
        reserva.setComputadora(computadora);

        // Asignación de Estudiante desde DTO
        Estudiante estudiante = new Estudiante();
        estudiante.setId(reservaDTO.getEstudiante().getId());
        reserva.setEstudiante(estudiante);

        return reserva;
    }

    // Conversión de Software a SoftwareDTO
    public static SoftwareDTO convertirSoftwareASoftwareDTO(Software software) {
        if (software == null) {
            return null;
        }

        // Convertir la lista de Computadoras a ComputadoraDTO
        List<ComputadoraDTO> computadorasDTO = new ArrayList<>();
        if (software.getComputadoras() != null) {
            for (Computadora computadora : software.getComputadoras()) {
                computadorasDTO.add(convertirComputadoraAComputadoraDTO(computadora));
            }
        }

        // Crear y retornar el SoftwareDTO
        SoftwareDTO softwareDTO = new SoftwareDTO(
                software.getId(),
                software.getNombre(),
                software.getVersion(),
                computadorasDTO // Asigna la lista de computadoras convertidas
        );

        return softwareDTO;
    }

    // Conversión de SoftwareDTO a Software
    public static Software convertirSoftwareDTOASoftware(SoftwareDTO softwareDTO) {
        if (softwareDTO == null) {
            return null;
        }

        Software software = new Software();
        software.setId(softwareDTO.getId());
        software.setNombre(softwareDTO.getNombre());
        software.setVersion(softwareDTO.getVersion());

        return software;
    }

    // Conversión de HorarioEspecial a HorarioEspecialDTO
    public static HorarioEspecialDTO convertirHorarioEspecialAHorarioEspecialDTO(HorarioEspecial horarioEspecial) {
        if (horarioEspecial == null) {
            return null;
        }

        HorarioEspecialDTO horarioEspecialDTO = new HorarioEspecialDTO(
                horarioEspecial.getId(),
                horarioEspecial.getFecha(),
                horarioEspecial.getHoraInicio(),
                horarioEspecial.getHoraFin(),
                convertirLaboratorioALaboratorioDTO(horarioEspecial.getLaboratorio()) // Convierte Laboratorio a DTO
        );
        return horarioEspecialDTO;
    }

    // Conversión de HorarioEspecialDTO a HorarioEspecial
    public static HorarioEspecial convertirHorarioEspecialDTOAHorarioEspecial(HorarioEspecialDTO horarioEspecialDTO) {
        if (horarioEspecialDTO == null) {
            return null;
        }

        HorarioEspecial horarioEspecial = new HorarioEspecial();
        horarioEspecial.setId(horarioEspecialDTO.getId());
        horarioEspecial.setFecha(horarioEspecialDTO.getFecha());
        horarioEspecial.setHoraInicio(horarioEspecialDTO.getHoraInicio());
        horarioEspecial.setHoraFin(horarioEspecialDTO.getHoraFin());

        // Asignación de Laboratorio desde DTO
        Laboratorio laboratorio = new Laboratorio();
        laboratorio.setId(horarioEspecialDTO.getLaboratorio().getId());
        horarioEspecial.setLaboratorio(laboratorio);

        return horarioEspecial;
    }
    
    
    // Conversión de Instituto a InstitutoDTO
    public static InstitutoDTO convertirInstitutoAInstitutoDTO(Instituto instituto) {
        if (instituto == null) {
            return null;
        }

        // Convertir lista de Laboratorio a LaboratorioDTO
        List<LaboratorioDTO> laboratoriosDTO = new ArrayList<>();
        if (instituto.getLaboratorios() != null) {
            for (Laboratorio laboratorio : instituto.getLaboratorios()) {
                laboratoriosDTO.add(convertirLaboratorioALaboratorioDTO(laboratorio));
            }
        }

        // Crear y retornar el InstitutoDTO completo
        InstitutoDTO institutoDTO = new InstitutoDTO(
                instituto.getId(),
                instituto.getNombre(),
                instituto.getSiglas(),
                laboratoriosDTO
        );

        return institutoDTO;
    }

    // Conversión de InstitutoDTO a Instituto
    public static Instituto convertirInstitutoDTOAInstituto(InstitutoDTO institutoDTO) {
        if (institutoDTO == null) {
            return null;
        }

        Instituto instituto = new Instituto();
        instituto.setId(institutoDTO.getId());
        instituto.setNombre(institutoDTO.getNombre());

        return instituto;
    }

    // Conversión de Bloqueo a BloqueoDTO
    public static BloqueoDTO convertirBloqueoABloqueoDTO(Bloqueo bloqueo) {
        if (bloqueo == null) {
            return null;
        }

        BloqueoDTO bloqueoDTO = new BloqueoDTO(
                bloqueo.getId(),
                bloqueo.getFechaHoraBloqueo(),      // antes: getFechaInicio()
                bloqueo.getFechaHoraDesbloqueo(),   // antes: getFechaFin()
                bloqueo.getMotivo(),
                convertirEstudianteAEstudianteDTO(bloqueo.getEstudiante())
        );
        return bloqueoDTO;
    }

    // Conversión de BloqueoDTO a Bloqueo
    public static Bloqueo convertirBloqueoDTOABloqueo(BloqueoDTO bloqueoDTO) {
        if (bloqueoDTO == null) {
            return null;
        }

        Estudiante estudiante = new Estudiante();
        estudiante.setId(bloqueoDTO.getEstudiante().getId());

        Bloqueo bloqueo = new Bloqueo(
                bloqueoDTO.getId(),
                bloqueoDTO.getFechaHoraBloqueo(),
                bloqueoDTO.getFechaHoraDesbloqueo(),
                bloqueoDTO.getMotivo(),
                estudiante
        );

        return bloqueo;
    }

    // Conversión de Carrera a CarreraDTO
    public static CarreraDTO convertirCarreraACarreraDTO(Carrera carrera) {
        if (carrera == null) {
            return null;
        }

        List<EstudianteDTO> estudiantesDTO = new ArrayList<>();
        if (carrera.getEstudiantes() != null) {
            for (Estudiante estudiante : carrera.getEstudiantes()) {
                estudiantesDTO.add(convertirEstudianteAEstudianteDTO(estudiante));
            }
        }

        CarreraDTO carreraDTO = new CarreraDTO(
                carrera.getId(),
                carrera.getNombre(),
                carrera.getTiempoDiario(),
                estudiantesDTO
        );

        return carreraDTO;
    }

    // Conversión de CarreraDTO a Carrera
    public static Carrera convertirCarreraDTOACarrera(CarreraDTO carreraDTO) {
        if (carreraDTO == null) {
            return null;
        }

        Carrera carrera = new Carrera();
        carrera.setId(carreraDTO.getId());
        carrera.setNombre(carreraDTO.getNombre());

        return carrera;
    }
    
    
    
    
    
    
    
    //pruebas
    public static Computadora computadoraDTOEnEntidad(AgregarComputadoraDTO computadoraDTO, Laboratorio lab) {
        if (computadoraDTO == null) {
            return null;
        }
        
        Computadora computadora = new Computadora();
        computadora.setNumero(computadoraDTO.getNumero());
        computadora.setEstado(computadoraDTO.isEstado());
        computadora.setDireccionIp(computadoraDTO.getDireccionIp());
        computadora.setLaboratorio(lab);

        return computadora;
    }
    
    public static Software softwareDTOEnEntidad(AgregarSoftwareDTO softwareDTO){
        if(softwareDTO == null){
            return null;
        }
        Software software = new Software(softwareDTO.getNombre(), softwareDTO.getVersion(), new ArrayList<>());
        return software;
    }
    
    public static Bloqueo bloqueoDTOEnEntidad(AgregarBloqueoDTO bloqueoDTO, Estudiante estudiante){
        if(bloqueoDTO == null){
            return null;
        }
        Bloqueo bloqueo = new Bloqueo(bloqueoDTO.getFechaHoraBloqueo(), null, bloqueoDTO.getMotivo(), estudiante);
        return bloqueo;
    }
    
    public static HorarioEspecial horarioEspecialDTOEnEntidad(AgregarHorarioEspecialDTO horarioEspecialDTO, Laboratorio lab){
        if(horarioEspecialDTO == null || lab == null){
            return null;
        }
        HorarioEspecial horario = new HorarioEspecial(horarioEspecialDTO.getFecha(), horarioEspecialDTO.getHoraInicio(), horarioEspecialDTO.getHoraFin(), lab);
        return horario;
    }
    
    public static ConsultarEstudianteDTO entidadEnConsultarEstudianteDTO(Estudiante estudiante){
        ConsultarEstudianteDTO e = new ConsultarEstudianteDTO(
                estudiante.getId(), 
                estudiante.getIdEstudiante(),
                estudiante.getNombre(),
                estudiante.getApellidoPaterno(),
                estudiante.getApellidoMaterno(), 
                estudiante.getContraseña()
        );
        return e;
    }
    
    public static Estudiante AgregarEstudianteDtoAEntidad(AgregarEstudianteDTO estudianteDTO, Carrera carrera){
        Estudiante e = new Estudiante(
                estudianteDTO.getIdEstudiante(),
                estudianteDTO.getNombre(), 
                estudianteDTO.getApellidoPaterno(), 
                estudianteDTO.getApellidoMaterno(),
                "Activo",
                estudianteDTO.getContraseña(), 
                carrera, 
                new ArrayList<>(), 
                new ArrayList<>());
        return e;
    }
    public static Laboratorio AgregarLaboratorioDtoAEntidad(AgregarLaboratorioDTO laboratorioDTO, Instituto instituto){
        Laboratorio l = new Laboratorio(
                laboratorioDTO.getNombre(),
                laboratorioDTO.getHoraInicio(),
                laboratorioDTO.getHoraFin(),
                laboratorioDTO.getContraseña(),
                instituto,
                new ArrayList<>(),
                new ArrayList<>()
        );
        return l;
    }
}