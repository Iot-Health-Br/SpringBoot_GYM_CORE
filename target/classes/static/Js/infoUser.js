document.addEventListener('DOMContentLoaded', function() {
    const alunosSelect = document.getElementById('alunosSelect');
    alunosSelect.addEventListener('change', function() {
        const userId = this.value;
        if (userId) {
            fetch(`/manterAluno/${userId}`)
                .then(response => response.json())
                .then(data => {
                    document.getElementById('nome').value = data.nome || '';
                    document.getElementById('cpf').value = data.cpf || '';
                    document.getElementById('dataNascimento').value = data.nascimento || '';
                    document.getElementById('genero').value = data.genero || '';
                    document.getElementById('estadoCivil').value = data.estadoCivil || '';
                    document.getElementById('categoria').value = data.categoria || '';
                    document.getElementById('endereco').value = data.endereco || '';
                    document.getElementById('telefone').value = data.telefone || '';
                    document.getElementById('email').value = data.email || '';
                    document.getElementById('password').value = data.senha || '';
                    document.getElementById('password').value = data.senha || '';

                    //Informações de Saude
                    document.getElementById('altura').value = data.altura || '';
                    document.getElementById('peso').value = data.peso || '';
                    document.getElementById('imc').value = data.imc || '';
                    document.getElementById('pa').value = data.pa || '';
                    document.getElementById('doenca').value = data.doenca || '';
                    document.getElementById('limitacao').value = data.limitacao || '';
                    document.getElementById('restricao').value = data.restricao || '';
                    document.getElementById('medicamento').value = data.medicamento || '';
                    document.getElementById('cirurgia').value = data.cirurgia || '';

                    //Dados Pagamento
                    document.getElementById('vencMatricula').value = data.vencimentoMatricula || '';
                    document.getElementById('plano').value = data.plano || '';
                    document.getElementById('professoresSelect').value = data.professoresSelect || '';

                    //Objetivos
                    document.getElementById('experiencia').value = data.experiencia || '';
                    document.getElementById('condicionamento').value = data.condicionamento || '';
                    document.getElementById('objetivo').value = data.objetivo || '';
                    document.getElementById('atividades').value = data.atividades || '';
                    document.getElementById('expectitativa').value = data.expectitativa || '';

                    // Continue atualizando os campos do formulário
                    // Mostre a imagem, se necessário
                    if (data.foto) {
                        document.getElementById('fotoPreview').src = 'data:image/jpeg;base64,' + btoa(data.foto);
                        document.getElementById('fotoPreview').style.display = 'block';
                    }
                })
                .catch(error => console.error('Failed to fetch user data:', error));
        }
    });
});
