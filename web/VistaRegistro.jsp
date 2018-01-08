<%-- 
    Document   : VistaRegistro
    Created on : 06-ene-2018, 2:46:52
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Acceso a la plataforma</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="./css/newstyles.css?v=1">
</head>
<body>
     <div id="contenedor-index">
        <header>
            <div class="box"></div>
            <div class="logo"><img src="res/numi.png" height = "70"></div>
            <div class="social"><img src="res/UAH.png" height = "70"/></div>
        </header>
    <div class="contenedor-registro">
    <div class="registro">  
        <form action="ControladorAcceso" method="post" class ='formulario'>
            <h1>Registro de Usuario</h1>
            <input type="hidden" name="llamada" value="registro" class="registro-input">
            <input type="text" name="nombre_usuario" class="registro-input" placeholder="Nombre de usuario">
            <input type="password" name="clave" class="registro-input" placeholder="Contraseña">
            <input type="email" name="email" class="registro-input" placeholder="Correo electrónico">
            <input type="text" name="nombre" class="registro-input" placeholder="Nombre">
            <input type="text" name="apellidos" class="registro-input" placeholder="Apellidos">
            <input type="text" name="dni" class="registro-input" placeholder="DNI">
            <input type="text" name="direccion_entrega" class="registro-input" placeholder="Dirección">
            <input type="number" name="telefono" class="registro-input" placeholder="Teléfono">
            <input type="submit" value="Registrar" class="btn-input">
        </form>	
    </div>
        
    </div>
         <footer>
            <h3>Esto es el footer</h3>
        </footer>
    </div>
    
</body>
</html>
