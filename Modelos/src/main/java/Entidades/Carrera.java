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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ang3lfco
 */
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre", length = 200, nullable = false)
    private String nombre;
    
    @Column(name = "tiempoDiario", nullable = false)
    private int tiempoDiario;
    
    @OneToMany(mappedBy = "carrera")
    private List<Estudiante> estudiantes;

    public Carrera() {
    }

    public Carrera(String nombre, int tiempoDiario, List<Estudiante> estudiantes) {
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiantes = estudiantes;
    }

    public Carrera(Long id, String nombre, int tiempoDiario, List<Estudiante> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiantes = estudiantes;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTiempoDiario() {
        return tiempoDiario;
    }

    public void setTiempoDiario(int tiempoDiario) {
        this.tiempoDiario = tiempoDiario;
    }

    public List<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public String toString() {
        return "Carrera{" + "id=" + id + ", nombre=" + nombre + ", tiempoDiario=" + tiempoDiario + ", estudiantes=" + estudiantes + '}';
    }
}
