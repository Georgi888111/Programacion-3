<%-- 
    Document   : creaMatriz
    Created on : 21-ene-2020, 15:08:38
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <% int filas = Integer.parseInt(request.getParameter("filas")); %>
        <% int columnas = Integer.parseInt(request.getParameter("columnas")); %>
        <%
            out.print("<table border=2>");
            for (int i = 0; i < filas; i++) {
               out.print("<tr></tr>");
               for (int j = 0; j < columnas; j++) {
                 out.print("<td>" +(i+1)  + (j+1));
                 out.print("</td>");
                   }
                }
         %>
        </table>
    </body>
</html>
