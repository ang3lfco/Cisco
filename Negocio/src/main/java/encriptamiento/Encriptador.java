/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package encriptamiento;

import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ang3lfco
 */
public class Encriptador {
    public static String encriptarContraseña(String contraseña) {
        String contrasenhaEncriptada = BCrypt.hashpw(contraseña, BCrypt.gensalt());
        return contrasenhaEncriptada;
    }
    
    public static boolean verificarContraseña(String contraseñaOriginal, String contraseñaEncriptada) {
        return BCrypt.checkpw(contraseñaOriginal, contraseñaEncriptada);
    }
}
