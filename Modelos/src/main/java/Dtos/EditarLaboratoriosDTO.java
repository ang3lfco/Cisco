/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalTime;

/**
 *
 * @author ReneEzequiel23
 */
public class EditarLaboratoriosDTO {
    private String nombre;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String contraseña;
    private String instituto;

    public EditarLaboratoriosDTO() {
    }

    public EditarLaboratoriosDTO(String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, String instituto) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.instituto = instituto;
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

    public String getInstituto() {
        return instituto;
    }

    public void setInstituto(String instituto) {
        this.instituto = instituto;
    }

    
    
}
