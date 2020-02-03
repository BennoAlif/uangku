/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uangkuapplication.error;

/**
 *
 * @author Rizki Restu
 */
public class RencanaException extends Exception {

    /**
     * Creates a new instance of <code>RencanaException</code> without detail
     * message.
     */
    public RencanaException() {
    }

    /**
     * Constructs an instance of <code>RencanaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public RencanaException(String msg) {
        super(msg);
    }
}
