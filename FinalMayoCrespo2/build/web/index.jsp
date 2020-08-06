<%-- 
    Document   : index
    Created on : 26-may-2020, 16:45:27
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
        <form action="http://localhost:8080/FinalMayoCrespo2/muestraDatos.jsp" onsubmit="return validaDatos()" method="post">
            <table border="1">
                <tr>
                    <td>Legajo</td> 
                       <td><input type="text" name="legajo" id="legajo"></td> 
                </tr>
                  <tr>
                    <td>Nombre empleado</td> 
                    <td><input type="text" name="nombre" id="nombre"></td> 
                </tr>
                  <tr>
                    <td>Numero de bono</td> 
                    <td><input type="number" name="numero" id="numero"></td> 
                </tr>
                  <tr>
                    <td>Mes</td> 
                            <td>
                        <select name="meses">
                            <option value="Enero">Enero</option>
                             <option value="Febrero">Febrero</option>
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
                        </select>
                            </td> 
                </tr>
                  <tr>
                    <td>Año</td> 
                       <td><input type="number" name="anio" id="anio"></td> 
                </tr> 
                <tr>
                    <td>Total</td> 
                       <td><input type="number" name="total" id="total"></td> 
                </tr>
                
                
            </table>
            <input type="submit" value="Enviar Datos">
        </form>
    </body>
    
    <script>
        function validaDatos(){
            var contador =0;
          var legajo = document.getElementById('legajo');
          var nombre = document.getElementById('nombre');
           var numero = document.getElementById('numero');
             var año = document.getElementById('año');
               var total = document.getElementById('total');
               
               if(legajo.value==''||nombre.value==''||numero.value==''||año.value==''||total.value==''){
                   alert('Debe llenar todos los campos');
                   contador++;
               }else{
                   if(isNaN(numero.value)||isNaN(año.value)||isNaN(total.value)){
                     alert("Verifique que haya ingresado números donde corresponda");
                     contador++;
                   }
               }
               
               if(contador>0){
                   return false;
               }else{
                   return true;
               }
        }
    </script>
</html>
