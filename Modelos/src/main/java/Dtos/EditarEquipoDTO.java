/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

/**
 *
 * @author ReneEzequiel23
 */
public class EditarEquipoDTO {
    private String idEstudiante;
    private int numero;
    private String direccionIp;
    private String tipo;
    private String laboratorio;

    public EditarEquipoDTO() {
    }

    
    public EditarEquipoDTO(int numero, String direccionIp, String tipo, String laboratorio) {
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
    }

    public EditarEquipoDTO(String idEstudiante, int numero, String direccionIp, String tipo, String laboratorio) {
        this.idEstudiante = idEstudiante;
        this.numero = numero;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDireccionIp() {
        return direccionIp;
    }

    public void setDireccionIp(String direccionIp) {
        this.direccionIp = direccionIp;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }
    
    
}
