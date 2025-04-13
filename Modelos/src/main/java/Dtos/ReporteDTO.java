/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author ReneEzequiel23
 */
public class ReporteDTO {
    private String laboratorio;
    private LocalDate fecha;
    private int tiempoDeServicio;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private int tiempoSinUso;
    private int tiempoDeUso;

    public ReporteDTO(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public ReporteDTO(String laboratorio, LocalDate fecha, int tiempoDeServicio, int tiempoSinUso, int tiempoDeUso) {
        this.laboratorio = laboratorio;
        this.fecha = fecha;
        this.tiempoDeServicio = tiempoDeServicio;
        this.tiempoSinUso = tiempoSinUso;
        this.tiempoDeUso = tiempoDeUso;
    }

    public ReporteDTO(String laboratorio, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, int tiempoSinUso, int tiempoDeUso) {
        this.laboratorio = laboratorio;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tiempoSinUso = tiempoSinUso;
        this.tiempoDeUso = tiempoDeUso;
    }

    public ReporteDTO(String laboratorio, LocalDate fecha, int tiempoSinUso, int tiempoDeUso) {
        this.laboratorio = laboratorio;
        this.fecha = fecha;
        this.tiempoSinUso = tiempoSinUso;
        this.tiempoDeUso = tiempoDeUso;
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

    
    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getTiempoDeServicio() {
        return tiempoDeServicio;
    }

    public void setTiempoDeServicio(int tiempoDeServicio) {
        this.tiempoDeServicio = tiempoDeServicio;
    }

    public int getTiempoSinUso() {
        return tiempoSinUso;
    }

    public void setTiempoSinUso(int tiempoSinUso) {
        this.tiempoSinUso = tiempoSinUso;
    }

    public int getTiempoDeUso() {
        return tiempoDeUso;
    }

    public void setTiempoDeUso(int tiempoDeUso) {
        this.tiempoDeUso = tiempoDeUso;
    }

    @Override
    public String toString() {
        return "ReporteDTO{" + "laboratorio=" + laboratorio + ", fecha=" + fecha + ", tiempoDeServicio=" + tiempoDeServicio + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin + ", tiempoSinUso=" + tiempoSinUso + ", tiempoDeUso=" + tiempoDeUso + '}';
    }

    
    
}
