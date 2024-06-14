document.addEventListener('DOMContentLoaded', function () {
    fetch('/api/professores')
        .then(response => response.json())
        .then(data => {
            const selectAdm = document.getElementById('professoresSelect');
            selectAdm.add(new Option("", ""));
            data.forEach(adm => {
                const option = new Option(adm.nome, adm.id);
                selectAdm.add(option);
            });

            selectAdm.addEventListener('change', function () {
                const selectedId = selectAdm.value;
                if (selectedId) {
                    fetch(`/api/professores/${selectedId}`)
                        .then(response => response.json())
                        .then(adm => {
                            document.getElementById('name').value = adm.nome;
                            document.getElementById('cpf').value = adm.cpf;
                            document.getElementById('birthday').value = adm.nascimento;
                            document.getElementById('gender').value = adm.genero;
                            document.getElementById('civilState').value = adm.estadoCivil;
                            document.getElementById('address').value = adm.endereco;
                            document.getElementById('phone').value = adm.telefone;
                            document.getElementById('email').value = adm.email;
                            document.getElementById('senha').value = adm.senha;
                            document.getElementById('senha2').value = adm.senha;

                        })
                        .catch(error => console.error('Erro ao carregar os dados do Professor:', error));
                } else {
                    // Clear form fields if no student is selected
                    document.querySelectorAll('form input, form select').forEach(input => input.value = '');
                }
            });
        })
        .catch(error => console.error('Erro ao carregar os Professores:', error));
});
