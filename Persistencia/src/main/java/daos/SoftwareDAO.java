/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.LaboratorioDTO;
import Dtos.SoftwareDTO;
import Entidades.Computadora;
import Entidades.Software;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.ISoftwareDAO;
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
 * @author ang3lfco
 */
public class SoftwareDAO implements ISoftwareDAO {

    private IConexionBD conexionBD;

    public SoftwareDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregar(Software software) throws PersistenciaException {
        EntityManager em = conexionBD.obtenerEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(software);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(Long id) throws PersistenciaException {
        EntityManager em = conexionBD.obtenerEntityManager();
        try {
            em.getTransaction().begin();
            Software software = em.find(Software.class, id);
            if (software != null) {
                em.remove(software);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(Software software) throws PersistenciaException {
        EntityManager em = conexionBD.obtenerEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(software);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw new PersistenciaException("Error. " + e.getMessage());
        } finally {
            em.close();
        }
    }

}
