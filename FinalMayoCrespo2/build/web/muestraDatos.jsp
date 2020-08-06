<%-- 
    Document   : muestraDatos
    Created on : 26-may-2020, 17:16:26
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
           <table border="1">
                <tr>
                    <td>Legajo</td> 
                       <td><%=request.getParameter("legajo")%></td> 
                </tr>
                  <tr>
                    <td>Nombre empleado</td> 
                    <td><%=request.getParameter("nombre")%></td> 
                </tr>
                  <tr>
                    <td>Numero de bono</td> 
                    <td><%=request.getParameter("numero")%></td> 
                </tr>
                  <tr>
                    <td>Mes</td> 
                            <td>
                 <%=request.getParameter("meses")%>
                            </td> 
                </tr>
                  <tr>
                    <td>Año</td> 
                       <td><%=request.getParameter("anio")%></td> 
                </tr> 
                <tr>
                    <td>Total</td> 
                       <td><%=request.getParameter("total")%></td> 
                </tr>
                
                
            </table><table>
       
    </body>
</html>
