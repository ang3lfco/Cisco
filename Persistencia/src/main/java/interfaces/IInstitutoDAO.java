/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Instituto;
import excepciones.PersistenciaException;

/**
 *
 * @author ReneEzequiel23
 */
public interface IInstitutoDAO {
    void agregarInstituto(Instituto instituto) throws PersistenciaException;
    void eliminarInstituto(Long id) throws PersistenciaException;
    void editarInstituto(Instituto instituto) throws PersistenciaException;
}
