<%-- 
    Document   : index
    Created on : 22-may-2020, 11:58:21
    Author     : Georgi
--%>

<%@page import="Modelo.Alumno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Catedra"%>
<%@page import="Servidor.Servidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica 1</title>
    </head>
   
    <body>
        <form name="form1" action="Servidor" >
            <select name=catedra id="catedra" onchange="llenaTabla()">
           <option value="0">Seleccione una materia</option>    
        <%
            Servidor servidor = new Servidor();
            ArrayList<Catedra> catedras = servidor.cargaCatedras(); 
              
            for (Catedra cate : catedras) {%>
          
            <option value="<%=cate.getCodigo() %>">
                    <%=cate.getDenominacion()%>
                </option>
            
    <% }
 

    %>
    
</select>  
  <%

                
                ArrayList<Alumno> alumnoString = (ArrayList<Alumno>) request.getAttribute("alumnos");
            
    %>  
<table border="1" name>
    <tr>
    <td>Nombre</td>
     <td>Apellido</td>
      <td>Legajo</td>
    </tr> 
 
        <%
     
            if(alumnoString!=null){
                for (Alumno alu : alumnoString) {
                %>   
               <tr>
             <td><%=alu.getNombre()%></td>
                <td><%=alu.getApellido()%></td>
                   <td><%=alu.getLegajo()%></td>
            </tr>
                <%}

                    }

                %>  
              
</table>
</form>
<script>
            function llenaTabla() {
                document.forms["form1"].submit();
            }
             function enviar() {

                var list = document.getElementById("catedras");
                var item = list.options[list.selectedIndex].value;
                window.location.replace("index.jsp?item=" + item);
            <%              String item = "";
                if (request.getParameter("catedra") != null) {
                    item = request.getParameter("catedra");
                }
                session.setAttribute("catedra", item);
            %>
            }
         
        </script>  
    </body>
</html>
