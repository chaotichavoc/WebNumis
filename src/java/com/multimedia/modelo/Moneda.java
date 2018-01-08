/**
 * Bean de Moneda para gestionar los datos procedentes de la BBDD.
 */
package com.multimedia.modelo;

/**
 *
 * @author Grupo11
 */
public class Moneda extends Articulo {

    private final String estrellas;

    public Moneda(Integer lote, String valor, int año, String estrellas, String lugar_emision, String conservacion, float precio, String foto) {
        super(valor, año, lugar_emision, conservacion, precio, foto);
        this.estrellas = estrellas;
    }

    public Moneda(String valor, int año, String estrellas, String lugar_emision, String conservacion, float precio, String foto) {
        super(valor, año, lugar_emision, conservacion, precio, foto);
        this.estrellas = estrellas;
    }
    
    public Integer getLote() {
        return lote;
    }

    public String getValor() {
        return valor;
    }

    public int getAño() {
        return año;
    }

    public String getEstrellas() {
        return estrellas;
    }

    public String getLugar_emision() {
        return lugar_emision;
    }

    public String getConservacion() {
        return conservacion;
    }

    public float getPrecio() {
        return precio;
    }

    public String getFoto() {
        return foto;
    }

}
