// alertHandler.js
document.addEventListener("DOMContentLoaded", function() {
    var mensagemSucesso = /*[[${mensagemSucesso}]]*/ null;
    var mensagemErro = /*[[${mensagemErro}]]*/ null;

    if (mensagemSucesso) {
        alert(mensagemSucesso);
    } else if (mensagemErro) {
        alert(mensagemErro);
    }
});
