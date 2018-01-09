/**
 * Acciones CRUD en relación a un Billete.
 */
package com.multimedia.modelo.crud;

import com.multimedia.modelo.Articulo;
import com.multimedia.modelo.Billete;
import com.multimedia.modelo.FormateaFecha;
import com.multimedia.modelo.GestionBBDD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo 11
 */
public class CRUDBillete implements ICRUDGeneral<Articulo> {

    private final Connection conexion;
    private GestionBBDD gestion;

    public CRUDBillete() {
        gestion = GestionBBDD.getInstance();
        this.conexion = gestion.getConexion();
    }

    /*
    CAMPOS DE LA TABLA(Lote, valor, año, lugar de emisión, fecha, serie, conservación, precio, <<foto>>)
     */
    @Override
    public void insertar(Articulo articulo) {
        //Cast, solo entrarán billetes
        Billete billete = (Billete) articulo;
        String consulta = "INSERT INTO Billetes(valor, anio, lugar_emision, fecha, serie, conservacion, precio, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, billete.getValor());
            ps.setInt(2, billete.getAño());
            ps.setString(3, billete.getLugar_emision());
            ps.setDate(4, FormateaFecha.comoDate(billete.getFecha()));
            ps.setString(5, billete.getSerie());
            ps.setString(6, billete.getConservacion());
            ps.setFloat(7, billete.getPrecio());
            ps.setString(8, billete.getFoto());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al insertar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public void eliminar(String lote) {
        String consulta = "DELETE FROM Billetes WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al eliminar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public void actualizar(Articulo articulo) {
        Billete billete = (Billete) articulo;
        String consulta = "UPDATE Billetes SET valor = ?, anio = ?, lugar_emision = ?, fecha = ?, serie = ?, conservacion = ?, precio = ?, foto = ? WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setString(1, billete.getValor());
            ps.setInt(2, billete.getAño());
            ps.setString(3, billete.getLugar_emision());
            ps.setDate(4, FormateaFecha.comoDate(billete.getFecha()));
            ps.setString(5, billete.getSerie());
            ps.setString(6, billete.getConservacion());
            ps.setFloat(7, billete.getPrecio());
            ps.setString(8, billete.getFoto());
            ps.setInt(9, billete.getLote());//Lote especificado
            ps.executeUpdate();//Envia la consulta a la bbdd
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al actualizar un registro de la tabla BILLETES", ex);
        }
    }

    @Override
    public Articulo obtenerEspecifico(String lote) {
        Billete billete = null;
        String consulta = "SELECT * FROM Billetes WHERE lote = ?";
        try (PreparedStatement ps = conexion.prepareStatement(consulta)) {
            ps.setInt(1, Integer.parseInt(lote));
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    billete = formatearResultado(rs);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener un registro de la tabla BILLETES", ex);
        }
        return billete;
    }

    @Override
    public List<Articulo> obtenerTodos() {
        ArrayList<Articulo> listaBilletes = null;
        String consulta = "SELECT * FROM Billetes";
        try (PreparedStatement ps = conexion.prepareStatement(consulta);
                ResultSet rs = ps.executeQuery()) {
            listaBilletes = new ArrayList<>();
            while (rs.next()) {
                listaBilletes.add(formatearResultado(rs));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "Error al obtener todos los registros de la tabla BILLETES", ex);
        }
        return listaBilletes;
    }

    /**
     * Genera un objeto procedente de los datos que devuelve la BBDD.
     *
     * @param rs ResultSet con los datos.
     * @return Objeto que contiene los datos.
     */
    @Override
    public Billete formatearResultado(ResultSet rs) {
        Billete billete = null;
        try {
            billete = new Billete(
                    rs.getInt("lote"),
                    rs.getString("valor"),
                    rs.getInt("anio"),
                    rs.getString("lugar_emision"),
                    FormateaFecha.comoLocalDate(rs.getDate("fecha")),
                    rs.getString("serie"),
                    rs.getString("conservacion"),
                    rs.getFloat("precio"),
                    rs.getString("foto"));
        } catch (SQLException ex) {
            Logger.getLogger(CRUDBillete.class.getName()).log(Level.SEVERE, "No se ha podido formatear la información procedente de la tabla BILLETES", ex);
        }
        return billete;
    }
}
