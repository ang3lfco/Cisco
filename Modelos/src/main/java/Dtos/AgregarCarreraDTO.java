/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

/**
 *
 * @author ReneEzequiel23
 */
public class AgregarCarreraDTO {
    private String nombre;
    private int tiempoDiario;

    public AgregarCarreraDTO() {
    }

    public AgregarCarreraDTO(String nombre, int tiempoDiario) {
        this.nombre = nombre;
        this.tiempoDiario = tiempoDiario;
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
    
    
}
