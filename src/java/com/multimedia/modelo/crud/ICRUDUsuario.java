package com.multimedia.modelo.crud;

import com.multimedia.modelo.Usuario;

/**
 *
 * @author Grupo11
 */
public abstract interface ICRUDUsuario {

    boolean esUsuarioRegistrado(String nombre_usuario);

    boolean inicioSesionValido(Usuario usuario);
}
