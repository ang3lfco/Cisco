/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteIngresaDTO;
import Dtos.LaboratorioDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IEstudianteDAO;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author ang3lfco
 */
public class EstudianteDAO implements IEstudianteDAO{
    private IConexionBD conexionBD;
    
    public EstudianteDAO(IConexionBD conexionBD){
        this.conexionBD = conexionBD;
    }
    
    @Override
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
    
    @Override
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
    
    @Override
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
    
    public EstudianteIngresaDTO buscarPorIDAlumno(String id) throws PersistenciaException{
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<EstudianteIngresaDTO> criteriaQuery = criteriaBuilder.createQuery(EstudianteIngresaDTO.class);

        Root<Estudiante> root = criteriaQuery.from(Estudiante.class);

        criteriaQuery.select(
                criteriaBuilder.construct(EstudianteIngresaDTO.class,
                        root.get("id"),
                        root.get("idEstudiante"),
                        root.get("nombre"),
                        root.get("apellidoPaterno"),
                        root.get("apellidoMaterno"),
                        root.get("estado"),
                        root.get("contraseña"),
                        root.get("carrera").get("tiempoDiario")
                )
        ).where(criteriaBuilder.equal(root.get("idEstudiante"), id));

        TypedQuery<EstudianteIngresaDTO> query = entityManager.createQuery(criteriaQuery);
        if (query.equals(null)) {
         return null;   
        }
        EstudianteIngresaDTO estudianteDTO = query.getSingleResult();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return estudianteDTO;
        }catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
    
    @Override
    public Estudiante getEstudiantePorId(String idEstudiante) throws PersistenciaException {
        EntityManager em = conexionBD.obtenerEntityManager();
        try{
            CriteriaBuilder builder = em.getCriteriaBuilder();
            CriteriaQuery<Estudiante> query = builder.createQuery(Estudiante.class);
            Root<Estudiante> root = query.from(Estudiante.class);
            query.select(root).where(builder.equal(root.get("idEstudiante"), idEstudiante));
            return em.createQuery(query).getSingleResult();
        }
        catch(Exception e){
            throw new PersistenciaException("Error: " + e.getMessage());
        }
    }
}
