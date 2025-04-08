/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Entidades.Laboratorio;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface ILaboratorioDAO {
    void agregarLaboratorio(Laboratorio laboratorio) throws PersistenciaException;
    void eliminarLaboratorio(Long id) throws PersistenciaException;
    void editarLaboratorio(Laboratorio laboratorio) throws PersistenciaException;
    List<Laboratorio> getLaboratorios() throws PersistenciaException;
    Laboratorio getLaboratorioPorNombre(String nombre) throws PersistenciaException;
}
