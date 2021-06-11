var imagens = ["praia.jpg","praia2.jpg","praia3.jpg"];
var cores = ["red","green","blue","yellow"];
var pos = 0;
var tam = imagens.length;
var tamC = cores.length;

function anterior() {
    pos = (pos + tam - 1) % tam;
    /* 
    if (pos < 0)
        pos = 2;
    */
    document.getElementById("pos").innerHTML = pos;
    // document.getElementById("slide").src= "imagens/" + imagens[pos];
    document.images[0].src= "imagens/" + imagens[pos];
}

function seguinte() {
    pos = (pos + 1) % tam;
    /*
    if (pos > 2)
        pos = 0;
    */
    document.getElementById("pos").innerHTML = pos;
    document.getElementById("slide").src= "imagens/" + imagens[pos];
}

function mudarFundo() {
    pos = (pos + 1) % tamC;
    document.body.style.backgroundColor = cores[pos];
}