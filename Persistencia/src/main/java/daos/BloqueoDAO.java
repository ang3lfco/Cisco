/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Bloqueo;
import Entidades.Estudiante;
import excepciones.PersistenciaException;
import interfaces.IBloqueoDAO;
import interfaces.IConexionBD;
import java.time.LocalDateTime;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class BloqueoDAO implements IBloqueoDAO{
    private IConexionBD conexionBD;
    
    public BloqueoDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    @Override
    public void desbloquear(String idEstudiante) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            em.getTransaction().begin();
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);
            Root<Estudiante> root = query.from(Estudiante.class);
            query.select(root).where(builder.equal(root.get("idEstudiante"), idEstudiante));
            Estudiante estudiante = em.createQuery(query).getSingleResult();
            
            CriteriaQuery<Bloqueo> queryB = builder.createQuery(Bloqueo.class);
            Root<Bloqueo> rootB = queryB.from(Bloqueo.class);
            queryB.select(rootB).where(builder.equal(rootB.get("estudiante"), estudiante)).orderBy(builder.desc(rootB.get("fechaHoraBloqueo")));
            
            TypedQuery<Bloqueo> queryBloqueo = em.createQuery(queryB);
            queryBloqueo.setMaxResults(1); 
            
            Bloqueo bloqueo = queryBloqueo.getSingleResult();
            bloqueo.setFechaHoraDesbloqueo(LocalDateTime.now());
            
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
