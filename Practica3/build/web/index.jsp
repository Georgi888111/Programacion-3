<%-- 
    Document   : index
    Created on : 25-may-2020, 15:50:16
    Author     : Georgi
--%>

<%@page import="Modelo.Provincia"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Pais"%>
<%@page import="Servidor.Servidor"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form name="form1" action="Servidor">
            <select name=paises id="paises" onchange="llenaProvincias()">
                <option value="0">Seleccione un pais</option>
                <%Servidor servidor = new Servidor();
                    ArrayList<Pais> paises = servidor.traePaises();
                    for (Pais pais : paises) {
                %>        
                <option value="<%=pais.getId()%>"><%=pais.getNombre()%></option>
                <%     } %>

            </select>
            <%

                ArrayList<Provincia> provincias = (ArrayList<Provincia>) request.getAttribute("provincias");

            %>  
            <table border="2">
                <tr><td>Nombre</td></tr>
                <tr>
                    <%                if (provincias != null) {
                            for (Provincia prov : provincias) {
                    %> 
                    <td><%=prov.getNombre()%></td>
                    <%    }
               }%>


                </tr>
            </table>

            <select>
                <option value="0">Seleccione un mes</option>
                <option value="1">Enero</option>
                <option value="2">Febrero</option>
                <option value="3">Marzo</option>
                <option value="4">Abril</option>
                <option value="5">Mayo</option>
                <option value="6">Junio</option>
                <option value="7">Julio</option>
                <option value="8">Agosto</option>
                <option value="9">Septiembre</option>
                <option value="10">Octubre</option>
                <option value="11">Noviembre</option>
                <option value="12">Diciembre</option>

            </select>
               
               Ingrese año<input type="number" id="anio" min="4" max="4">
                Dias del mes<input type="number" id="mes">
                Dia<input type="number" id="dia">
                
                <button type="button" onclick="validaCampos()">GENERAR MES CALENDARIO</button>   
        </form>
    </body>

    
    <script>
        function llenaProvincias(){
         document.forms["form1"].submit();
        }
        
        function validaCampos(){
          //  var anio = document.getElementById('anio');
           // var mes = document.getElementById("mes");
            //var dia = document.getElementById("dia");
          
         //   if((!Number.isInteger(parseInt(anio.value)))||(anio.length!=4)||(anio.value=='')){
             //   console.log(anio.length);
                
              //alert('Verifique que el campo del año esta con los datos correctos');
            //}else{
                //if(((parseInt(mes.value))<28)||((parseInt(mes.value))>31||mes.value=='')){
                    //alert('Verifique que la cantidad de días del mes es la correcta');
                //}else{
                    //if((parseInt(dia.value)>7)||(parseInt(dia.value<1))||dia.value==''){
                        //alert('Verifique que ingreso bien el día de la semana')
                    //}else{
                           document.forms["form1"].submit();
                    //}
               // }
            //}
            
        }
    </script>
</html>
