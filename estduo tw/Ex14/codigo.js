// jogador 1 - vez = 1
// jogador 2 - vez = 2

var vez = 1;
var jogadas = 0;

function jogar(el) {
    if (el.innerHTML == "") {
        if (vez == 1) {
            por_x(el);
            vez = 2;
            document.getElementById("jogador").innerText = "É a vez do O.";
        }
        else {
            por_o(el);
            vez = 1;
            document.getElementById("jogador").innerText = "É a vez do X.";
        }
        jogadas++;
        if (jogadas == 9) {
            document.getElementById("jogador").innerText = "Já não há mais jogadas.";
        }
    }
}

function por_x(el) {
    el.innerHTML = "<img src='imagens/x.png' alt='x' width='100'>";

}

function por_o(el) {
    el.innerHTML = "<img src='imagens/o.png' alt='o' width='100'>";
}