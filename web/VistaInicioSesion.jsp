
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
    <div class="contenedor-acceso">
        <div class="acceso">
            <form action="ControladorAcceso" method="post" class="formulario">
                <h1>Acceso de usuario</h1>
                <input type="hidden" name="llamada" value="acceso" class="registro-input">
                <input type="text" name="nombre_usuario" class="registro-input" placeholder="Nombre de usuario">
                <input type="password" name="clave" class="registro-input" placeholder="Contraseña">
                <input type="submit" value="Acceder" class="btn-input">
            </form>	
        </div>
    </div>
        <footer>
            <h3>Esto es el footer</h3>
        </footer>
    </div>
</body>
</html>
