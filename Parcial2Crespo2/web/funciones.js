/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 function agregarList() {
    var marca = document.getElementById("marca");
    var modelo = document.getElementById("modelo");
    var tamDisc = document.getElementById("tamDisc");
    var ram = document.getElementById("ram");
    var procesador = document.getElementById("procesador").getItem();
    var puertos = document.getElementsByName("num").getItem();
    var sensor = document.getElementById("sensor");
    var nLi = document.getElementById('lista');
    
    var liMarca = document.createElement("li");
    li.appendChild(document.createTextNode(marca.value));
    nLi.appendChild(liMarca);
    var liModelo = document.createElement("li");
    li.appendChild(document.createTextNode(modelo.value));
    nLi.appendChild(liModelo);
    var liTam = document.createElement("li");
    li.appendChild(document.createTextNode(tamDisc.value));
    nLi.appendChild(liTam);
    var liRam = document.createElement("li");
    li.appendChild(document.createTextNode(ram.value));
    nLi.appendChild(liRam);
    var liProc = document.createElement("li");
    li.appendChild(document.createTextNode(procesador.value));
    nLi.appendChild(liProc);
    var liPuer = document.createElement("li");
    li.appendChild(document.createTextNode(puertos.value));
    nLi.appendChild(liPuer);
    var lisen = document.createElement("li");
    li.appendChild(document.createTextNode(sensor.value));
    nLi.appendChild(lisen);





}

