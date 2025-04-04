/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author ReneEzequiel23
 */
@Entity
@Table(name = "computadoras")
public class Computadora implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    
    @Column(name = "numero", nullable=false)
    private int numero;
    
    @Column(name="estado", nullable=false)
    private boolean estado;
    
    @Column(name="direccionIP", length=20, nullable=false)
    private String direccionIP;

    @ManyToOne
    @JoinColumn(name = "idLaboratorio", nullable=false)
    private Laboratorio laboratorio;
    
    public Computadora() {
    }

    public Computadora(int numero, boolean estado, String direccionIP) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIP = direccionIP;
    }

    public Computadora(Long id, int numero, boolean estado, String direccionIP) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIP = direccionIP;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
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

    public String getDireccionIP() {
        return direccionIP;
    }

    public void setDireccionIP(String direccionIP) {
        this.direccionIP = direccionIP;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Computadora{" + "id=" + id + ", numero=" + numero + ", estado=" + estado + ", direccionIP=" + direccionIP + '}';
    }

   
    
}
