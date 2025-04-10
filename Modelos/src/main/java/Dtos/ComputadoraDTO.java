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
public class ComputadoraDTO {
    private Long id;
    private int numero;
    private boolean estado;
    private String direccionIp;
    private String tipo;
    private LaboratorioDTO laboratorio;
    private List<ReservaDTO> reservas;
    private List<SoftwareDTO> instalaciones;

    public ComputadoraDTO() {
    }

    public ComputadoraDTO(int numero, boolean estado, String direccionIp, LaboratorioDTO laboratorio, List<ReservaDTO> reservas, List<SoftwareDTO> instalaciones) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.instalaciones = instalaciones;
    }

    public ComputadoraDTO(Long id, int numero, boolean estado, String direccionIp, LaboratorioDTO laboratorio, List<ReservaDTO> reservas, List<SoftwareDTO> instalaciones) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.instalaciones = instalaciones;
    }

    public ComputadoraDTO(Long id, int numero, boolean estado, String direccionIp) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
    }

    public ComputadoraDTO(Long id, int numero, boolean estado, String direccionIp, LaboratorioDTO laboratorio) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
    }

    public ComputadoraDTO(Long id, int numero, boolean estado, String direccionIp, String tipo, LaboratorioDTO laboratorio) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public LaboratorioDTO getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(LaboratorioDTO laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }

    public List<SoftwareDTO> getInstalaciones() {
        return instalaciones;
    }

    public void setInstalaciones(List<SoftwareDTO> instalaciones) {
        this.instalaciones = instalaciones;
    }
}