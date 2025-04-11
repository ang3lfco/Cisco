/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dtos;

/**
 *
 * @author ReneEzequiel23
 */
public class EstudianteIngresaDTO {
    private Long id;
    private String idEstudiante;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String estado;
    private String contraseña;
    private String carrera;
    private int tiempoDiario;

    public EstudianteIngresaDTO() {
    }

    public EstudianteIngresaDTO(String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public EstudianteIngresaDTO(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
    }

    public EstudianteIngresaDTO(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, int tiempoDiario) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.tiempoDiario = tiempoDiario;
    }

    public EstudianteIngresaDTO(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, String carrera, int tiempoDiario) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.tiempoDiario = tiempoDiario;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getTiempoDiario() {
        return tiempoDiario;
    }

    public void setTiempoDiario(int tiempoDiario) {
        this.tiempoDiario = tiempoDiario;
    }

    public String getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
