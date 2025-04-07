/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

import Entidades.Laboratorio;

/**
 *
 * @author ang3lfco
 */
public class ComputadoraDTO {
    private Long id;
    private int numero;
    private boolean estado;
    private String direccionIp;
    private Laboratorio laboratorio;

    public ComputadoraDTO() {
    }
    
    public ComputadoraDTO(int numero, boolean estado, String direccionIp, Laboratorio laboratorio) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
    }

    public ComputadoraDTO(Long id, int numero, boolean estado, String direccionIp, Laboratorio laboratorio) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }
}
