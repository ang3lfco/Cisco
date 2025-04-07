/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.persistencia;

import Dtos.ComputadoraDTO;
import Dtos.ReservaDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import Entidades.Laboratorio;
import Entidades.Reserva;
import daos.ComputadoraDAO;
import daos.ConexionBD;
import daos.HorarioEspecialDAO;
import daos.InstitutoDAO;
import daos.LaboratorioDAO;
import daos.ReservaDAO;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import interfaces.IHorarioEspecialDAO;
import interfaces.IInstitutoDAO;
import interfaces.ILaboratorioDAO;
import interfaces.IReservaDAO;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ang3lfco
 */
public class Persistencia {

    public static void main(String[] args) {
        IConexionBD conexion = new ConexionBD();
        
        IInstitutoDAO ins = new InstitutoDAO(conexion);
        ILaboratorioDAO lab = new LaboratorioDAO(conexion);
        IHorarioEspecialDAO he = new HorarioEspecialDAO(conexion);
        IComputadoraDAO pc = new ComputadoraDAO(conexion);
        IReservaDAO reserva = new ReservaDAO(conexion);
        
        
        List<Laboratorio> labs = new ArrayList<>();
        List<Computadora> equipos = new ArrayList<>();
        List<HorarioEspecial> horarios = new ArrayList<>();
        
        Instituto insti = new Instituto("nombre","alias");
        insti.setId(3L);
        Laboratorio laboratorio = new Laboratorio(3L,"nombre2",LocalTime.of(8, 0, 0), LocalTime.of(20, 0, 0),"Contraseña"
                    ,insti,equipos,horarios);
        
        HorarioEspecial horario = new HorarioEspecial(1L,LocalDate.of(2025, Month.MARCH, 21), LocalTime.of(8, 0, 0), LocalTime.of(20, 0, 0), laboratorio);
        
        Computadora compu =  new Computadora(1L,42,false,"papa",laboratorio);
        Estudiante e = new Estudiante();
        e.setId(1L);
        Reserva r = new Reserva(1L,LocalDate.now(),LocalTime.now(),LocalTime.now().plusMinutes(20L), compu, e);
        
        try {
            List<ComputadoraDTO> lista = pc.consultarNumeroComputadoras();
            
            for (int i = 0; i < lista.size(); i++) {
                System.out.println(lista.get(i).getNumero());
            }
            
            
        } catch (PersistenciaException ex) {
            Logger.getLogger(Persistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
