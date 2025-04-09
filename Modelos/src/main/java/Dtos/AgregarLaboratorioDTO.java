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
public class AgregarLaboratorioDTO {
    public String nombre;
    public LocalTime horaInicio;
    public LocalTime horaFin;
    public String contraseña;
    public Long idInstituto;

    public AgregarLaboratorioDTO(String nombre, LocalTime horaInicio, LocalTime horaFin, String contraseña, Long idInstituto) {
        this.nombre = nombre;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.contraseña = contraseña;
        this.idInstituto = idInstituto;
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

    public Long getIdInstituto() {
        return idInstituto;
    }

    public void setIdInstituto(Long idInstituto) {
        this.idInstituto = idInstituto;
    }
    
    
}
