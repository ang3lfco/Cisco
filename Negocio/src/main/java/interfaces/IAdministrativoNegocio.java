/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import Dtos.AgregarComputadoraDTO;
import Dtos.ComputadoraDTO;
import excepciones.NegocioException;

/**
 *
 * @author ang3lfco
 */
public interface IAdministrativoNegocio {
    void agregarEquipo(AgregarComputadoraDTO computadoraDTO) throws NegocioException;
}
