<%-- 
    Document   : index
    Created on : 18-mar-2020, 16:51:31
    Author     : Georgi
--%>

<%@page import="Modelo.Alumno"%>
<%@page import="Modelo.Catedra"%>
<%@page import="Controlador.Servidor"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Data.Conexion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Catedras Alumnos</title>
    </head>
    <body>
        <form name="form1" action="Servidor">
            <select name="catedra" onchange="enviaDatos()">
                <option value="0" >Seleccione una catedra</option>   
                <%
                    Servidor servidor = new Servidor();
                    ArrayList<Catedra> catedras = new ArrayList();
                    catedras = servidor.traeCatedras();
                    for (Catedra c : catedras) {
                %>     

                <option value="<%=String.valueOf(c.getCodigo())%>"><%=c.getDenominacion()%></option> 

                <%  } %>

            </select> 

            <%
                ArrayList<Alumno> alumnoString = (ArrayList<Alumno>) request.getAttribute("alumnos");

            %>    




            <table name="alumnosCatedra">
                <tr>
                    <td>Legajo</td>    
                    <td>Nombre</td>    
                    <td>Apellido</td>    

                </tr>

                <%                  if (alumnoString != null) {
                        for (Alumno alu : alumnoString) {
                %><tr>
                    <td><%=alu.getLegajo()%></td>
                    <td><%=alu.getNombre()%></td>
                    <td><%=alu.getApellido()%></td>
                </tr>
                <%}
                    }

                %>  
                <tr>
                    <td><button type="submit" name="Itext">Itext</button></td>
                    <td><button type="submit" name="POI">POI</button></td>
                    <td><button type="submit" name="TcPDF">TcPDF</button></td>
                </tr>
            </table>



        </form>
        <script>
            function enviaDatos() {
                document.forms["form1"].submit();
            }
        </script>   

    </body>
</html>
