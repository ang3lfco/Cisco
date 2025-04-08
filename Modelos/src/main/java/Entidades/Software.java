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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author ang3lfco
 */
@Entity
@Table(name = "softwares")
public class Software implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    
    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;
    
    @Column(name = "version", length = 10, nullable = true)
    private String version;
    
    @ManyToMany(mappedBy = "softwares")
    private List<Computadora> computadoras;

    public Software() {
    }

    public Software(String nombre, String version, List<Computadora> computadoras) {
        this.nombre = nombre;
        this.version = version;
        this.computadoras = computadoras;
    }
    
    public Software(Long id, String nombre, String version, List<Computadora> computadoras) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
        this.computadoras = computadoras;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<Computadora> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<Computadora> computadoras) {
        this.computadoras = computadoras;
    }

    @Override
    public String toString() {
        return "Software{" + "id=" + id + ", nombre=" + nombre + ", version=" + version + ", computadoras=" + computadoras + '}';
    }
}
