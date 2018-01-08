package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public class Usuario {

    protected final String nombre_usuario;
    protected final String clave;
    protected final String email;

    public Usuario(String nombre_usuario, String clave, String email) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.email = email;
    }

    public Usuario(String nombre_usuario, String clave) {
        this.nombre_usuario = nombre_usuario;
        this.clave = clave;
        this.email = null;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public String getClave() {
        return clave;
    }

    public String getEmail() {
        return email;
    }

}
