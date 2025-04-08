/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class SoftwareDTO {
    private Long id;
    private String nombre;
    private String version;
    private List<ComputadoraDTO> computadoras;

    public SoftwareDTO() {
    }

    public SoftwareDTO(String nombre, String version, List<ComputadoraDTO> computadoras) {
        this.nombre = nombre;
        this.version = version;
        this.computadoras = computadoras;
    }

    public SoftwareDTO(Long id, String nombre, String version, List<ComputadoraDTO> computadoras) {
        this.id = id;
        this.nombre = nombre;
        this.version = version;
        this.computadoras = computadoras;
    }

    public SoftwareDTO(String nombre, String version) {
        this.nombre = nombre;
        this.version = version;
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

    public List<ComputadoraDTO> getComputadoras() {
        return computadoras;
    }

    public void setComputadoras(List<ComputadoraDTO> computadoras) {
        this.computadoras = computadoras;
    }
}