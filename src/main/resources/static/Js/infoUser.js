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
                            document.getElementById('massIndex').value = aluno.IMC;
                            document.getElementById('pa').value = aluno.pa;
                            document.getElementById('sick').value = aluno.doencas;
                            document.getElementById('limitation').value = aluno.limitacaoFisica;
                            document.getElementById('restriction').value = aluno.restricoesAlimentar;
                            document.getElementById('medicine').value = aluno.usoMedicamento;
                            document.getElementById('surgicalHistory').value = aluno.historicoCirurgico;


                            document.getElementById('payDate').value = aluno.vencimentoMatricula;
                            document.getElementById('plan').value = aluno.plano;
                            document.getElementById('professoresSelect').value = aluno.professorResponsavel;
                            document.getElementById('experience').value = aluno.experiencia;
                            document.getElementById('conditioningLevel').value = aluno.nivelCondicionamento;
                            document.getElementById('objective').value = aluno.objetivo;
                            document.getElementById('activities').value = aluno.atividadesFisicas;
                            document.getElementById('expectation').value = aluno.expectativa;
                        })
                        .catch(error => console.error('Erro ao carregar os dados do aluno:', error));
                } else {
                    // Clear form fields if no student is selected
                    document.querySelectorAll('form input, form select').forEach(input => input.value = '');
                }
            });
        })
        .catch(error => console.error('Erro ao carregar os alunos:', error));
});
