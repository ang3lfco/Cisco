/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Bloqueo;
import Entidades.Software;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;

/**
 *
 * @author ang3lfco
 */
public class BloqueoDAO {
    private IConexionBD conexionBD;
    
    public BloqueoDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    public void agregar(Bloqueo bloqueo) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(bloqueo);
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
    
    public void eliminar(Long id) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            Bloqueo bloqueo = em.find(Bloqueo.class, id);
            if(bloqueo != null){
                em.remove(bloqueo);
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
    
    public void editar(Bloqueo bloqueo) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(bloqueo);
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
