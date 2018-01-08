
package com.multimedia.modelo.crud;

import com.multimedia.modelo.ExceptionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Grupo11
 */
public class CRUDSubasta implements ICRUDGeneral{

    @Override
    public void insertar(Object obj) throws ExceptionManager {
    }

    @Override
    public void eliminar(String id) throws ExceptionManager {
    }

    @Override
    public void actualizar(Object obj) throws ExceptionManager {
    }

    @Override
    public Object obtenerEspecifico(String id) throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List obtenerTodos() throws ExceptionManager {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object formatearResultado(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
