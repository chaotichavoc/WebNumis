/**
 * Bean de Billete para manejar los datos procedentes de la BBDD.
 */
package com.multimedia.modelo;

import java.time.LocalDate;

/**
 *
 * @author Grupo11
 */
public class Billete extends Articulo {

    //(Lote, valor, año, lugar de emisión, fecha, serie, conservación, precio, <<foto>>)
    private final LocalDate fecha;
    private final String serie;

    public Billete(Integer lote, 
            String valor, int año, String lugar_emision, LocalDate fecha, String serie, String conservacion, float precio, String foto) {
        super(lote, valor, año, lugar_emision, conservacion, precio, foto);
        this.fecha = fecha;
        this.serie = serie;
    }

    public Billete(
            String valor, int año, String lugar_emision, LocalDate fecha, String serie, String conservacion, float precio, String foto) {
        super(valor, año, lugar_emision, conservacion, precio, foto);
        this.fecha = fecha;
        this.serie = serie;
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

    public String getLugar_emision() {
        return lugar_emision;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getSerie() {
        return serie;
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
