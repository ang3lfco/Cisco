/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.EstudianteIngresaDTO;
import Dtos.HorarioEspecialDTO;
import Dtos.LaboratorioDTO;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Instituto;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IHorarioEspecialDAO;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ReneEzequiel23
 */
public class HorarioEspecialDAO implements IHorarioEspecialDAO{
    private IConexionBD conexionBD;

    public HorarioEspecialDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }
    
    @Override
    public void agregarHorarioEspecial(HorarioEspecial he) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(he);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al agregar el horario especial", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void eliminarHorarioEspecial(Long id) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            
            HorarioEspecial he = entityManager.find(HorarioEspecial.class, id);
            if (he != null) {
                entityManager.remove(he);
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al eliminar el horario especial", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void editarHorarioEspecial(HorarioEspecial he) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(he);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al editar el Horario especial", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }

    }
    
    @Override
    public HorarioEspecialDTO buscarHorarioPorDia(LocalDate hoy) throws PersistenciaException{
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<HorarioEspecialDTO> criteriaQuery = criteriaBuilder.createQuery(HorarioEspecialDTO.class);

        Root<HorarioEspecial> root = criteriaQuery.from(HorarioEspecial.class);

        criteriaQuery.select(
                criteriaBuilder.construct(HorarioEspecialDTO.class,
                        root.get("id"),
                        root.get("fecha"),
                        root.get("horaInicio"),
                        root.get("horaFin"),
                        criteriaBuilder.construct(LaboratorioDTO.class,
                        root.get("laboratorio").get("id"))
                )
        ).where(criteriaBuilder.equal(root.get("fecha"), hoy));

        TypedQuery<HorarioEspecialDTO> query = entityManager.createQuery(criteriaQuery);
        
        if (query.getResultList().isEmpty()) {
         return null;   
        }
            HorarioEspecialDTO dto = query.getSingleResult();

        return dto;
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
}
