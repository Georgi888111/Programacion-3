<%-- 
    Document   : index
    Created on : 19-nov-2019, 20:25:15
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
        <form action="Controlador">
        <table>
            <tr>
                <td>Legajo</td>
                <td><input type="number" name="lega"></td>
            </tr>   
            <tr>
                 <td>Nombre Completo</td>
                 <td><input type="text" name="nombre"></td>
            </tr>   
            <tr>
                 <td>Fecha de ingreso</td>
                 <td><input type="date" name="fecha"></td>
            </tr>   
            <tr>
                 <td>Nro recibo</td>
                <td><input type="number" name="nroRecibo"></td>
            </tr>   
            <tr>
                 <td>Mes</td>
                 <td><select name="selec meses">
                    <option value="Enero" selected>Enero</option> 
                    <option value="Febrero" >Febrero</option>
                    <option value="Marzo">Marzo</option>
                    <option value="Abril">Abril</option>
                    <option value="Mayo">Mayo</option>
                    <option value="Junio">Junio</option>
                    <option value="Julio">Julio</option>
                    <option value="Agosto">Agosto</option>
                    <option value="Septiembre">Septiembre</option>
                    <option value="Octubre">Octubre</option>
                    <option value="Noviembre">Noviembre</option>
                    <option value="Diciembre">Diciembre</option>
                </select></td>
            </tr>   
            <tr>
                 <td>Anio</td>
                <td><input type="number"></td>
            </tr>   
            <tr>
                 <td>Total</td>
                 <td><input type="number"></td>
            </tr>   
            <tr>
                <td><input type="button" value="Mostrar datos" onclick="validaFormulario()"></td>
                <td><input type="submit" value="Servlet" name="action"></td>  
          
            </tr>   
            </table>
            </form>
        
        <script>
            function validaFormulario(){
             alert("cosas");   
            }
        </script>
    </body>
</html>
