/**
 * Gestor de excepciones.
 */
package com.multimedia.modelo;

/**
 *
 * @author Grupo 11
 */
public class ExceptionManager extends RuntimeException{

    public ExceptionManager() {
    }

    public ExceptionManager(String message) {
        super(message);
    }

    public ExceptionManager(String message, Throwable cause) {
        super(message, cause);
    }
}
