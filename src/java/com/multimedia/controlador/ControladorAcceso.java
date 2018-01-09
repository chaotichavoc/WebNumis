/**
 * Gestiona la información procedente de los formularios de acceso y registro.
 */
package com.multimedia.controlador;

import com.multimedia.modelo.crud.CRUDAdministrador;
import com.multimedia.modelo.crud.CRUDCliente;
import com.multimedia.modelo.Cliente;
import com.multimedia.modelo.GestionBBDD;
import com.multimedia.modelo.Usuario;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Grupo11
 */
@WebServlet(name = "ControladorAcceso", urlPatterns = {"/ControladorAcceso"})
public class ControladorAcceso extends HttpServlet {

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GestionBBDD conexion = GestionBBDD.getInstance();
        conexion.establecerConexion();
        HttpSession session = request.getSession(true);
        String tipoAcceso = request.getParameter("llamada");

        switch (tipoAcceso) {
            case "registro": {//Solo los clientes se podran registrar desde aqui
                Cliente cliente = new Cliente(request.getParameter("nombre_usuario"),
                        request.getParameter("clave"),
                        request.getParameter("email"),
                        request.getParameter("nombre"),
                        request.getParameter("apellidos"),
                        request.getParameter("dni"),
                        request.getParameter("direccion_entrega"),
                        Integer.parseInt(request.getParameter("telefono")));

                CRUDAdministrador crudAdministrador = new CRUDAdministrador();

                if (!crudAdministrador.esUsuarioRegistrado(cliente.getNombre_usuario())) {//El usuario no existe en la tabla Administradores
                    CRUDCliente crudCliente = new CRUDCliente();
                    if (!crudCliente.esUsuarioRegistrado(cliente.getNombre_usuario())) {//El usuario no existe en la tabla Clientes
                        crudCliente.insertar(cliente);//El usuario no existe en la BBDD por lo que se puede registrar
                        response.sendRedirect("./VistaRegistroValido.jsp");
                    } else {//El usuario ya exite en la bbdd
                        System.out.println("EL USUARIO NO ES VALIDO");
                        response.sendRedirect("./VistaRegistro.jsp");//Se vuelven a pedir los datos
                    }
                }
                break;
            }
            case "acceso": {
                Usuario usuario = new Usuario(
                        request.getParameter("nombre_usuario"),
                        request.getParameter("clave"));

                CRUDAdministrador crudAdministrador = new CRUDAdministrador();

                if (crudAdministrador.inicioSesionValido(usuario)) {//Es un administrador
                    session.setAttribute("usuario", crudAdministrador.obtenerEspecifico(usuario.getNombre_usuario()));//Devuelve el objeto asociado al usuario
                    response.sendRedirect("./VistaPanelAdmin.jsp");
                } else {
                    CRUDCliente crudCliente = new CRUDCliente();
                    if (crudCliente.inicioSesionValido(usuario)) {//Es un cliente
                        session.setAttribute("usuario", crudCliente.obtenerEspecifico(usuario.getNombre_usuario()));
                        response.sendRedirect("./VistaPrincipal.jsp");
                    } else {//El usuario no existe
                        response.sendRedirect("./VistaInicioSesion.jsp");//Se vuelven a pedir los datos
                    }
                }
                break;
            }
            default:
                break;
        }
        conexion.cerrarConexion();
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }

    private void cerrarSesion(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
    }
}
