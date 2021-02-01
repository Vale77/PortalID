/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.uasb.bean.exceptions;

/**
 *
 * @author victor.barba
 */
public class TemaException extends Exception {

    /**
     * Creates a new instance of
     * <code>TemaException</code> without detail message.
     */
    public TemaException() {
    }

    /**
     * Constructs an instance of
     * <code>TemaException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public TemaException(String msg) {
        super(msg);
    }
}
