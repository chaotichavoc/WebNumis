
package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public class Cliente extends Usuario{
    
    private final String nombre;
    private final String apellidos;
    private final String dni;
    private final String direccion_entrega;
    private final int telefono;

    public Cliente(String nombre_usuario, String clave, String email, String nombre, String apellidos, String dni, String direccion_entrega, int telefono) {
        super(nombre_usuario, clave, email);
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.direccion_entrega = direccion_entrega;
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public String getDni() {
        return dni;
    }

    public String getDireccion_entrega() {
        return direccion_entrega;
    }

    public int getTelefono() {
        return telefono;
    }
    
}
