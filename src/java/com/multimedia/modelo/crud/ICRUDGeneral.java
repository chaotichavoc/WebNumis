/**
 * Interface de las acciones CRUD.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.ExceptionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Grupo 11
 * @param <T> Tipo de dato que recibe
 */
public abstract interface ICRUDGeneral<T> {

    void insertar(T obj) throws ExceptionManager;

    void eliminar(String id) throws ExceptionManager;

    void actualizar(T obj) throws ExceptionManager;
    
    T obtenerEspecifico(String id) throws ExceptionManager;
    
    List<T> obtenerTodos() throws ExceptionManager;

    T formatearResultado(ResultSet rs) throws SQLException;
}
