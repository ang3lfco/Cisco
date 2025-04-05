/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author ReneEzequiel23
 */
@Entity
@Table(name = "institutos")
public class Instituto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name="nombre", length = 50, nullable = false)
    private String nombre;
    
    @Column(name="siglas", length = 12, nullable = false)
    private String siglas;

    @OneToMany(mappedBy = "instituto", cascade = CascadeType.PERSIST)
    private List<Laboratorio> laboratorios;
    
    public Instituto() {
    }

    public Instituto(String nombre, String siglas, List<Laboratorio> laboratorios) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.laboratorios = laboratorios;
    }

    public Instituto(String nombre, String siglas) {
        this.nombre = nombre;
        this.siglas = siglas;
    }

    public Instituto(Long id, String nombre, String siglas, List<Laboratorio> laboratorios) {
        this.id = id;
        this.nombre = nombre;
        this.siglas = siglas;
        this.laboratorios = laboratorios;
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

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public List<Laboratorio> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<Laboratorio> laboratorios) {
        this.laboratorios = laboratorios;
    }
    
    @Override
    public String toString() {
        return "Instituto{" + "id=" + id + ", nombre=" + nombre + ", siglas=" + siglas + ", laboratorios=" + laboratorios + '}';
    }
}
