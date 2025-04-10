/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalTime;

/**
 *
 * @author ang3lfco
 */
public class CargaLaboratorioDTO {
    public String nombre;
    public LocalTime horaInicio;
    public LocalTime horaFin;
    public String contraseña;
    public InstitutoDTO instituto;

    public CargaLaboratorioDTO(String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, InstitutoDTO instituto) {
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

    public InstitutoDTO getInstituto() {
        return instituto;
    }

    public void setInstituto(InstitutoDTO instituto) {
        this.instituto = instituto;
    }
    
    
}
