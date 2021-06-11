var palavras = [
    "abelha",
    "alpaca",
    "camelo",
    "frango",
    "macaco",
    "ovelha"
];

// sorteio: posição de 0 a 5
var i = Math.floor(Math.random() * palavras.length);

// palavra sorteada
var palavra = palavras[i];

var letrasPalavra = [
    palavra.slice(0,1),
    palavra.slice(1,2),
    palavra.slice(2,3),
    palavra.slice(3,4),
    palavra.slice(4,5),
    palavra.slice(5,6) 
];

// número máximo de tentativas
var tentativas = 10;

var acertos = 6;

// ver a palavra escolhida
document.getElementById("batota").innerText = palavra;

// ver a palavra escolhida
document.getElementById("batota2").innerText = acertos;

function usada(letra) {
    if (tentativas > 0) {
        if (acertos > 0) {
            // verificar se a letra não está na palavra
            if(palavra.indexOf(letra) == -1) {

                // a letra não está na palavra 
                tentativas--;

                // alterar o número de tentativas
                document.getElementById("tentativas").innerText = "Tentativas: " + tentativas;
            }
            else {
                var ocorrencias = 0;
                for(var j = 0; j < letrasPalavra.length; j++) {
                    if (letrasPalavra[j] == letra) {
                        ocorrencias++;
                    }   
                }
                acertos = acertos - ocorrencias;
                if (acertos == 0) {
                    document.getElementById("tentativas").innerText = "Acertou!"; 
                }
            }
            // ocultar o botão
            document.getElementById(letra).style.visibility="hidden";
        }
    }
    else {
        document.getElementById("tentativas").innerText = "Perdeu!";
    }
}