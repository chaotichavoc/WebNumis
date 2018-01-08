/**
 * Gestiona la conexón y cierre de la BBDD.
 */
package com.multimedia.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo11
 */
public class GestionBBDD {

    private final String driver;
    private final String dbRuta;
    private final String dbExistente;
    private final String urlConexion;
    private Connection conexion;

    /**
     * Establece la conexión con la base de datos
     */
    public GestionBBDD() {
        driver = "org.apache.derby.jdbc.EmbeddedDriver";
        dbRuta = "/BDPRAC/F1DB";
        dbExistente = "create=true"; //la base de datos se creará si no existe todavía
        urlConexion = "jdbc:derby:" + dbRuta + ";" + dbExistente;
    }

    public void establecerConexion() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(urlConexion);
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("ERROR AL REALIZAR LA CONEXION CON LA BBDD");
            System.out.println(ex.getMessage());
        }
    }
    public void crearBaseDatos() {

        Statement st = null;
        try {
            st = conexion.createStatement();

            String crearTablaClientes = "CREATE TABLE CLIENTES ("
                    + "nombre_usuario Varchar(25) NOT NULL CONSTRAINT clientes_pk PRIMARY KEY,"
                    + "clave Varchar(25) NOT NULL,"
                    + "email Varchar(25) NOT NULL,"
                    + "nombre Varchar(25) NOT NULL,"
                    + "apellidos Varchar(25) NOT NULL,"
                    + "dni Varchar(9) NOT NULL UNIQUE,"
                    + "direccion_entrega Varchar(25) NOT NULL,"
                    + "telefono Integer NOT NULL"+ ")";

            String crearTablaBilletes = "Create table Billetes ("
                    + "lote Integer NOT NULL CONSTRAINT billetes_pk PRIMARY KEY,"
                    + "fecha Varchar(6) NOT NULL,"
                    + "serie Varchar(25) NOT NULL"+ ")";

            String crearTablaMonedas = "Create table Monedas ("
                    + "lote Integer NOT NULL CONSTRAINT monedas_pk PRIMARY KEY,"
                    + "estrellas Varchar(5) NOT NULL"+ ")";
            String crearTablaArticulos = "Create table Articulos ("
                    +"lote Integer NOT NULL CONSTRAINT articulos_pk PRIMARY KEY,"
                    +"valor Numeric(12,2) NOT NULL,"
                    +"anio Varchar(4) NOT NULL,"
                    +"lugar_emision Varchar(20) NOT NULL,"
                    +"conservacion Varchar(5) NOT NULL,"
                    +"precio Numeric(7,2) NOT NULL,"
                    +"foto Varchar(35) NOT NULL"
                    +")";            
            String crearTablaAdministradores = "Create table Administradores ("
                    + "nombre_usuario Varchar(25) NOT NULL CONSTRAINT administradores_pk PRIMARY KEY,"
                    + "clave Varchar(25) NOT NULL,"
                    + "email Varchar(25) NOT NULL,"
                    +"nivel_permisos Integer NOT NULL"
                    + ")";        
           
                st.execute(crearTablaClientes);          
                st.execute(crearTablaBilletes);          
                st.execute(crearTablaMonedas);        
                st.execute(crearTablaArticulos);
                st.execute(crearTablaAdministradores); 
                st.close();
                
            } catch (SQLException ex) {
        }
        }
    

    public Connection getConexion() {
        return conexion;
    }

    /**
     * Cierra la conexión con la base de datos
     */
    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
