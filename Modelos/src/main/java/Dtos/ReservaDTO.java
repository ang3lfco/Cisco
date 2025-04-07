/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ang3lfco
 */
public class ReservaDTO {
    private Long id;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private ComputadoraDTO computadora;
    private EstudianteDTO estudiante;

    public ReservaDTO() {
    }

    public ReservaDTO(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, ComputadoraDTO computadora, EstudianteDTO estudiante) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.computadora = computadora;
        this.estudiante = estudiante;
    }

    public ReservaDTO(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, ComputadoraDTO computadora, EstudianteDTO estudiante) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.computadora = computadora;
        this.estudiante = estudiante;
    }

    public ReservaDTO(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
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