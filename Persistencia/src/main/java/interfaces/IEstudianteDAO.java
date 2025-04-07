/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.EstudianteIngresaDTO;
import Entidades.Estudiante;
import excepciones.PersistenciaException;

/**
 *
 * @author ang3lfco
 */
public interface IEstudianteDAO {
    void agregar(Estudiante estudiante) throws PersistenciaException;
    void eliminar(Long id) throws PersistenciaException;
    void editar(Estudiante estudiante) throws PersistenciaException;
    EstudianteIngresaDTO buscarPorIDAlumno(String id) throws PersistenciaException;
}
