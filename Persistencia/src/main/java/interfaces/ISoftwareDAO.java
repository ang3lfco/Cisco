/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Software;
import excepciones.PersistenciaException;

/**
 *
 * @author ang3lfco
 */
public interface ISoftwareDAO {
    void agregar(Software software) throws PersistenciaException;
    void eliminar(Long id) throws PersistenciaException;
    void editar(Software software) throws PersistenciaException;
}
