<%-- 
    Document   : index
    Created on : 20-nov-2019, 15:35:32
    Author     : Georgi
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Provincia"%>
<%@page import="Controlador.Controlador"%>
<%@page import="Controlador.Controlador"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Global</title>
    </head>
    <body>
        <h1>Paises y provincias</h1>



        <select name="action" value="paises">
            <option value="Argentina" selected name="argentina">Argentina</option> 
            <option value="Brasil" name="brasil" >Brasil</option>
            <option value="Colombia" name = colombia>Colombia</option>
        </select>

        <%

            String valor = request.getParameter("paises");
            int idPais = Integer.parseInt(valor);
            Controlador controlador = new Controlador();
            ArrayList<Provincia> provincias = new ArrayList();
            provincias = controlador.retornaProvincias(idPais);


        %>

        <input type="submit" value="Enviar"/> 


    </body>
</html>
