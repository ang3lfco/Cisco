/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
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
@Table(name = "laboratorios")
public class Laboratorio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "nombre", length = 30, nullable = false)
    private String nombre;
    
    @Column(name = "horaInicio", nullable = false)
    private LocalTime horaInicio;
    
    @Column(name = "horaFin", nullable = false)
    private LocalTime horaFin;
    
    @Column(name = "contraseña",length = 60, nullable = false)
    private String contraseña;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "idInstituto", nullable=false)
    private Instituto instituto;
    
    @OneToMany(mappedBy = "laboratorio", cascade = CascadeType.PERSIST)
    private List<Computadora> computadoras;
    
    @OneToMany(mappedBy = "laboratorio")
    private List<HorarioEspecial> horariosEspeciales;
    
    public Laboratorio() {
    }

    public Laboratorio(String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, Instituto instituto, List<Computadora> computadoras, List<HorarioEspecial> horariosEspeciales) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.instituto = instituto;
        this.computadoras = computadoras;
        this.horariosEspeciales = horariosEspeciales;
    }

    public Laboratorio(Long id, String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, Instituto instituto, List<Computadora> computadoras, List<HorarioEspecial> horariosEspeciales) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.instituto = instituto;
        this.computadoras = computadoras;
        this.horariosEspeciales = horariosEspeciales;
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

    public Instituto getInstituto() {
        return instituto;
    }

    public void setInstituto(Instituto instituto) {
        this.instituto = instituto;
    }

    public List<Computadora> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<Computadora> computadoras) {
        this.computadoras = computadoras;
    }

    public List<HorarioEspecial> getHorariosEspeciales() {
        return horariosEspeciales;
    }

    public void setHorariosEspeciales(List<HorarioEspecial> horariosEspeciales) {
        this.horariosEspeciales = horariosEspeciales;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", contrase\u00f1a=" + contraseña + ", instituto=" + instituto + ", computadoras=" + computadoras + ", horariosEspeciales=" + horariosEspeciales + '}';
    }
}
