window.onload = function() {
    fetch('/api/alunos')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('alunosSelect');
            // Adicionar uma opção vazia como primeiro
            select.add(new Option("", ""));

            // Adicionar alunos ao select
            data.forEach( alunos=> {
                const option = new Option(alunos.nome, alunos.id);
                select.add(option);
            });
        })
        .catch(error => console.error('Erro ao carregar os alunos:', error));
};
