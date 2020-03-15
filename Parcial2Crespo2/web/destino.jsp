<%-- 
    Document   : index
    Created on : 16/10/2019, 15:19:03
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Parcial</title>
    </head>
    <body>
        <h1>Valida datos recibidos</h1>
        <% String marca = request.getParameter("marca"); %>
        <% String modelo = request.getParameter("modelo"); %>
        <% String tamañoDisc = request.getParameter("tamDisc"); %>
        <% String ram = request.getParameter("ram"); %>
        <% String procesador = request.getParameter("procesador"); %>
        <% int numeroPuertos = Integer.parseInt(request.getParameter("num")); %>
        <% String sensor = request.getParameter("sensor"); %>
        <% String valida = request.getParameter("valida");%>


    </body>
</html>
