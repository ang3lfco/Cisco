/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daos;

import Dtos.ComputadoraDTO;
import Dtos.EstudianteDTO;
import Dtos.LaboratorioDTO;
import Dtos.ReporteDTO;
import Dtos.ReservaDTO;
import Entidades.Computadora;
import Entidades.Estudiante;
import Entidades.HorarioEspecial;
import Entidades.Reserva;
import excepciones.PersistenciaException;
import interfaces.IConexionBD;
import interfaces.IReporteDAO;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;

/**
 *
 * @author ReneEzequiel23
 */
public class ReporteDAO implements IReporteDAO {

    private IConexionBD conexionBD;

    public ReporteDAO(IConexionBD conexionBD) {
        this.conexionBD = conexionBD;
    }

    @Override
    public List<ReporteDTO> consultarReservas(LocalDate inicio, LocalDate fin) throws PersistenciaException {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        entityManager = conexionBD.obtenerEntityManager();
        entityTransaction = entityManager.getTransaction();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

        CriteriaQuery<ReporteDTO> criteriaQuery = criteriaBuilder.createQuery(ReporteDTO.class);

        Root<Reserva> root = criteriaQuery.from(Reserva.class);
        Join<Reserva, HorarioEspecial> joinHorarioEspecial = root.join("horarioEspecial");
        Join<Reserva, Computadora> joinComputadora = root.join("computadora");
        Join<Reserva, Estudiante> joinEstudiante = root.join("estudiante");

        
        criteriaQuery.select(
                criteriaBuilder.construct(ReporteDTO.class,
                        root.get("computadora").get("laboratorio").get("nombre"),
                        root.get("horarioEspecial").get("fecha"),
                        joinHorarioEspecial.get("horaInicio"),
                        joinHorarioEspecial.get("horaFin"),
                        //Minutos sin uso
                        criteriaBuilder.diff(criteriaBuilder.sum(root.get("minutosSeleccionados")),
                                criteriaBuilder.sum(root.get("minutosUsados"))),
                        //Minutos Usados
                        criteriaBuilder.sum(root.get("minutosUsados"))
                )
        ).groupBy(root.get("computadora").get("laboratorio").get("nombre"), joinHorarioEspecial.get("fecha"),
                joinHorarioEspecial.get("horaInicio"),
                joinHorarioEspecial.get("horaFin")).
                where(criteriaBuilder.greaterThanOrEqualTo(joinHorarioEspecial.get("fecha"), inicio),
                        criteriaBuilder.lessThanOrEqualTo(joinHorarioEspecial.get("fecha"), fin));

        TypedQuery<ReporteDTO> query = entityManager.createQuery(criteriaQuery);

        List<ReporteDTO> reservas = query.getResultList();
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close(); // Cerrar siempre el EntityManager
        }

        return reservas;

    }
}
