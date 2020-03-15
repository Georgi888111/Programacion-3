<%-- 
    Document   : persona
    Created on : 09/10/2019, 19:00:16
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario Persona</title>
    </head>
    <body>
        <form action="ControladorPersona">
            <p style="margin-left: 40px">Dni: <input type="number"  name ="dni"  value ="dni"></p>
            <p style ="margin-left: 13px">Nombre: <input type="text"  name ="name" ></p>
             <p style = "margin-left: 7px">Domicilio <input type="text"  name ="address"></p>
             <input type="submit" name="action" value = "Agregar">
          
        </form>
    </body>
</html>
