<%-- 
    Document   : destino
    Created on : 03-mar-2020, 16:51:57
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Destino</title>
    </head>
    <body>
           
        <% String letra =request.getParameter("letra");
        String numero = request.getParameter("numero");
        String tipo = request.getParameter("tipo");
        String descripcion= request.getParameter("descripcion");
        String ambito = request.getParameter("ambitoRadio");
        
        %>
        <label>Letra: <%=letra %></label>
        <label>Numero: <%=numero %></label>
         <label>Tipo: <%=tipo %></label>
         <label>Descripcion:<%=descripcion %></label>
         <label>Ambito:<%=ambito %> </label>
 
        
        
       
        
    </body>
</html>
