window.onload = function() {
    fetch('/api/professores')
        .then(response => response.json())
        .then(data => {
            const selectProfessores = document.getElementById('professoresSelect');
            selectProfessores.add(new Option("", ""));
            data.forEach(professor => {
                const option = new Option(professor.nome, professor.id);
                selectProfessores.add(option);
            });
        })
        .catch(error => console.error('Erro ao carregar os professores:', error));

    fetch('/api/alunos')
        .then(response => response.json())
        .then(data => {
            const selectAlunos = document.getElementById('alunosSelect');
            selectAlunos.add(new Option("", ""));
            data.forEach(aluno => {
                const option = new Option(aluno.nome, aluno.id);
                selectAlunos.add(option);
            });
        })
        .catch(error => console.error('Erro ao carregar os alunos:', error));
};
