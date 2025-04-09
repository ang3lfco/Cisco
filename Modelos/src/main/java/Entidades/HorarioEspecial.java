/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ReneEzequiel23
 */
@Entity
@Table(name = "horariosEspeciales")
public class HorarioEspecial implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="fecha", nullable=false)
    private LocalDate fecha;

    @Column(name="horaInicio", nullable=false)
    private LocalTime horaInicio;
    
    @Column(name="horaFin", nullable=false)
    private LocalTime horaFin;

    @ManyToOne
    @JoinColumn(name = "idLaboratorio", nullable=false)
    private Laboratorio laboratorio;
    
    @OneToMany(mappedBy = "horarioEspecial", cascade = CascadeType.PERSIST)
    private List<Reserva> reserva;
    
    public HorarioEspecial() {
    }

    public HorarioEspecial(LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Laboratorio laboratorio) {
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.laboratorio = laboratorio;
    }

    public HorarioEspecial(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Laboratorio laboratorio) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.laboratorio = laboratorio;
    }

    public HorarioEspecial(Long id, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, Laboratorio laboratorio, List<Reserva> reserva) {
        this.id = id;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.laboratorio = laboratorio;
        this.reserva = reserva;
    }

    public List<Reserva> getReserva() {
        return reserva;
    }

    public void setReserva(List<Reserva> reserva) {
        this.reserva = reserva;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    @Override
    public String toString() {
        return "HorarioEspecial{" + "id=" + id + ", fecha=" + fecha + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", laboratorio=" + laboratorio + '}';
    }
}
