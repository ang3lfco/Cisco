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
public class AgregarComputadoraDTO {
    private int numero;
    private boolean estado;
    private String direccionIp;
    private String laboratorio;

    public AgregarComputadoraDTO(int numero, boolean estado, String direccionIp, String laboratorio) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
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

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
}
