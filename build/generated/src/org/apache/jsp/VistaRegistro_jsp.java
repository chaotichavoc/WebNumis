package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VistaRegistro_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"es\">\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Acceso a la plataforma</title>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"./css/newstyles.css?v=1\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    <div class=\"contenedor-registro\">\r\n");
      out.write("    <div class=\"registro\">  \r\n");
      out.write("        <form action=\"ControladorAcceso\" method=\"post\" class ='formulario'>\r\n");
      out.write("            <h1>Registro de Usuario</h1>\r\n");
      out.write("            <input type=\"hidden\" name=\"llamada\" value=\"registro\" class=\"registro-input\">\r\n");
      out.write("            <input type=\"text\" name=\"nombre_usuario\" class=\"registro-input\" placeholder=\"Nombre de usuario\">\r\n");
      out.write("            <input type=\"password\" name=\"clave\" class=\"registro-input\" placeholder=\"Contraseña\">\r\n");
      out.write("            <input type=\"email\" name=\"email\" class=\"registro-input\" placeholder=\"Correo electrónico\">\r\n");
      out.write("            <input type=\"text\" name=\"nombre\" class=\"registro-input\" placeholder=\"Nombre\">\r\n");
      out.write("            <input type=\"text\" name=\"apellidos\" class=\"registro-input\" placeholder=\"Apellidos\">\r\n");
      out.write("            <input type=\"text\" name=\"dni\" class=\"registro-input\" placeholder=\"DNI\">\r\n");
      out.write("            <input type=\"text\" name=\"direccion_entrega\" class=\"registro-input\" placeholder=\"Dirección\">\r\n");
      out.write("            <input type=\"number\" name=\"telefono\" class=\"registro-input\" placeholder=\"Teléfono\">\r\n");
      out.write("            <input type=\"submit\" value=\"Registrar\" class=\"btn-input\">\r\n");
      out.write("        </form>\t\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
