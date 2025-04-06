/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Carrera;
import excepciones.PersistenciaException;

/**
 *
 * @author ang3lfco
 */
public interface ICarreraDAO {
    void agregar(Carrera carrera) throws PersistenciaException;
    void eliminar(Long id) throws PersistenciaException;
    void editar(Carrera carrera) throws PersistenciaException;
}
