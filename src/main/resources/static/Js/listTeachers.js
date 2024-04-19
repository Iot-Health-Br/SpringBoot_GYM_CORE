window.onload = function() {
    fetch('/api/professores')
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('professoresSelect');
            // Adicionar uma opção vazia como primeiro item
            select.add(new Option("", ""));

            // Adicionar professores ao select
            data.forEach(professor => {
                const option = new Option(professor.nome, professor.id);
                select.add(option);
            });
        })
        .catch(error => console.error('Erro ao carregar os professores:', error));
};
