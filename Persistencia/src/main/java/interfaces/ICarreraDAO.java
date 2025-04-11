/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Carrera;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public interface ICarreraDAO {
    void agregar(Carrera carrera) throws PersistenciaException;
    void eliminar(Long id) throws PersistenciaException;
    void editar(Carrera carrera) throws PersistenciaException;
    Carrera getCarreraPorId(Long id) throws PersistenciaException;
    Carrera getCarreraPorNombre(String nombre) throws PersistenciaException;
    List<Carrera> getCarreras() throws PersistenciaException;
}
