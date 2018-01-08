package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public class Subasta {

    private final Integer id;
    private final String nombre;
    private final float precioInicial;
    private final float precioFinal;
    private final String nombreGanador;

    public Subasta(Integer id, String nombre, float precioInicial, float precioFinal, String nombreGanador) {
        this.id = id;
        this.nombre = nombre;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
        this.nombreGanador = nombreGanador;
    }

    public Subasta(String nombre, float precioInicial, float precioFinal, String nombreGanador) {
        this.id = null;
        this.nombre = nombre;
        this.precioInicial = precioInicial;
        this.precioFinal = precioFinal;
        this.nombreGanador = nombreGanador;
    }

    public Integer getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public float getPrecioInicial() {
        return precioInicial;
    }

    public float getPrecioFinal() {
        return precioFinal;
    }

    public String getNombreGanador() {
        return nombreGanador;
    }

}
