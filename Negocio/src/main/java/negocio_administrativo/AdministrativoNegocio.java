/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_administrativo;

import Dtos.ComputadoraDTO;
import Dtos.LaboratorioDTO;
import Entidades.Computadora;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAdministrativoNegocio;
import interfaces.IComputadoraDAO;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class AdministrativoNegocio implements IAdministrativoNegocio{
    private IComputadoraDAO computadoraDAO;
    
    public AdministrativoNegocio(IComputadoraDAO computadoraDAO){
        this.computadoraDAO = computadoraDAO;
    }
    
    @Override
    public void agregarEquipo(ComputadoraDTO computadoraDTO) throws NegocioException{
        try{
            Computadora equipo = new Computadora(computadoraDTO.getNumero(), computadoraDTO.isEstado(), computadoraDTO.getDireccionIp(), computadoraDTO.getLaboratorio());
            computadoraDAO.agregarComputadora(equipo);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    public List<LaboratorioDTO> getLaboratorios(){
        return null;
    }
}
