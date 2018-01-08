<%-- 
Página donde el administrador del sistema puede interactuar con la BBDD y dar de
alta o baja diferentes pujas así como obtener informes sobre estas.
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="Página de subastas - Práctica final Multimedia" content="">
    <meta name="Grupo11" content="">
    <link rel="icon" href="#"><!-- Favicon -->
    <link href="/css/styles.css" rel="stylesheet">
    <title>Subastas</title>
</head>
<body>
    <h1>Panel de Administración</h1>
    <form action="ControladorAcceso" method="post">
        <h1>Acceso de usuario</h1>
        <input type="hidden" name="llamada" value="acceso" class="registro-input">
        <input type="text" name="nombre_usuario" class="registro-input" placeholder="Nombre de usuario">
        <input type="password" name="clave" class="registro-input" placeholder="Contraseña">
        <input type="submit" value="Acceder" class="btn-input">
        <select id="gestion">
            <option value="0">Usuarios</option>
            <option value="1">Monedas</option>
            <option value="2">Billetes</option>
            <option value="3">Subastas</option>
        </select>
    </form>	
</body>
</html>
