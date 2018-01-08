package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public abstract class Articulo {

    protected final Integer lote;
    protected final String valor;
    protected final int año;
    protected final String lugar_emision;
    protected final String conservacion;
    protected final float precio;
    protected final String foto;

    //Constructor usado para cuando se obtiene un billete de la BBDD.
    public Articulo(Integer lote, String valor, int año, String lugar_emision, String conservacion, float precio, String foto) {
        this.lote = lote;
        this.valor = valor;
        this.año = año;
        this.lugar_emision = lugar_emision;
        this.conservacion = conservacion;
        this.precio = precio;
        this.foto = foto;
    }

    // Constructor usado cuando se inserta un billete en la BBDD.
    public Articulo(String valor, int año, String lugar_emision, String conservacion, float precio, String foto) {
        this.lote = null;
        this.valor = valor;
        this.año = año;
        this.lugar_emision = lugar_emision;
        this.conservacion = conservacion;
        this.precio = precio;
        this.foto = foto;
    }
}
