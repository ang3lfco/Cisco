/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import Entidades.HorarioEspecial;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ang3lfco
 */
public class ReservaDTO {
    private Long id;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int minutosSeleccionados;
    private int minutosUsados;
    private ComputadoraDTO computadora;
    private EstudianteDTO estudiante;
    private HorarioEspecial horario;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalTime horaInicio, LocalTime horaFin, int minutosSeleccionados, int minutosUsados, ComputadoraDTO computadora, EstudianteDTO estudiante) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minutosSeleccionados = minutosSeleccionados;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
    }

    public ReservaDTO(Long id, LocalTime horaInicio, LocalTime horaFin, int minutosSeleccionados, int minutosUsados, ComputadoraDTO computadora, EstudianteDTO estudiante, HorarioEspecial horario) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minutosSeleccionados = minutosSeleccionados;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
        this.horario = horario;
    }

    public ReservaDTO(Long id, LocalTime horaInicio, LocalTime horaFin, int minutosSeleccionados, int minutosUsados, ComputadoraDTO computadora, EstudianteDTO estudiante) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minutosSeleccionados = minutosSeleccionados;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
    }

    public ReservaDTO(LocalTime horaInicio, LocalTime horaFin, int minutosSeleccionados, int minutosUsados, ComputadoraDTO computadora, EstudianteDTO estudiante, HorarioEspecial horario) {
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.minutosSeleccionados = minutosSeleccionados;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
        this.horario = horario;
    }

    
    public int getMinutosSeleccionados() {
        return minutosSeleccionados;
    }

    public void setMinutosSeleccionados(int minutosSeleccionados) {
        this.minutosSeleccionados = minutosSeleccionados;
    }

    public int getMinutosUsados() {
        return minutosUsados;
    }

    public void setMinutosUsados(int minutosUsados) {
        this.minutosUsados = minutosUsados;
    }

    
    public HorarioEspecial getHorario() {
        return horario;
    }

    public void setHorario(HorarioEspecial horario) {
        this.horario = horario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public ComputadoraDTO getComputadora() {
        return computadora;
    }

    public void setComputadora(ComputadoraDTO computadora) {
        this.computadora = computadora;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }
}