/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import javax.persistence.EntityManager;

/**
 *
 * @author ReneEzequiel23
 */
public interface IConexionBD {
    EntityManager obtenerEntityManager();
    void cerrarEntityManagerFactory();
}
