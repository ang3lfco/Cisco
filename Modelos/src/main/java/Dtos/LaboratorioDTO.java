/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class LaboratorioDTO {
    private Long id;
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String contraseña;
    private InstitutoDTO instituto;
    private List<ComputadoraDTO> computadoras;
    private List<HorarioEspecialDTO> horariosEspeciales;

    public LaboratorioDTO() {
    }

    public LaboratorioDTO(String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, InstitutoDTO instituto, List<ComputadoraDTO> computadoras, List<HorarioEspecialDTO> horariosEspeciales) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.instituto = instituto;
        this.computadoras = computadoras;
        this.horariosEspeciales = horariosEspeciales;
    }

    public LaboratorioDTO(Long id, String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, InstitutoDTO instituto, List<ComputadoraDTO> computadoras, List<HorarioEspecialDTO> horariosEspeciales) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.instituto = instituto;
        this.computadoras = computadoras;
        this.horariosEspeciales = horariosEspeciales;
    }

    
    public LaboratorioDTO(Long id) {
        this.id = id;
    }

    public LaboratorioDTO(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public LaboratorioDTO(Long id, String nombre, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public InstitutoDTO getInstituto() {
        return instituto;
    }

    public void setInstituto(InstitutoDTO instituto) {
        this.instituto = instituto;
    }

    public List<ComputadoraDTO> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraDTO> computadoras) {
        this.computadoras = computadoras;
    }

    public List<HorarioEspecialDTO> getHorariosEspeciales() {
        return horariosEspeciales;
    }

    public void setHorariosEspeciales(List<HorarioEspecialDTO> horariosEspeciales) {
        this.horariosEspeciales = horariosEspeciales;
    }
}