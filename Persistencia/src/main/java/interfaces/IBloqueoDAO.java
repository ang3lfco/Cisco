/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.BloqueoDTO;
import Entidades.Bloqueo;
import excepciones.PersistenciaException;

/**
 *
 * @author ang3lfco
 */
public interface IBloqueoDAO {
    void agregar(Bloqueo bloqueo) throws PersistenciaException;
    void eliminar(Long id) throws PersistenciaException;
    void editar(Bloqueo bloqueo) throws PersistenciaException;
    void desbloquear(String idEstudiante) throws PersistenciaException;
    BloqueoDTO consultarUltimoBloqueoDeEstudiante(String id) throws PersistenciaException;
}
