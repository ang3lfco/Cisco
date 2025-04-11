/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalDateTime;

/**
 *
 * @author ang3lfco
 */
public class BloqueoDTO {
    private Long id;
    private LocalDateTime fechaHoraBloqueo;
    private LocalDateTime fechaHoraDesbloqueo;
    private String motivo;
    private EstudianteDTO estudiante;

    public BloqueoDTO() {
    }

    public BloqueoDTO(LocalDateTime fechaHoraBloqueo, LocalDateTime fechaHoraDesbloqueo, String motivo, EstudianteDTO estudiante) {
        this.fechaHoraBloqueo = fechaHoraBloqueo;
        this.fechaHoraDesbloqueo = fechaHoraDesbloqueo;
        this.motivo = motivo;
        this.estudiante = estudiante;
    }

    public BloqueoDTO(Long id, LocalDateTime fechaHoraBloqueo, LocalDateTime fechaHoraDesbloqueo, String motivo, EstudianteDTO estudiante) {
        this.id = id;
        this.fechaHoraBloqueo = fechaHoraBloqueo;
        this.fechaHoraDesbloqueo = fechaHoraDesbloqueo;
        this.motivo = motivo;
        this.estudiante = estudiante;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaHoraBloqueo() {
        return fechaHoraBloqueo;
    }

    public void setFechaHoraBloqueo(LocalDateTime fechaHoraBloqueo) {
        this.fechaHoraBloqueo = fechaHoraBloqueo;
    }

    public LocalDateTime getFechaHoraDesbloqueo() {
        return fechaHoraDesbloqueo;
    }

    public void setFechaHoraDesbloqueo(LocalDateTime fechaHoraDesbloqueo) {
        this.fechaHoraDesbloqueo = fechaHoraDesbloqueo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public EstudianteDTO getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(EstudianteDTO estudiante) {
        this.estudiante = estudiante;
    }
}