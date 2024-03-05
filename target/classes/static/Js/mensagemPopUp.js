// Função para mostrar o pop-up
function mostrarMensagem(mensagem, tipo) {
    var mensagemPopUp = document.getElementById('mensagemPopUp');
    mensagemPopUp.style.display = 'block';
    mensagemPopUp.innerHTML = mensagem;

    // Configura a cor do pop-up com base no tipo de mensagem
    if (tipo === 'sucesso') {
        mensagemPopUp.style.backgroundColor = '#4CAF50'; // Verde
    } else if (tipo === 'erro') {
        mensagemPopUp.style.backgroundColor = '#f44336'; // Vermelho
    }

    // Faz o pop-up desaparecer após 5 segundos
    setTimeout(function() {
        mensagemPopUp.style.display = 'none';
    }, 5000);
}
