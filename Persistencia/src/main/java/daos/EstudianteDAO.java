/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Estudiante;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import javax.persistence.EntityManager;

/**
 *
 * @author ang3lfco
 */
public class EstudianteDAO {
    private IConexionBD conexionBD;
    
    public EstudianteDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    public void agregar(Estudiante estudiante) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(estudiante);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
    
    public void eliminar(Long id) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            Estudiante estudiante = em.find(Estudiante.class, id);
            if(estudiante != null){
                em.remove(estudiante);
            }
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error: " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
    
    public void editar(Estudiante estudiante) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            em.merge(estudiante);
            em.getTransaction().commit();
        }
        catch(Exception e){
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        }
        finally{
        }
    }
}
