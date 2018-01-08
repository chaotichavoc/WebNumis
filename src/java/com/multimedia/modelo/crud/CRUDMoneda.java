/**
 * Acciones CRUD en relación a una Moneda.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Articulo;
import com.multimedia.modelo.GestionBBDD;
import com.multimedia.modelo.Moneda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo11
 */
//monedas(Lote, valor, año, estrellas, lugar de emisión, conservación, precio, <<foto>>)
public class CRUDMoneda implements ICRUDGeneral<Articulo> {

    private final Connection conexion;

    public CRUDMoneda(GestionBBDD gestion) {
        this.conexion = gestion.getConexion();
    }

    @Override
    public void insertar(Articulo articulo) {
        Moneda moneda = (Moneda) articulo;
        String consulta = "INSERT INTO Monedas(valor, anio, estrellas, lugar_emision, conservacion, precio, foto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, moneda.getValor());
            ps.setInt(2, moneda.getAño());
            ps.setString(3, moneda.getEstrellas());
            ps.setString(4, moneda.getLugar_emision());
            ps.setString(5, moneda.getConservacion());
            ps.setFloat(6, moneda.getPrecio());
            ps.setString(7, moneda.getFoto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public void eliminar(String lote) {
        String consulta = "DELETE FROM Monedas WHERE lote = ?";//Genera la consulta
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public void actualizar(Articulo articulo) {
        Moneda moneda = (Moneda) articulo;
        String consulta = "UPDATE Monedas SET valor = ?, anio = ?, estrellas = ?, lugar_emision = ?, conservacion = ?, precio = ?, foto = ? WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, moneda.getValor());
            ps.setInt(2, moneda.getAño());
            ps.setString(3, moneda.getEstrellas());
            ps.setString(4, moneda.getLugar_emision());
            ps.setString(5, moneda.getConservacion());
            ps.setFloat(6, moneda.getPrecio());
            ps.setString(7, moneda.getFoto());
            ps.setInt(8, moneda.getLote());//Lote especificado
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla MONEDAS", ex);
        }
    }

    @Override
    public Articulo obtenerEspecifico(String lote) {
        Moneda moneda = null;
        String consulta = "SELECT * FROM Monedas WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    moneda = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla MONEDAS", ex);
        }
        return moneda;
    }

    @Override
    public ArrayList<Articulo> obtenerTodos() {
        ArrayList<Articulo> listaMonedas = null;
        String consulta = "SELECT * FROM Monedas";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaMonedas = new ArrayList<>();
            while (rs.next()) {
                listaMonedas.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla MONEDAS", ex);
        }
        return listaMonedas;
    }

    @Override
    public Moneda formatearResultado(ResultSet rs) {
        Moneda moneda = null;
        try {
            moneda = new Moneda(
                    rs.getInt("lote"),
                    rs.getString("valor"),
                    rs.getInt("anio"),
                    rs.getString("estrellas"),
                    rs.getString("lugar_emision"),
                    rs.getString("conservacion"),
                    rs.getFloat("precio"),
                    rs.getString("foto"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDMoneda.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla MONEDAS", ex);
        }
        return moneda;
    }
}
