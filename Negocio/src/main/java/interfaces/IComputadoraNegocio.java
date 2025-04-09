/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.ComputadoraDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import excepciones.NegocioException;
import java.util.List;

/**
 *
 * @author ReneEzequiel23
 */
public interface IComputadoraNegocio {
    ComputadoraDTO computadoraPorIp(String ip) throws NegocioException;
    ReservaDTO reservaPorComputadora(String ip) throws NegocioException;
    void editarComputadora(ComputadoraDTO pc) throws NegocioException;
    ComputadoraDTO computadoraPorIpYTipo(String ip, String tipo) throws NegocioException;
}
