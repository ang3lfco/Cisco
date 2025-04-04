/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.sql.Time;
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
import javax.persistence.Temporal;

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
    private Time horaInicio;
    
    @Column(name = "horaFin", nullable = false)
    private Time horaFin;
    
    @Column(name = "contraseña",length = 50, nullable = false)
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "idInstituto", nullable=false)
    private Instituto instituto;
    
    @OneToMany(mappedBy = "laboratorio")
    private List<Computadora> comptadoras;
    
    @OneToMany(mappedBy = "laboratorio")
    private List<HorarioEspecial> horarioEspecial;
    
    public Laboratorio() {
    }

    public Laboratorio(String nombre, Time horaInicio, Time horaFin, String contraseña) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
    }

    public Laboratorio(Long id, String nombre, Time horaInicio, Time horaFin, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Time horaFin) {
        this.horaFin = horaFin;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Laboratorio{" + "id=" + id + ", nombre=" + nombre + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", contrase\u00f1a=" + contraseña + '}';
    }
    
      
}
