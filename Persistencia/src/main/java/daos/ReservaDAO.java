/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReservaDTO;
import Dtos.minutosUsadosPorEstudianteDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.Reserva;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IReservaDAO;
import java.time.LocalDate;
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
public class ReservaDAO implements IReservaDAO {

    private IConexionBD conexionBD;

    public ReservaDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public void agregarReserva(Reserva reserva) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.persist(reserva);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al agregar la reserva", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void eliminarReserva(Long id) throws PersistenciaException {

        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();

            Reserva reserva = entityManager.find(Reserva.class, id);
            if (reserva != null) {
                entityManager.remove(reserva);
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al eliminar la reserva", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }
    }

    @Override
    public void editarReserva(Reserva reserva) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            entityTransaction.begin();
            entityManager.merge(reserva);
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction != null && entityTransaction.isActive()) {
                entityTransaction.rollback(); // Revertir en caso de error
            }
            throw new PersistenciaException("Error al editar la reserva", e); // Encapsular excepción
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }

    }

    @Override
    public List<ReservaDTO> consultarReservas() throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ReservaDTO> criteriaQuery = criteriaBuilder.createQuery(ReservaDTO.class);

        Root<Reserva> root = criteriaQuery.from(Reserva.class);
        Join<Reserva, Computadora> joinComputadora = root.join("computadora");
        Join<Reserva, Estudiante> joinEstudiante = root.join("estudiante");

        criteriaQuery.select(
                criteriaBuilder.construct(ReservaDTO.class,
                        root.get("id"),
                        root.get("horaInicio"),
                        root.get("horaFin"),
                        root.get("minutosSeleccionados"),
                        root.get("minutosUsados"),
                        criteriaBuilder.construct(ComputadoraDTO.class,
                                joinComputadora.get("id"),
                                joinComputadora.get("numero"),
                                joinComputadora.get("estado"),
                                joinComputadora.get("direccionIp"),
                                criteriaBuilder.construct(LaboratorioDTO.class,
                                        joinComputadora.get("laboratorio").get("id"))
                        ),
                        criteriaBuilder.construct(EstudianteDTO.class,
                                joinEstudiante.get("id"),
                                joinEstudiante.get("idEstudiante"),
                                joinEstudiante.get("nombre"),
                                joinEstudiante.get("apellidoPaterno"),
                                joinEstudiante.get("apellidoMaterno"),
                                joinEstudiante.get("contraseña")
                        )
                )
        );

        TypedQuery<ReservaDTO> query = entityManager.createQuery(criteriaQuery);

        List<ReservaDTO> reservas = query.getResultList();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return reservas;

    }

    @Override
    public ReservaDTO consultarReserva(String ip) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        ReservaDTO reserva = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<ReservaDTO> criteriaQuery = criteriaBuilder.createQuery(ReservaDTO.class);

            Root<Reserva> root = criteriaQuery.from(Reserva.class);
            Join<Reserva, Computadora> joinComputadora = root.join("computadora");
            Join<Reserva, Estudiante> joinEstudiante = root.join("estudiante");

            criteriaQuery.select(
                    criteriaBuilder.construct(ReservaDTO.class,
                            root.get("id"),
                            root.get("horaInicio"),
                            root.get("minutosSeleccionados"),
                            root.get("minutosUsados"),
                            criteriaBuilder.construct(ComputadoraDTO.class,
                                    joinComputadora.get("id"),
                                    joinComputadora.get("numero"),
                                    joinComputadora.get("estado"),
                                    joinComputadora.get("direccionIp"),
                                    criteriaBuilder.construct(LaboratorioDTO.class,
                                            joinComputadora.get("laboratorio").get("id"))
                            ),
                            criteriaBuilder.construct(EstudianteDTO.class,
                                    joinEstudiante.get("id"),
                                    joinEstudiante.get("idEstudiante"),
                                    joinEstudiante.get("nombre"),
                                    joinEstudiante.get("apellidoPaterno"),
                                    joinEstudiante.get("apellidoMaterno"),
                                    joinEstudiante.get("contraseña")
                            )
                    )
            ).where(
                    criteriaBuilder.equal(joinComputadora.get("direccionIp"), ip),
                    criteriaBuilder.isNull(root.get("horaFin")));
            
            TypedQuery<ReservaDTO> query = entityManager.createQuery(criteriaQuery);
            
            try{
                reserva = query.getSingleResult();
            }catch (NoResultException e){
                reserva = null;
            }
            
        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close(); // Cerrar siempre el EntityManager
            }
        }

        return reserva;

    }

    @Override
    public minutosUsadosPorEstudianteDTO minutosUsadosPorEstudiante(String id, LocalDate fecha) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        minutosUsadosPorEstudianteDTO consultas = null;

        try {
            entityManager = conexionBD.obtenerEntityManager();
            entityTransaction = entityManager.getTransaction();

            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

            CriteriaQuery<minutosUsadosPorEstudianteDTO> criteriaQuery = criteriaBuilder.createQuery(minutosUsadosPorEstudianteDTO.class);

            Root<Reserva> root = criteriaQuery.from(Reserva.class);

            criteriaQuery.select(
                    criteriaBuilder.construct(minutosUsadosPorEstudianteDTO.class,
                            criteriaBuilder.sum(root.get("minutosUsados"))
                    )
            ).where(criteriaBuilder.equal(root.get("estudiante").get("idEstudiante"), id),
                    criteriaBuilder.equal(root.get("horarioEspecial").get("fecha"), fecha));

            TypedQuery<minutosUsadosPorEstudianteDTO> query = entityManager.createQuery(criteriaQuery);

            try {
                consultas = query.getSingleResult();
            } catch (NoResultException e) {
                consultas = new minutosUsadosPorEstudianteDTO(0); // o lo que tenga sentido
            }

        } finally {
            if (entityManager != null && entityManager.isOpen()) {
                entityManager.close();
            }
        }
        return consultas;
    }
}
