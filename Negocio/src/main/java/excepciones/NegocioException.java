/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones;

/**
 *
 * @author ang3lfco
 */
public class NegocioException extends Exception{
    
    public NegocioException(){
    }
    
    public NegocioException(String msg) {
        super(msg);
    }

    public NegocioException(String message, Throwable cause) {
        super(message, cause);
    }
}
