<img src="https://github.com/Iot-Health-Br/SpringBoot_GYM_CORE/blob/master/Logo%20Imagens/Logo%20Principal.jpeg?raw=true" width="200" height="200"> 

# GYM CORE 

   Este repositório se destina ao sistema GYM CORE criado para gerenciamento de academias, controlando o cadastro dos alunos, seus treinos e controle financeiro. 

   Trata-se de um programa desenvolvido para aplicação WEB, utilizando o framework SpringBoot, o código foi criado na arquitetura monolitica que utiliza a estrutura model view control (MVC). 

## 🚀 Começando

   Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

   Consulte **[Implantação](#-implanta%C3%A7%C3%A3o)** para saber como implantar o projeto.

### 📋 Pré-requisitos

   Antes de iniciar, certifique-se de ter todas as ferramentas necessárias instaladas. Você precisará de:

   - Pré-requisito 1 (Java JDK 20)
   - Pré-requisito 2 (Git, Postgres)
   - Pré-requisito 3 (Intelij JetBrains)

### 🔧 Instalação

   Siga estes passos para configurar seu ambiente de desenvolvimento:

1. **Clone o repositório:**

   ```bash
   git clone https://github.com/Iot-Health-Br/SpringBoot_GYM_CORE.git

2. **Crie o banco de dados:**

   Nesta Aplicação estamos usando o banco de dados POSTGRES conforme o **[Construído com](#-Construído%C3%A7%C3%A3o)**   
   Será nescessário a criação do banco de dados manualmente com o seguinte nome "gym_core".

   <img src="https://ibb.co/2s6B608"> 

   Ao copilar o código na IDE será criado as tabelas circuladas de amarelo "adm", "training_user" e "usuario".

3. **Crie um job no banco de dados:**

   Será nescessário a criação de um job no banco de dados que será responsavel em verificar o status da matricula do aluno e verificar se ele estar inadiplente ou adiplente.

   Para isso, precisamos instalar o PG AGENT no postgres, ele não vem instalado default no banco de dados

   ```
   https://www.pgadmin.org/docs/pgadmin4/development/pgagent.html
   ```

   <img src="https://ibb.co/NyFhKTh"> 


## ⚙️ Executando os testes

   Explicar como executar os testes automatizados para este sistema.

### 🔩 Analise os testes de ponta a ponta

   Explique que eles verificam esses testes e porquê.

   ```
   Dar exemplos
   ```

### ⌨️ E testes de estilo de codificação

   Explique que eles verificam esses testes e porquê.

   ```
   Dar exemplos
   ```

## 📦 Implantação

   Adicione notas adicionais sobre como implantar isso em um sistema ativo

## 🛠️ Construído com

   Ferramentas usadas para criar o projeto.

   * Programa criado usando a ferrameta [Intelij] - https://www.jetbrains.com/pt-br/idea/ - IDE usada
   * Programa criado usando o framework [Spring Boot] - https://spring.io/ - Framework usado
   * Programa criado usando a ferrameta [GIT] - https://git-scm.com/ - Versionamento
   * Programa criado usando o banco de dados [Postgres] - https://www.postgresql.org/ - Banco de Dados usado

## 🖇️ Colaborando



## 📌 Versão

   Nós usamos [GIT](https://git-scm.com/) para controle de versão. Para as versões disponíveis, observe as [tags neste repositório](https://github.com/Iot-Health-Br/SpringBoot_GYM_CORE/commits/main/). 

## ✒️ Autores

   * **Desenvolvedor** - *Trabalho Inicial* / *Documentação* - [Igor Leonor Macedo](https://github.com/Iot-Health-Br)
   * **Desenvolvedor** - *Trabalho Inicial* / *Documentação* - [Lucas Ribeiro Marques](https://github.com/LucasRibeiroMArques)
   * **Desenvolvedor** - *Trabalho Inicial* / *Documentação* - [Luidy Tavares](https://github.com/LuidyTT)
   * **Desenvolvedor** - *Trabalho Inicial* / *Documentação* - [Pedro Augusto](https://github.com/PedroAugusto-sys)


## 📄 Licença

   Este projeto está sob a licença (sua licença) - veja o arquivo [LICENSE.md](https://github.com/usuario/projeto/licenca) para detalhes.

## 🎁 Expressões de gratidão

   * Conte a outras pessoas sobre este projeto 📢;
   * Convide alguém da equipe para uma cerveja 🍺;
   * Um agradecimento publicamente 🫂;
