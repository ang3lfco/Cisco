/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Entidades.Instituto;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IInstitutoDAO;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 *
 * @author ReneEzequiel23
 */
public class InstitutoDAO implements IInstitutoDAO {

    private IConexionBD conexionBD;

    public InstitutoDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarInstituto(Instituto instituto) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(instituto);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al agregar el instituto", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void eliminarInstituto(Long id) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            
            Instituto instituto = entityManager.find(Instituto.class, id);
            if (instituto != null) {
                entityManager.remove(instituto);
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al eliminar el instituto", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void editarInstituto(Instituto instituto) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(instituto);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al editar el instituto", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }

    }
}
