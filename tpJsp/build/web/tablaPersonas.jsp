<%-- 
    Document   : tablaPersonas
    Created on : 10/10/2019, 11:26:46
    Author     : Georgi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Persona"%>
<%@page import="Controlador.ControladorPersona"%>
<%@page import="Data.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Personas</title>
    </head>
    <body>
        <form action="ControladorPersona">
            <table border="1">
                <thead>
                    <tr>
                        <th>Dni</th>
                        <th>Nombre</th>
                        <th>Domicilio</th>
                    </tr>
                </thead>
                <%
                ControladorPersona controlador = new ControladorPersona();
                ArrayList<Persona> personas = new ArrayList();
                personas = controlador.retornaPersonas();
                for (Persona p : personas) {
                    
                        
                    
                %>
                <tbody>
                    <tr>
                        <td><%= p.getDni()%></td>
                        <td><%= p.getNombre()%></td>
                        <td><%= p.getDomicilio()%></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

            
        </form>   
  
    </body>
</html>
