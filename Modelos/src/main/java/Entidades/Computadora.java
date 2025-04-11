    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
    
    @Column(name="direccionIp", length=20, nullable=false)
    private String direccionIp;
    
    @Column(name="tipo", length=20, nullable=false)
    private String tipo;
    
    @Column(name="etiqueta", length=20, nullable=true)
    private String etiqueta;

    @ManyToOne
    @JoinColumn(name = "idLaboratorio", nullable=false)
    private Laboratorio laboratorio;
    
    @OneToMany(mappedBy = "computadora")
    private List<Reserva> reservas;
    
    
    @ManyToMany
    @JoinTable(
        name = "instalaciones",
        joinColumns = @JoinColumn(name = "idComputadora"),
        inverseJoinColumns = @JoinColumn(name = "idSoftware")
    )
    private List<Software> softwares;
        
    public Computadora() {
    }   

    public Computadora(int numero, boolean estado, String direccionIp, Laboratorio laboratorio) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
    }

    public Computadora(Long id, int numero, boolean estado, String direccionIp, Laboratorio laboratorio) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
    }

    public Computadora(int numero, boolean estado, String direccionIp, Laboratorio laboratorio, List<Reserva> reservas, List<Software> softwares) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.softwares = softwares;
    }

    public Computadora(int numero, boolean estado, String direccionIp, String tipo, Laboratorio laboratorio, List<Reserva> reservas, List<Software> softwares) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.softwares = softwares;
    }

    public Computadora(Long id, int numero, boolean estado, String direccionIp, String tipo, Laboratorio laboratorio, List<Reserva> reservas, List<Software> softwares) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.softwares = softwares;
    }

    public Computadora(Long id, int numero, boolean estado, String direccionIp, String tipo, Laboratorio laboratorio) {
        this.id = id;
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.laboratorio = laboratorio;
    }

    public Computadora(int numero, boolean estado, String direccionIp, String tipo, String etiqueta, Laboratorio laboratorio, List<Reserva> reservas, List<Software> softwares) {
        this.numero = numero;
        this.estado = estado;
        this.direccionIp = direccionIp;
        this.tipo = tipo;
        this.etiqueta = etiqueta;
        this.laboratorio = laboratorio;
        this.reservas = reservas;
        this.softwares = softwares;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
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

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(Laboratorio laboratorio) {
        this.laboratorio = laboratorio;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    public List<Software> getSoftwares() {
        return softwares;
    }

    public void setSoftwares(List<Software> softwares) {
        this.softwares = softwares;
    }

    @Override
    public String toString() {
        return "Computadora{" + "id=" + id + ", numero=" + numero + ", estado=" + estado + ", direccionIp=" + direccionIp + ", laboratorio=" + laboratorio + '}';
    }
}
