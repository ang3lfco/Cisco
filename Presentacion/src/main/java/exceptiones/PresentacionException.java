/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exceptiones;

/**
 *
 * @author ReneEzequiel23
 */
public class PresentacionException extends Exception {
    public PresentacionException(){
    }
    
    public PresentacionException(String msg) {
        super(msg);
    }

    public PresentacionException(String message, Throwable cause) {
        super(message, cause);
    }
}
