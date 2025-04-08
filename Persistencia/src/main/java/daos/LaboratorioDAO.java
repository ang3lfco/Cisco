/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Instituto;
import Entidades.Laboratorio;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ILaboratorioDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ReneEzequiel23
 */
public class LaboratorioDAO implements ILaboratorioDAO{
    private IConexionBD conexionBD;

    public LaboratorioDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregarLaboratorio(Laboratorio laboratorio) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(laboratorio);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al agregar el laboratorio", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void eliminarLaboratorio(Long id) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            
            Laboratorio laboratorio = entityManager.find(Laboratorio.class, id);
            if (laboratorio != null) {
                entityManager.remove(laboratorio);
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al eliminar el laboratorio", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void editarLaboratorio(Laboratorio laboratorio) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(laboratorio);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al editar el laboratorio, e"); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }
    
    @Override
    public List<Laboratorio> getLaboratorios() throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            return em.createQuery("SELECT l from Laboratorio l", Laboratorio.class).getResultList();
        }
        catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
    
    @Override
    public Laboratorio getLaboratorioPorNombre(String nombre) throws PersistenciaException{
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Laboratorio> query = builder.createQuery(Laboratorio.class);
            Root<Laboratorio> root = query.from(Laboratorio.class);
            query.select(root).where(builder.equal(root.get("nombre"), nombre));
            return em.createQuery(query).getSingleResult();
        }
        catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
        finally{
            em.close();
        }
    }
}
