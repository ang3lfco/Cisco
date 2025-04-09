/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
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
 * @author ang3lfco
 */
@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="idEstudiante")
    private String idEstudiante;
    
    @Column(name="nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name="apellidoPaterno", length = 50, nullable = false)
    private String apellidoPaterno;
    
    @Column(name="apellidoMaterno", length = 50, nullable = true)
    private String apellidoMaterno;
    
    @Column(name="estado", nullable = false)
    private String estado;
    
    @Column(name="contraseña", length = 60, nullable = false)
    private String contraseña;
    
    @ManyToOne
    @JoinColumn(name = "idCarrera", nullable = false)
    private Carrera carrera;
    
    @OneToMany(mappedBy = "estudiante")
    private List<Bloqueo> bloqueos;
    
    @OneToMany(mappedBy = "estudiante")
    private List<Reserva> reservas;

    public Estudiante() {
    }

    public Estudiante(String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, Carrera carrera, List<Bloqueo> bloqueos, List<Reserva> reservas) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.bloqueos = bloqueos;
        this.reservas = reservas;
    }
    
    public Estudiante(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, Carrera carrera, List<Bloqueo> bloqueos, List<Reserva> reservas) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.bloqueos = bloqueos;
        this.reservas = reservas;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<Bloqueo> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<Bloqueo> bloqueos) {
        this.bloqueos = bloqueos;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id=" + id + ", idEstudiante=" + idEstudiante + ", nombre=" + nombre + ", apellidoPaterno=" + apellidoPaterno + ", apellidoMaterno=" + apellidoMaterno + ", estado=" + estado + ", contrase\u00f1a=" + contraseña + ", carrera=" + carrera + ", bloqueos=" + bloqueos + ", reservas=" + reservas + '}';
    }
}
