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
public class InstitutoDTO {
    private Long id;
    private String nombre;
    private String siglas;
    private List<LaboratorioDTO> laboratorios;

    public InstitutoDTO() {
    }

    public InstitutoDTO(String nombre, String siglas, List<LaboratorioDTO> laboratorios) {
        this.nombre = nombre;
        this.siglas = siglas;
        this.laboratorios = laboratorios;
    }
    
    

    public InstitutoDTO(Long id, String nombre, String siglas, List<LaboratorioDTO> laboratorios) {
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

    public List<LaboratorioDTO> getLaboratorios() {
        return laboratorios;
    }

    public void setLaboratorios(List<LaboratorioDTO> laboratorios) {
        this.laboratorios = laboratorios;
    }
}