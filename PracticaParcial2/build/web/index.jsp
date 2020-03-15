<%-- 
    Document   : index
    Created on : 11/10/2019, 13:57:02
    Author     : Georgi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
         <link rel="stylesheet" href="estilo.css" type="text/css"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carga Usuario</title>
    </head>
    <body>
        <h1>Carga usuario</h1>
       <form action="ServletPersona" onsubmit=" return validaDatos(this)">
           
           <p style ="margin-left: 13px"><span class="tachado">Nombre:</span> <input type="text"  name ="name" ></p>
             <p style = "margin-left: 7px">Apellido <input type="text"  name ="apellido"></p>
               <p style = "margin-left: 7px">Usuario <input type="text"  name ="usu"></p>
                 <p style = "margin-left: 7px">Contraseña <input type="text"  name ="pass" id ="pass"></p>
                  <p style = "margin-left: 7px">Confirmar contraseña <input type="text"  name ="confimar" id ="confirmar"></p>
                  <input type="submit" name="agregarUsu" value = "Agregar">
       </form>
                  <script>
                      function validaDatos(f){
                       var ok;
                         var nombre = f.elements[0];
                           var apellido = f.elements[1];
                      var usuario = f.elements[2];
                       var contraseña = f.elements[3];
                       var contraseñaRepe = f.elements[4];
  var msg = "Las contraseñas no concuerdan";
  if(nombre.value===""||apellido.value===""||usuario.value===""||contraseña.value===""||contraseñaRepe===""){
      alert("Todos los campos deben estar llenos");
      ok=false;
  }else  if(contraseña.value!==contraseñaRepe.value){
      alert(msg);
      ok=false;
}else{
    alert("Persona agregada");
ok=true;
}
return ok;
                      }
                      </script>
          
    </body>
</html>
