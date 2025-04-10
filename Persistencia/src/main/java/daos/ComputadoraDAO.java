/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReservaDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Laboratorio;
import Entidades.Reserva;
import Entidades.Software;
import excepciones.PersistenciaException;
import interfaces.IComputadoraDAO;
import interfaces.IConexionBD;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
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
    public List<ComputadoraDTO> consultarNumeroComputadorasPorLaboratorio(Long id, String tipo) throws PersistenciaException {
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
                                root.get("laboratorio").get("id"),
                                root.get("laboratorio").get("nombre")
                        ))
        ).where(criteriaBuilder.equal(root.get("laboratorio").get("id"), id),
                criteriaBuilder.equal(root.get("estado"), false),
                criteriaBuilder.equal(root.get("tipo"), tipo)).orderBy(criteriaBuilder.asc(root.get("numero")));

        TypedQuery<ComputadoraDTO> query = entityManager.createQuery(criteriaQuery);

        List<ComputadoraDTO> pcs = query.getResultList();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return pcs;
    }

    @Override
    public ComputadoraDTO consultarComputadorasPorIP(String ip) throws PersistenciaException {
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
                                root.get("laboratorio").get("id"),
                                root.get("laboratorio").get("nombre"),
                                root.get("laboratorio").get("horaInicio"),
                                root.get("laboratorio").get("horaFin")
                        ))
        ).where(criteriaBuilder.equal(root.get("direccionIp"), ip));

        TypedQuery<ComputadoraDTO> query = entityManager.createQuery(criteriaQuery);

        if (query.getResultList().isEmpty()) {
            return null;
        }
        ComputadoraDTO pc = query.getSingleResult();

        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return pc;
    }

    @Override
    public ComputadoraDTO consultarComputadorasPorIPYTipo(String ip, String tipo) throws PersistenciaException {
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
                        root.get("tipo"),
                        criteriaBuilder.construct(LaboratorioDTO.class,
                                root.get("laboratorio").get("id"),
                                root.get("laboratorio").get("nombre"),
                                root.get("laboratorio").get("horaInicio"),
                                root.get("laboratorio").get("horaFin")
                        ))
        ).where(criteriaBuilder.equal(root.get("tipo"), tipo),criteriaBuilder.and(criteriaBuilder.equal(root.get("direccionIp"), ip)));

        TypedQuery<ComputadoraDTO> query = entityManager.createQuery(criteriaQuery);

        if (query.getResultList().isEmpty()) {
            return null;
        }
        ComputadoraDTO pc = query.getSingleResult();

        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return pc;
    }

    @Override
    public List<SoftwareDTO> consultarSoftwareDeComputadoras(String ip) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<SoftwareDTO> criteriaQuery = criteriaBuilder.createQuery(SoftwareDTO.class);

        Root<Computadora> root = criteriaQuery.from(Computadora.class);
        Join<Computadora, Software> joinSoftware = root.join("softwares"); // ← nombre del atributo en Computadora

        criteriaQuery.select(criteriaBuilder.construct(SoftwareDTO.class,
                joinSoftware.get("nombre"),
                joinSoftware.get("version"))
        )
                .where(criteriaBuilder.equal(root.get("direccionIp"), ip));

        TypedQuery<SoftwareDTO> query = entityManager.createQuery(criteriaQuery);

        List<SoftwareDTO> pcs = query.getResultList();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return pcs;
    }

    @Override
    public Computadora getComputadoraPorNumero(int numero) throws PersistenciaException {
        EntityManager em = conexionBD.obtenerEntityManager();
        try {
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Computadora> query = builder.createQuery(Computadora.class);
            Root<Computadora> root = query.from(Computadora.class);
            query.select(root).where(builder.equal(root.get("numero"), numero));
            return em.createQuery(query).getSingleResult();
        } catch (Exception e) {
            throw new PersistenciaException("Error: " + e.getMessage());
        } finally {
            em.close();
        }
    }
    
    @Override
    public List<ComputadoraDTO> consultarComputadoras() throws PersistenciaException {
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
                        root.get("tipo"),
                        criteriaBuilder.construct(LaboratorioDTO.class,
                                root.get("laboratorio").get("id"),
                                root.get("laboratorio").get("nombre")
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
