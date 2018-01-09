<%@page import="com.multimedia.modelo.Usuario"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8"/>
    <title>Subastas</title>
    <link rel="stylesheet" href="./css/newstyles.css?v=1"/>
  </head>
<body>
    <div id="contenedor-index">
        <header>
            <div class="box"></div>
            <div class="logo"><img src="res/numi.png" height = "70"></div>
            <div class="social"><img src="res/UAH.png" height = "70"/></div>
        </header>
        <nav>
            <div class="nav-elemento">Inicio</div>
            <div class="nav-elemento">Subastas</div>
            <div class="nav-elemento">Contacto</div>
            <div class="nav-elemento">
                <%
                    Usuario usuario = (Usuario)session.getAttribute("usuario");
                    if(usuario == null){//Si el usuario no ha iniciado sesion se muestran los botones de inicio
                        out.println("<div class=\"login\"><a href=\"VistaInicioSesion.jsp\">Inicio de Sesion</a></div>");
                        out.println("<div class=\"login\"><a href=\"VistaRegistro.jsp\">Registrarse</a></div>");
                    }
                    else{//Si ha iniciado sesion se muestra su nombre
                        out.println("<i class=\"fa fa-user-circle-o\" aria-hidden=\"true\"></i>");
                        out.println("<div class=\"login\">" + usuario.getNombre_usuario() + "</div>");
                        out.println("<div class=\"login\"><a href=\""+request.getContextPath()+"/ControladorLogout\">Cerrar Sesión</a></div>");
                    }
                %>
            </div>
        </nav>
        <main>
            <section>
                <article class="bloque" id ="primero">   
                    <h3>MONEDA</h3>
                    <img src="./res/monedas.jpg" alt="monedas" width="200px" height="100px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat voluptatibus quo,
                        obcaecati corrupti sit quaerat iste! Eius eum assumenda ipsa natus minima asperiores, 
                        optio veritatis, ipsam obcaecati dolore nihil odit.
                    </p>
                </article>
                <article class="bloque" id ="segundo">
                    <h3>BILLETE</h3>
                    <img src="./res/billete.jpg" alt="billete" width="200px" height="100px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat voluptatibus quo,
                        obcaecati corrupti sit quaerat iste! Eius eum assumenda ipsa natus minima asperiores, 
                        optio veritatis, ipsam obcaecati dolore nihil odit.
                    </p>
                </article>
                <article class="bloque" id ="tercero">
                    <h3>SUBASTA</h3>
                    <img src="./res/subasta.png" alt="subasta" width="200px" height="100px">
                    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat voluptatibus quo,
                        obcaecati corrupti sit quaerat iste! Eius eum assumenda ipsa natus minima asperiores, 
                        optio veritatis, ipsam obcaecati dolore nihil odit.
                    </p>
                </article>   
            </section>
        </main>
        <footer>
            <h3>Esto es el footer</h3>
        </footer>
    </div>
</body>
</html>