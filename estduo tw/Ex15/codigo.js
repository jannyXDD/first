function calcularIdade() {
    var dn = new Date(document.getElementById("dn").value);
    var dj = new Date();

    var diferenca = dj.getTime() - dn.getTime();
    diferenca = Math.floor(diferenca / 1000 / 60 / 60 / 24 / 365.25);
    document.getElementById("idade").innerText = "Idade: " + diferenca + " anos"; 
}