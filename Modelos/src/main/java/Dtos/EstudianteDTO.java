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
public class EstudianteDTO {
    private Long id;
    private String idEstudiante;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String estado;
    private String contraseña;
    private CarreraDTO carrera;
    private List<BloqueoDTO> bloqueos;
    private List<ReservaDTO> reservas;

    public EstudianteDTO() {
    }

    public EstudianteDTO(String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, CarreraDTO carrera, List<BloqueoDTO> bloqueos, List<ReservaDTO> reservas) {
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.bloqueos = bloqueos;
        this.reservas = reservas;
    }

    public EstudianteDTO(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String estado, String contraseña, CarreraDTO carrera, List<BloqueoDTO> bloqueos, List<ReservaDTO> reservas) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.estado = estado;
        this.contraseña = contraseña;
        this.carrera = carrera;
        this.bloqueos = bloqueos;
        this.reservas = reservas;
    }

    public EstudianteDTO(Long id, String idEstudiante, String nombre, String apellidoPaterno, String apellidoMaterno, String contraseña) {
        this.id = id;
        this.idEstudiante = idEstudiante;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.contraseña = contraseña;
    }

    public EstudianteDTO(Long id) {
        this.id = id;
    }

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CarreraDTO getCarrera() {
        return carrera;
    }

    public void setCarrera(CarreraDTO carrera) {
        this.carrera = carrera;
    }

    public List<BloqueoDTO> getBloqueos() {
        return bloqueos;
    }

    public void setBloqueos(List<BloqueoDTO> bloqueos) {
        this.bloqueos = bloqueos;
    }

    public List<ReservaDTO> getReservas() {
        return reservas;
    }

    public void setReservas(List<ReservaDTO> reservas) {
        this.reservas = reservas;
    }
}