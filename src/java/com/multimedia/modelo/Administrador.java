package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public class Administrador extends Usuario {

    private final int nivel_permisos;

    public Administrador(String nombre_usuario, String clave, String email, int nivel_permisos) {
        super(nombre_usuario, clave, email);
        this.nivel_permisos = nivel_permisos;
    }

    public int getNivel_permisos() {
        return nivel_permisos;
    }

}
