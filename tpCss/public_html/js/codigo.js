//punto 1
//Metodo que se invoca y muestra dos mensajes
function primerMensaje(){
alert("Hola Mundo!");
alert("Soy el primer script");
}


function primerMensaje2(){
    var mensaje=alert("Hola Mundo!") + alert("Soy el primer script");
}
//punto 2
function muestraMeses(){
    var meses = ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'];
    for(var i =0;i<meses.length;i++){
        alert(meses[i]);
    }
}
    //punto 3
function numeros(){
 var numero_1 = 5;
var numero_2 = 8;
if(numero_1<numero_2) {
alert("numero1 no es mayor que numero2");
}
if(numero_2>=0) {
alert("numero2 es positivo");
}
if(numero_1<0||numero_1!==0) {
alert("numero1 es negativo o distinto de cero");
}
if(!((numero_1+1)>=numero_2)) {
alert("Incrementar en 1 unidad el valor de numero1 no lo hace mayor o igual que numero2");
}
    }
   
   
  
    
function enviar(){
    var nombre = document.getElementById("nombre").value;
    var apell1 = document.getElementById("apell1").value;
    var apell2 = document.getElementById("apell2").value;
    var tel = document.getElementById("tel").value;
    var mail = document.getElementById("mail").value;
    var tipoTarj = document.getElementById("tipoTarj");
        var opcionTarj = tipoTarj.options[tipoTarj.selectedIndex].value;
    var numTarj = document.getElementById("numTarj").value;
    var usuario = document.getElementById("usuario").value;
    var cont = document.getElementById("cont").value;
    var c_cont = document.getElementById("c_cont").value;
    if(validarMail(mail) && validaConn(cont,c_cont)){
        alert("Nombre: "+nombre+" "+ apell1+" "+apell2+". Telefono: "+tel+". Mail: "+mail+". Tipo tarjeta: "+opcionTarj+" N tarjeta: "+numTarj+". Usuario: "+usuario+". ContraseÃ±a: "+cont);
    }

}

function validarMail(mail) {
    
   var arreglo = mail.split("");
    arreglo.reverse();

    if (arreglo[0] === 'm' && arreglo[1] === 'o' && arreglo[2] === 'c') {
        return true;
    } else {
        alert('La direcciÃ³n de correo ingresada es invÃ¡lida');
        return false;
    }
}

function validaConn(clave,verifica){
    if(clave==verifica){
        return true;
    }else{
        alert('Contrasenia invÃ¡lida');
        return false;
    }
}
    
 function Suma() {
    var primervalor;
    var segundovalor;
    var retornarresultado; 
          
           
   }

function sumar(){
    var s=new Suma();
    s.primervalor=10;
    s.segundovalor=20;
    s.retornarresultado = s.primervalor + s.segundovalor;
    document.write('La suma de los dos valores es '+s.retornarresultado);
    
    }
    
    window.onload= function texto(){
    var numAleatorio= new Array(10);

    
   for(var i=0;i<10;i++){
        numAleatorio[i]=parseInt(Math.random()*500)+1;
        
    }

    var menores= [];
    var mayores= [];
    for(var i=0;i<10;i++){
        if(numAleatorio[i]<250){
            menores.push(numAleatorio[i]);
        }else{
            mayores.push(numAleatorio[i]);
        }
    }
    document.write("Tamanio vector menores a 250: "+menores.length+". Tamanio vector mayores a 250: "+mayores.length+". ");
    document.write("Vector original: ");
    for(var i=0;i<10;i++){
        document.write(numAleatorio[i]+" ");
    }
    document.write("Segundo vector: ");
    for(var i=0;i<menores.length;i++){
        document.write(menores[i]+" ");
    }

    document.write("Tercer vector: ");
    for(var i=0;i<mayores.length;i++){
        document.write(mayores[i]+" ");
    }
}

window.addEventListener('load',inicializarEventos,false);
function inicializarEventos(){
    var ob=document.getElementById('numero');
    ob.addEventListener('click',duplicar,false);
}

function duplicar(e){
    var numero=document.getElementById("numero").innerHTML;
    document.getElementById("numero").innerHTML = numero*2;
    
      
}

    
    