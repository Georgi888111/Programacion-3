<%-- 
    Document   : index
    Created on : 26-may-2020, 11:29:42
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
        <form action="Servidor" method="post" onsubmit="return validaCampos()" name="form1" id="form1">
            <table>
                <tr>
                    <td>  Nombre</td>
                      <td>  <input type="text" name="nombre" id="nombre">  </td>
                </tr>
                <tr>
                    <td> Apellido  </td>
                      <td><input type="text" name="apellido" id="apellido"></td>
                </tr>
                  <tr>
                    <td>   Telefono  </td>
                      <td>     <input type="number" name="telefono" id="telefono"></td>
                </tr>
                
                 <tr>
                    <td>   Estado Civil  </td>
                    <td><select name="civil" onchange="borraHijos(this.value)">
                <option value="0">Seleccione una opcion</option> 
                 <option value="Soltera">Soltera</option> 
                 <option value="Casada">Casada</option> 
                 </select> 
                        <input type="checkbox" name="hijos" value="hijos" id="hijos"><label id="labelHijos">Hijos</label><br>
                   <input type="checkbox" name="cantidad" value="cantidad" id="cantidad"><label id="labelCantidad">Cantidad</label><br>
                      </td>
                </tr>
                
                  <tr>
                    <td>    <input type="button" value="creaTablaLista"onclick="creaListaTabla()"></td>
                      <td>  <input type="submit" value="Enviar datos"></td>
                </tr>
            </table>
        
           
     
             
        
          
           
            <table id="datos" border="2">
                
            </table>
            <ul id="datosLista">
 
           </ul>
        </form>
    </body>
    
    <script>
        function validaCampos(){
            var nombre = document.getElementById('nombre');
            var apellido = document.getElementById('apellido');
            var telefono = document.getElementById('telefono');
            var contador =0;
            if(nombre.value ==''||apellido.value==''||telefono.value==''){
                alert('Verifique que lleno todos los campos');
                contador++;
            }else{
                if((isNaN(telefono.value))||( !(/^\d{9}$/.test(telefono.value)))){
                    alert('verifique que su telefono esta ingresado correctamente');
                    contador++;
                }
            }
            
            if(contador>0){
                return false;
            }else{
                return true;
            }
        }
        
        function creaListaTabla(){
            var nombre = document.getElementById('nombre');
            var apellido = document.getElementById('apellido');
            var telefono = document.getElementById('telefono');  
            var tabla = document.getElementById('datos');
            
            var fila1 = document.createElement("tr");
            var fila2 = document.createElement("tr");
           
        
            var celda = document.createElement("td");
            var textoCelda = document.createTextNode("Nombre");
            celda.appendChild(textoCelda);
            fila1.appendChild(celda);
            
             var celda = document.createElement("td");
            var textoCelda = document.createTextNode("Apellido");
            celda.appendChild(textoCelda);
            fila1.appendChild(celda);
            
            var celda = document.createElement("td");
            var textoCelda = document.createTextNode("Telefono");
            celda.appendChild(textoCelda);
            fila1.appendChild(celda);

             var celda = document.createElement("td");
            var textoCelda = document.createTextNode(nombre.value);
            celda.appendChild(textoCelda);
            fila2.appendChild(celda);
            
             var celda = document.createElement("td");
            var textoCelda = document.createTextNode(apellido.value);
            celda.appendChild(textoCelda);
            fila2.appendChild(celda);
            
            var celda = document.createElement("td");
            var textoCelda = document.createTextNode(telefono.value);
            celda.appendChild(textoCelda);
            fila2.appendChild(celda);
      
            
              tabla.appendChild(fila1);
              tabla.appendChild(fila2);
             
              var datosLista = document.getElementById('datosLista');
              var liNombre = document.createElement("li");
              liNombre.appendChild(document.createTextNode(nombre.value));
             datosLista.appendChild(liNombre);
             var liApellido = document.createElement("li");
              liApellido.appendChild(document.createTextNode(apellido.value));
             datosLista.appendChild(liApellido);
              var liTel = document.createElement("li");
              liTel.appendChild(document.createTextNode(telefono.value));
             datosLista.appendChild(liTel);
        }
        
        function borraHijos(sel){
             if (sel == 'Casada')
                {
                    document.getElementById('hijos').disabled=true;
                    document.getElementById('cantidad').disabled=true;
                    document.getElementById('labelHijos').innerText = "";
                    document.getElementById('labelCantidad').innerText = "";
        }else{
                   document.getElementById('hijos').disabled=false;
                    document.getElementById('cantidad').disabled=false;
                     document.getElementById('labelHijos').innerText = "Tiene hijos";
                    document.getElementById('labelCantidad').innerText = "Cantidad";
        }
        
        
    }
    </script>
</html>
