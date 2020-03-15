<%-- 
    Document   : pagina2
    Created on : 06/10/2019, 14:15:35
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crea tabla</title>
    </head>
    <body>
    <table border = 3>

  

<%
int f = Integer.parseInt(request.getParameter("filas"));
int c = Integer.parseInt(request.getParameter("columnas"));

for (int i = 0; i < f; i++) {
 %>
 <tr></tr>
 <%
     for (int j = 0; j < c; j++) {

   %>  
   <td><%=i+1%>.<%=j+1%></td> 
   <%
}
   
    }
%>




          


</table> 
</body>
</html>
