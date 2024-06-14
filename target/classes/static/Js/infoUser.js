document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/alunos')
        .then(response => response.json())
        .then(data => {
            const selectAlunos = document.getElementById('alunosSelect');
            selectAlunos.add(new Option("", ""));
            data.forEach(aluno => {
                const option = new Option(aluno.nome, aluno.id);
                selectAlunos.add(option);
            });

            selectAlunos.addEventListener('change', function () {
                const selectedId = selectAlunos.value;
                if (selectedId) {
                    fetch(`/api/alunos/${selectedId}`)
                        .then(response => response.json())
                        .then(aluno => {
                            document.getElementById('name').value = aluno.nome;
                            document.getElementById('cpf').value = aluno.cpf;
                            document.getElementById('birthday').value = aluno.nascimento;
                            document.getElementById('gender').value = aluno.genero;
                            document.getElementById('civilState').value = aluno.estadoCivil;
                            document.getElementById('address').value = aluno.endereco;
                            document.getElementById('phone').value = aluno.telefone;
                            document.getElementById('email').value = aluno.email;
                            document.getElementById('senha').value = aluno.senha;
                            document.getElementById('senha2').value = aluno.senha;

                            document.getElementById('altura').value = aluno.altura;
                            document.getElementById('peso').value = aluno.peso;
                            //document.getElementById('massIndex').value = aluno.IMC;
                            document.getElementById('pa').value = aluno.pa;
                            document.getElementById('doença').value = aluno.sick;
                            document.getElementById('limitation').value = aluno.limitacaoFisica;
                            document.getElementById('restriction').value = aluno.restricoesAlimentar;
                            document.getElementById('medicine').value = aluno.usoMedicamento;
                            document.getElementById('surgicalHistory').value = aluno.surgicalHistory;


                            document.getElementById('payDate').value = aluno.vencimentoMatricula;
                            document.getElementById('plan').value = aluno.plano;
                            document.getElementById('professoresSelect').value = aluno.professorResponsavel;
                            document.getElementById('experience').value = aluno.experiencia;
                            document.getElementById('conditioningLevel').value = aluno.nivelCondicionamento;
                            document.getElementById('objective').value = aluno.objetivo;
                            document.getElementById('activities').value = aluno.atividadesFisicas;
                            document.getElementById('expectation').value = aluno.expectitativa;
                        })
                        .catch(error => console.error('Erro ao carregar os dados do aluno:', error));
                } else {
                    // Clear form fields if no student is selected
                    document.querySelectorAll('form input, form select').forEach(input => input.value = '');
                }
            });
        })
        .catch(error => console.error('Erro ao carregar os alunos:', error));


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
});
