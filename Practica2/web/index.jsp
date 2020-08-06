<%-- 
    Document   : index
    Created on : 25-may-2020, 12:50:39
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
        <button onclick="juego()">Jugar</button>
    </body>
    <script>
        
        function juego(){
       var aleatorio = Math.floor(Math.random() * 100);
       console.log(aleatorio);
       while(true){
       var ingresoUsuario = window.prompt('Ingrese un número');
       if(ingresoUsuario ==aleatorio){
           alert("Numero encontrado");
          var opcion = confirm("Desea volver a jugar?");
           if(opcion==true){
             juego();  
           }else{
            
                 alert("Gracias por jugar");
                 window.location.reload();
                 break;
                 
           }
           
       }else{
         if(ingresoUsuario==false){
                  alert("Gracias por jugar");
                window.location.reload();
            }else{
            alert("El número es incorrecto, vuelva a intentarlo") ;
         
         
     
       
        }
    }
        }
    }
    </script>
</html>
