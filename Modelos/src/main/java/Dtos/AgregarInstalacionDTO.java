/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

/**
 *
 * @author ang3lfco
 */
public class AgregarInstalacionDTO {
    private int numeroComputadora;
    private String nombreSoftware;

    public AgregarInstalacionDTO(int numeroComputadora, String nombreSoftware) {
        this.numeroComputadora = numeroComputadora;
        this.nombreSoftware = nombreSoftware;
    }

    public int getNumeroComputadora() {
        return numeroComputadora;
    }

    public void setNumeroComputadora(int numeroComputadora) {
        this.numeroComputadora = numeroComputadora;
    }

    public String getNombreSoftware() {
        return nombreSoftware;
    }

    public void setNombreSoftware(String nombreSoftware) {
        this.nombreSoftware = nombreSoftware;
    }
    
}
