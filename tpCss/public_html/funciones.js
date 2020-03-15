

function cambiarTamanoFuenteChica()
{
var parrafo=document.getElementById('miparrafo');
parrafo.style.fontSize="10px";
}


function cambiarTamanoFuenteMediana()
{
var parrafo=document.getElementById('miparrafo');
parrafo.style.fontSize="13px";
}

function cambiarTamanoFuenteGrande()
{
var parrafo=document.getElementById('miparrafo');
parrafo.style.fontSize="20px";
}

function cambiarTexto()
{

    var tit = document.getElementById('titulo');
    var valor = tit.childNodes[0].nodeValue;

    var parseado = parseInt(valor);

    parseado++;
    tit.childNodes[0].nodeValue = parseado;
}

function cambiarTamFuente(){
var puntero=document.getElementById('parrafo1');
var padre=puntero.parentNode;
padre.style.fontSize="40px";
}

function cambiarColor(){
 var lista=document.getElementsByTagName('p');
for(f=0;f<lista;f++)
{
lista[f].style.color = "blue";
}
}
var contador=1;
function mostrarSoluciones(){
    

while(contador<=2){
var nLi=document.getElementById('lista');    
var li = document.createElement("li");    
li.appendChild(document.createTextNode("Elemento" + contador));
 nLi.appendChild(li);

contador++;
}
}

function definirAtributo(){
var elemento=document.createElement('border');
var puntero=document.getElementById('tabla1');
puntero.appendChild(elemento);


puntero.setAttribute('border','5');
}



window.addEventListener('load',inicializarEventos,false);

function inicializarEventos()
{
var ob=document.getElementById('confirmar');
ob.addEventListener('click',validar,false);
}

function validar(e)
{
var usu=document.getElementById('usuario');
var error='';
if (usu.value==='')
{
error='Debe ingresar el nombre de usuario.';
}
var cla=document.getElementById('clave');
if (cla.value==='')
{
error=error+ ' Debe ingresar la clave.';
}
var clare = document.getElementById('claveRepe');
if(clare.value==='')
{
error=error+'  Debe ingresar la clave de confirmacion.';
}
if(cla.value!==clare.value){
 error=error+'  La clave ingresada no coincide con la confirmacion';   
} 
if (error!=='')
{
e.preventDefault();
var er=document.getElementById('error');
er.innerHTML=error;
er.style.display='block';
}
}



 

 

