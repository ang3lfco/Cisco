/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Computadora;
import excepciones.PersistenciaException;

/**
 *
 * @author ReneEzequiel23
 */
public interface IComputadoraDAO {
    void agregarComputadora(Computadora computadora) throws PersistenciaException;
    void eliminarComputadora(Long id) throws PersistenciaException;
    void editarComputadora(Computadora computadora) throws PersistenciaException;
}
