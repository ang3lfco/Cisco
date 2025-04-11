    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
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
@Table(name="reservaciones")
public class Reserva implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "horaInicio")
    private LocalTime horaInicio;
    
    @Column(name = "minutosSeleccionados")
    private int minutosSeleccionados;
    
    @Column(name = "horaFin")
    private LocalTime horaFin;
    
    
    @Column(name = "minutosUsados")
    private int minutosUsados;
    
    @ManyToOne
    @JoinColumn(name = "idComputadora")
    private Computadora computadora;
    
    @ManyToOne
    @JoinColumn(name = "idEstudiante")
    private Estudiante estudiante;
    
    @ManyToOne
    @JoinColumn(name = "idHorarioEspecial")
    private HorarioEspecial horarioEspecial;

    public Reserva() {
    }

    public Reserva(Long id, LocalTime horaInicio, int minutosSeleccionados, LocalTime horaFin, int minutosUsados, Computadora computadora, Estudiante estudiante, HorarioEspecial horarioEspecial) {
        this.id = id;
        this.horaInicio = horaInicio;
        this.minutosSeleccionados = minutosSeleccionados;
        this.horaFin = horaFin;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
        this.horarioEspecial = horarioEspecial;
    }

    public Reserva(LocalTime horaInicio, int minutosSeleccionados, LocalTime horaFin, int minutosUsados, Computadora computadora, Estudiante estudiante, HorarioEspecial horarioEspecial) {
        this.horaInicio = horaInicio;
        this.minutosSeleccionados = minutosSeleccionados;
        this.horaFin = horaFin;
        this.minutosUsados = minutosUsados;
        this.computadora = computadora;
        this.estudiante = estudiante;
        this.horarioEspecial = horarioEspecial;
    }

    public Reserva(LocalTime horaInicio, int minutosSeleccionados, LocalTime horaFin, int minutosUsados) {
        this.horaInicio = horaInicio;
        this.minutosSeleccionados = minutosSeleccionados;
        this.horaFin = horaFin;
        this.minutosUsados = minutosUsados;
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

    
    public HorarioEspecial getHorarioEspecial() {
        return horarioEspecial;
    }

    public void setHorarioEspecial(HorarioEspecial horarioEspecial) {
        this.horarioEspecial = horarioEspecial;
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

    public Computadora getComputadora() {
        return computadora;
    }

    public void setComputadora(Computadora computadora) {
        this.computadora = computadora;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Reserva{" + "id=" + id + ", horaInicio=" + horaInicio + ", minutosSeleccionados=" + minutosSeleccionados + ", horaFin=" + horaFin + ", minutosUsados=" + minutosUsados + ", computadora=" + computadora + ", estudiante=" + estudiante + ", horarioEspecial=" + horarioEspecial + '}';
    }
    
    
}
