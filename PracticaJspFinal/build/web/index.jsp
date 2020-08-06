<%-- 
    Document   : index
    Created on : 21-ene-2020, 14:58:07
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="creaMatriz.jsp">
            <div>
            Filas <input type="number" name="filas" id="fila"/>
            </div>
             <div>
            Columnas <input type="number" name="columnas"  id="columna" />
            </div>
            <input type="submit" value="Enviar" name="enviar" />
        </form>
    </body>
</html>
