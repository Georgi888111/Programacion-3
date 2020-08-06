<%-- 
    Document   : index
    Created on : 26-feb-2020, 19:09:06
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Practica Final Febrero 2020</title>
    </head>
    <body>
        <form method="POST"  action="destino.jsp">
            <table>
                <tr>
                    <td>Letra</td>
                    <td>
                        <input type="text" name="letra" value=""id="letra">
                    </td>
                </tr>
                <tr>
                    <td>Numero</td>
                    <td>
                        <input type="number" name="numero" value="" id="numero">
                    </td>
                </tr>
                <tr>
                    <td>Tipo</td>
                    <td>
                        <select name="tipo">
                            <option value="E">E</option>
                            <option value="N">N</option>
                            <option value="M">M</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Descripcion</td>
                    <td>
                        <textarea name="descripcion" rows="4" cols="20" id="descripcion">
                        </textarea>
                    </td>
                </tr>
                <tr>

                    <td>Ambito</td>
                    <td>
                        N<input type="radio" name="ambitoRadio" value="N" checked="checked" />
                        P<input type="radio" name="ambitoRadio" value="P"/> 
                        M<input type="radio" name="ambitoRadio" value="M" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="submit" value="JSP">
                        <input type="button" value="JavaScript" onclick="validaDatos()">
                    </td>
                </tr>
            </table>

        </form> 
        <script>
            function validaDatos() {
                var letra = document.getElementById('letra');
                var numero = document.getElementById('numero');
                var descripcion = document.getElementById('descripcion');

                if (letra.value == '' || numero.value == '' || descripcion.value == '') {
                    alert("Verifique que lleno los campos letra, numero y descripcion");
                }else{
                    alert("Letra " +letra.value + ", Numero: " + numero.value + ",Descripcion: " + descripcion.value)
                }
                
                if(numero.value != '' &&  isNaN(parseInt(numero.value))){
                    alert("El dato ingresado no es un numero o verifique que lo cargo correctamente");
                }

            }
        </script>
    </body>
</html>
