<%-- 
    Document   : index
    Created on : 15-nov-2019, 13:56:23
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>Formulario</h1>
        <form  action="Controlador">
        Código del país <input type="text" name="codigo">
        <input type="submit" name="action" value = "Reporte Itext">
        <input type="submit" name="action" value = "Reporte POI">
        <input type="submit" name="action" value = "Reporte tcpdf">
        </form>
    </body>
</html>
