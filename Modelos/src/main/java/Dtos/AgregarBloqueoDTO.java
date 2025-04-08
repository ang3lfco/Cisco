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
public class AgregarBloqueoDTO {
    private LocalDateTime fechaHoraBloqueo;
    private String motivo;
    private String idEstudiante;
    
    public AgregarBloqueoDTO(LocalDateTime fechaHoraBloqueo, String motivo, String idEstudiante){
        this.fechaHoraBloqueo = fechaHoraBloqueo;
        this.motivo = motivo;
        this.idEstudiante = idEstudiante;
    }

    public LocalDateTime getFechaHoraBloqueo() {
        return fechaHoraBloqueo;
    }

    public void setFechaHoraBloqueo(LocalDateTime fechaHoraBloqueo) {
        this.fechaHoraBloqueo = fechaHoraBloqueo;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }
}
