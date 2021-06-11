var temporizadorId = setInterval(relogio,1000);

var elementoData = document.getElementById("data");
var elementoHora = document.getElementById("hora");

function relogio() {
    var d = new Date();

    var ano = d.getFullYear();
    var mes = d.getMonth() + 1;
    var dia = d.getDate();

    if (mes < 10)
        mes = "0" + mes;

    if (dia < 10)
        dia = "0" + dia;

    elementoData.innerText = dia + " / " + mes + " / " + ano;

    var horas = d.getHours();
    var minutos = d.getMinutes();
    var segundos = d.getSeconds();

    if (horas < 10)
        horas = "0" + horas;
    if (minutos < 10)
        minutos = "0" + minutos;
    if (segundos < 10)
        segundos = "0" + segundos;
        
    elementoHora.innerText = horas + " : " + minutos + " : " + segundos;  

}