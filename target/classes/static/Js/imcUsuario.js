function calcularIMC() {
    var altura = parseFloat(document.getElementById('altura').value);
    var peso = parseFloat(document.getElementById('peso').value);

    if (altura > 0 && peso > 0) {
        var imc = peso / (altura * altura);
        document.getElementById('massIndex').value = imc.toFixed(2); // Arredonda o IMC para duas casas decimais
    } else {
        document.getElementById('massIndex').value = ''; // Limpa o campo IMC se os valores não são válidos
    }
}
