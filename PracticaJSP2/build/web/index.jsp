<%-- 
    Document   : index
    Created on : 18-mar-2020, 19:43:18
    Author     : Georgi
--%>

<%@page import="Modelo.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Pais"%>
<%@page import="Data.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" action="index.jsp">
            
            <select name="pais" onchange="enviaDatos()">
            <option value="0">Seleccione un pais</option>  
            <%
                Conexion conexion = new Conexion();
                conexion.estableceConexion();
                ArrayList<Pais> paises = new ArrayList();
                paises = conexion.traePaises();

                for (Pais p : paises) {


            %>
            <option value="<%=String.valueOf(p.getId())%>"><%=p.getNombre()%></option> 


            <%}%>
        </select>
        
        <select name="provincia">
            
              <option value="0">Seleccione una provincia</option>  
              
            <% String nombrePais = request.getParameter("pais");
            if(nombrePais!=null){
     
            ArrayList<Provincia> provincias = new ArrayList();    
           provincias = conexion.traeProvincias(nombrePais);
           for (Provincia prov : provincias) {
               
               %>
            <option value="<%=String.valueOf(prov.getId())%>"><%=prov.getNombre()%></option>      
               
               
           <% }   
           }  %>
          
         
        </select>
           </form>
           <script>
               function enviaDatos(){
                document.forms["form1"].submit();    
               }
           </script>  
    </body>
</html>
