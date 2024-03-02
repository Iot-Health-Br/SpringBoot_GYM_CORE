// Função para validar as senhas
function validaSenhas() {
    var senha = document.getElementById('senha').value;
    var senha2 = document.getElementById('senha2').value;
    var mensagemErro = document.getElementById('mensagemErro');

    if (senha !== senha2) {
        // Mostra a mensagem de erro
        mensagemErro.style.display = 'block';
    } else {
        // Esconde a mensagem de erro se as senhas coincidirem
        mensagemErro.style.display = 'none';
    }
}

// Adiciona o evento de 'input' aos campos de senha
document.getElementById('senha').addEventListener('input', validaSenhas);
document.getElementById('senha2').addEventListener('input', validaSenhas);

// Mantém a validação no envio para segurança adicional
document.getElementById('formRegistro').onsubmit = function(event) {
    var senha = document.getElementById('senha').value;
    var senha2 = document.getElementById('senha2').value;

    if (senha !== senha2) {
        event.preventDefault();
        // Certifique-se de que a mensagem de erro está sendo exibida
        document.getElementById('mensagemErro').style.display = 'block';
    }
};

