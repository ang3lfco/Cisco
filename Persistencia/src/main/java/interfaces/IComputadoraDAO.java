/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ComputadoraDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import excepciones.PersistenciaException;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IComputadoraDAO {
    void agregarComputadora(Computadora computadora) throws PersistenciaException;
    void eliminarComputadora(Long id) throws PersistenciaException;
    void editarComputadora(Computadora computadora) throws PersistenciaException;
    List<ComputadoraDTO> consultarNumeroComputadorasPorLaboratorio(Long id,String tipo) throws PersistenciaException;
    ComputadoraDTO consultarComputadorasPorIP(String ip) throws PersistenciaException;
    List<SoftwareDTO> consultarSoftwareDeComputadoras(String ip,String tipo) throws PersistenciaException;
    Computadora getComputadoraPorNumero(int numero) throws PersistenciaException;
    ComputadoraDTO consultarComputadorasPorIPYTipo(String ip,String tipo) throws PersistenciaException;
    List<ComputadoraDTO> consultarComputadoras() throws PersistenciaException;
    Computadora getComputadoraPorLab(String nombreLab,String ip, String tipo) throws PersistenciaException;
}
