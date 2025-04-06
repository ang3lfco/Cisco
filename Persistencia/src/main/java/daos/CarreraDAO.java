/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Carrera;
import Entidades.Software;
import excepciones.PersistenciaException;
import interfaces.ICarreraDAO;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;

/**
 *
 * @author ang3lfco
 */
public class CarreraDAO implements ICarreraDAO{
    private IConexionBD conexionBD;
    
    public CarreraDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregar(Carrera carrera) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(carrera);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void eliminar(Long id) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            Carrera carrera = em.find(Carrera.class, id);
            if(carrera != null){
                em.remove(carrera);
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public void editar(Carrera carrera) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(carrera);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
}
