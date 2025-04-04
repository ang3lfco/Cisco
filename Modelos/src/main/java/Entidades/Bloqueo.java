/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ang3lfco
 */
@Entity
@Table(name = "bloqueos")
public class Bloqueo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "fechaHoraBloqueo")
    private LocalDateTime fechaHoraBloqueo;
    
    @Column(name = "fechaHoraDesbloqueo")
    private LocalDateTime fechaHoraDesbloqueo;
    
    @Column(name = "motivo", length = 300, nullable = false)
    private String motivo;
    
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;

    public Bloqueo() {
    }

    public Bloqueo(LocalDateTime fechaHoraBloqueo, LocalDateTime fechaHoraDesbloqueo, String motivo, Estudiante estudiante) {
        this.fechaHoraBloqueo = fechaHoraBloqueo;
        this.fechaHoraDesbloqueo = fechaHoraDesbloqueo;
        this.motivo = motivo;
        this.estudiante = estudiante;
    }
    
    public Bloqueo(Long id, LocalDateTime fechaHoraBloqueo, LocalDateTime fechaHoraDesbloqueo, String motivo, Estudiante estudiante) {
        this.id = id;
        this.fechaHoraBloqueo = fechaHoraBloqueo;
        this.fechaHoraDesbloqueo = fechaHoraDesbloqueo;
        this.motivo = motivo;
        this.estudiante = estudiante;
    }

    public Long getId() {
        return id;
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

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Bloqueo{" + "id=" + id + ", fechaHoraBloqueo=" + fechaHoraBloqueo + ", fechaHoraDesbloqueo=" + fechaHoraDesbloqueo + ", motivo=" + motivo + ", estudiante=" + estudiante + '}';
    }
}
