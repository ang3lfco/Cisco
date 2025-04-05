/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Entidades.HorarioEspecial;
import excepciones.PersistenciaException;

/**
 *
 * @author ReneEzequiel23
 */
public interface IHorarioEspecialDAO {
    void agregarHorarioEspecial(HorarioEspecial he) throws PersistenciaException;
    void eliminarHorarioEspecial(Long id) throws PersistenciaException;
    void editarHorarioEspecial(HorarioEspecial he) throws PersistenciaException;
}
