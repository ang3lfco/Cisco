/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_administrativo;

import Dtos.ComputadoraDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.InstitutoDTO;
import Dtos.LaboratorioDTO;
import Entidades.Computadora;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import Entidades.Laboratorio;
import conversiones.Conversiones;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAdministrativoNegocio;
import interfaces.IComputadoraDAO;
import interfaces.ILaboratorioDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class AdministrativoNegocio implements IAdministrativoNegocio{
    private IComputadoraDAO computadoraDAO;
    private ILaboratorioDAO laboratorioDAO;
    
    public AdministrativoNegocio(IComputadoraDAO computadoraDAO, ILaboratorioDAO laboratorioDAO){
        this.computadoraDAO = computadoraDAO;
        this.laboratorioDAO = laboratorioDAO;
    }
    
    @Override
    public void agregarEquipo(ComputadoraDTO computadoraDTO) throws NegocioException{
        try{
            Computadora equipo = Conversiones.convertirComputadoraDTOAComputadora(computadoraDTO);
            computadoraDAO.agregarComputadora(equipo);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
}
