/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_administrativo;

import Dtos.AgregarComputadoraDTO;
import Dtos.AgregarSoftwareDTO;
import Dtos.ComputadoraDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.InstitutoDTO;
import Dtos.LaboratorioDTO;
import Entidades.Computadora;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import Entidades.Laboratorio;
import Entidades.Software;
import conversiones.Conversiones;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IAdministrativoNegocio;
import interfaces.IComputadoraDAO;
import interfaces.ILaboratorioDAO;
import interfaces.ISoftwareDAO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ang3lfco
 */
public class AdministrativoNegocio implements IAdministrativoNegocio{
    private IComputadoraDAO computadoraDAO;
    private ILaboratorioDAO laboratorioDAO;
    private ISoftwareDAO softwareDAO;
    
    public AdministrativoNegocio(IComputadoraDAO computadoraDAO, ILaboratorioDAO laboratorioDAO, ISoftwareDAO softwareDAO){
        this.computadoraDAO = computadoraDAO;
        this.laboratorioDAO = laboratorioDAO;
        this.softwareDAO = softwareDAO;
    }
    
    @Override
    public void agregarEquipo(AgregarComputadoraDTO computadoraDTO) throws NegocioException{
        try{
            Laboratorio lab = laboratorioDAO.getLaboratorioPorNombre(computadoraDTO.getLaboratorio());
            Computadora equipo = Conversiones.computadoraDTOEnEntidad(computadoraDTO, lab);
            computadoraDAO.agregarComputadora(equipo);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public void agregarSoftware(AgregarSoftwareDTO softwareDTO) throws NegocioException{
        try{
            Software software = Conversiones.softwareDTOEnEntidad(softwareDTO);
            softwareDAO.agregar(software);
        }
        catch(PersistenciaException e){
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
}
