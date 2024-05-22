window.onload = function() {
    fetch('/api/professores')
        .then(response => response.json())
        .then(data => {
            const selectProfessores = document.getElementById('professoresSelect');
            const nomeTeacherField = document.getElementById('nomeTeacher');
            selectProfessores.add(new Option("", ""));
            data.forEach(professor => {
                const option = new Option(professor.nome, professor.id);
                selectProfessores.add(option);
            });
            // Adicionar um listener para atualizar o campo nomeTeacher quando o professor for selecionado
            selectProfessores.addEventListener('change', function() {
                const selectedOption = selectProfessores.options[selectProfessores.selectedIndex];
                nomeTeacherField.value = selectedOption.text;
            });
        })
        .catch(error => console.error('Erro ao carregar os professores:', error));

    fetch('/api/alunos')
        .then(response => response.json())
        .then(data => {
            const selectAlunos = document.getElementById('alunosSelect');
            const nomeUserField = document.getElementById('nomeAluno');
            selectAlunos.add(new Option("", ""));
            data.forEach(aluno => {
                const option = new Option(aluno.nome, aluno.id);
                selectAlunos.add(option);
            });
            // Adicionar um listener para atualizar o campo nomeAluno quando o aluno for selecionado
            selectAlunos.addEventListener('change', function() {
                const selectedOption = selectAlunos.options[selectAlunos.selectedIndex];
                nomeUserField.value = selectedOption.text;
            });
        })
        .catch(error => console.error('Erro ao carregar os alunos:', error));
};
