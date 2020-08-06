<%-- 
    Document   : persona
    Created on : 21-ene-2020, 15:39:34
    Author     : Georgi
--%>

<%@page import="Modelo.Persona"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
        <form method="POST">
            <div>
                DNI<input type="text" name="dni" value="" />
            </div>
            <div>
                Nombre<input type="text" name="nombre" value="" />
            </div>
            <div>
                Domicilio<input type="text" name="domicilio" value="" />
            </div>
            <input type="submit" value="Guardar" name="btnGuardar" />
            <input type="submit" value="Mostrar" name="btnMuestra" />
            <% 
                
           String valueBoton = (String)request.getParameter("submit");
             
          if(valueBoton!=null){    
          if(valueBoton.equals("Guardar")){
              
               Persona persona = new Persona();
               persona.conectaPersona();
               int dni = Integer.parseInt(request.getParameter("dni"));
               String nombre = request.getParameter("nombre");
               String domicilio =  request.getParameter("domicilio");
               persona.setDni(dni);
               persona.setNombre(nombre);
               persona.setDomicilio(domicilio);
               persona.agregaPersona(persona);
               
            }
          }  
            
            %>
        </form> 
    </body>
</html>
