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
public class CarreraDTO {
    private Long id;
    private String nombre;
    private int tiempoDiario;
    private List<EstudianteDTO> estudiantes;

    public CarreraDTO() {
    }

    public CarreraDTO(String nombre, int tiempoDiario, List<EstudianteDTO> estudiantes) {
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiantes = estudiantes;
    }

    public CarreraDTO(Long id, String nombre, int tiempoDiario, List<EstudianteDTO> estudiantes) {
        this.id = id;
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
        this.estudiantes = estudiantes;
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

    public int getTiempoDiario() {
        return tiempoDiario;
    }

    public void setTiempoDiario(int tiempoDiario) {
        this.tiempoDiario = tiempoDiario;
    }

    public List<EstudianteDTO> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(List<EstudianteDTO> estudiantes) {
        this.estudiantes = estudiantes;
    }
}