/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio_computadora;

import Dtos.ComputadoraDTO;
import Dtos.ReservaDTO;
import Entidades.Computadora;
import Entidades.Laboratorio;
import Entidades.Reserva;
import conversiones.Conversiones;
import static conversiones.Conversiones.convertirComputadoraDTOAComputadora;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IComputadoraNegocio;
import interfaces.IReservaDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang3lfco
 */
public class ComputadoraNegocio implements IComputadoraNegocio{
    private IComputadoraDAO computadoraDAO;
    private IReservaDAO reservaDAO;
    
    public ComputadoraNegocio(IComputadoraDAO computadoraDAO) {
        this.computadoraDAO = computadoraDAO;
    }

    public ComputadoraNegocio(IComputadoraDAO computadoraDAO, IReservaDAO reservaDAO) {
        this.computadoraDAO = computadoraDAO;
        this.reservaDAO = reservaDAO;
    }
    
    
    @Override
    public ComputadoraDTO computadoraPorIp(String ip) throws NegocioException{
        try {
            if (computadoraDAO.consultarComputadorasPorIP(ip) == null) {
                return null;
            }
            ComputadoraDTO dto = computadoraDAO.consultarComputadorasPorIP(ip);
            
            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public ReservaDTO reservaPorComputadora(String ip) throws NegocioException{
        try {
            if (reservaDAO.consultarReserva(ip) == null) {
                return null;
            }
            ReservaDTO dto = reservaDAO.consultarReserva(ip);
            
            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
    @Override
    public void editarComputadora(ComputadoraDTO pc) throws NegocioException {
        try {
            Computadora entidad = this.convertirComputadoraDTOAComputadora(pc);

            computadoraDAO.editarComputadora(entidad);
        } catch (PersistenciaException e) {
            throw new NegocioException("Error. " + e.getMessage());
        }
    }
    
    @Override
    public ComputadoraDTO computadoraPorIpYTipo(String ip, String tipo) throws NegocioException {
        try {
            ComputadoraDTO dto = computadoraDAO.consultarComputadorasPorIPYTipo(ip, tipo);

            return dto;
        } catch (PersistenciaException ex) {
            throw new NegocioException("Error. " + ex.getMessage());
        }
    }
    
     public Computadora convertirComputadoraDTOAComputadora(ComputadoraDTO computadoraDTO) {
        if (computadoraDTO == null) {
            System.out.println("NULO");
            return null;
        }
        System.out.println("NO NULO");
        Laboratorio lab = new Laboratorio();
        lab.setId(computadoraDTO.getLaboratorio().getId());

        Computadora computadora = new Computadora();
        computadora.setId(computadoraDTO.getId());
        computadora.setNumero(computadoraDTO.getNumero());
        computadora.setEstado(computadoraDTO.isEstado());
        computadora.setDireccionIp(computadoraDTO.getDireccionIp());
        computadora.setTipo(computadoraDTO.getTipo());
        computadora.setLaboratorio(lab);
        
        return computadora;
    }
}
