var imagens = ["img1.jpg","img2.jpg","img3.jpg"];
var i = 0;
var elemento = document.getElementById("slide");
var idTemporizador = setInterval(imagemSeguinte,5000);

/* chamar de 5s em 5s */
    function imagemSeguinte() {
        i = (i + 1) % imagens.length;
        elemento.src = "imagens/" + imagens[i];
    }

function pararSlide() {
    clearInterval(idTemporizador);
}

function seguinte() {
    setTimeout(imagemSeguinte,500);
}
