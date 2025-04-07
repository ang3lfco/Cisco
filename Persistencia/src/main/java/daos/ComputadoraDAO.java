/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReservaDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Laboratorio;
import Entidades.Reserva;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author ReneEzequiel23
 */
public class ComputadoraDAO implements IComputadoraDAO {

    private IConexionBD conexionBD;

    public ComputadoraDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarComputadora(Computadora computadora) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(computadora);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al agregar la Computadora", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void eliminarComputadora(Long id) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            Computadora pc = entityManager.find(Computadora.class, id);
            if (pc != null) {
                entityManager.remove(pc);
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al eliminar la computadora", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void editarComputadora(Computadora computadora) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(computadora);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al editar la computadora", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public List<ComputadoraDTO> consultarNumeroComputadoras() throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ComputadoraDTO> criteriaQuery = criteriaBuilder.createQuery(ComputadoraDTO.class);

        Root<Computadora> root = criteriaQuery.from(Computadora.class);

        criteriaQuery.select(
                criteriaBuilder.construct(ComputadoraDTO.class,
                        root.get("id"),
                        root.get("numero"),
                        root.get("estado"),
                        root.get("direccionIp"),
                        criteriaBuilder.construct(LaboratorioDTO.class,
                         root.get("laboratorio").get("id")
                ))
        );

        TypedQuery<ComputadoraDTO> query = entityManager.createQuery(criteriaQuery);

        List<ComputadoraDTO> pcs = query.getResultList();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return pcs;

    }
}
