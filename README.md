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

  

   Ao copilar o código na IDE será criado as tabelas circuladas de amarelo "adm", "training_user" e "usuario".

3. **Crie um job no banco de dados:**

   Será nescessário a criação de um job no banco de dados que será responsavel em verificar o status da matricula do aluno e verificar se ele estar inadiplente ou adiplente.

   Para isso, precisamos instalar o PG AGENT no postgres, ele não vem instalado default no banco de dados

   ```
   https://www.pgadmin.org/docs/pgadmin4/development/pgagent.html
   ```

   

4. Crie o banco de dados:

   Nesta aplicação, estamos usando o banco de dados PostgreSQL. Será necessário a criação do banco de dados manualmente com o seguinte nome "gym_core".

   Ao compilar o código na IDE, serão criadas as tabelas "adm", "training_user" e "usuario".

5. Crie um job no banco de dados:

   Será necessário a criação de um job no banco de dados que será responsável por verificar o status da matrícula do aluno e se ele está inadimplente ou adimplente.

   Para isso, precisamos instalar o PG Agent no PostgreSQL, pois ele não vem instalado por padrão.  

   Siga as instruções para instalar o PG Agent:
   [PG Agent](https://www.pgadmin.org/docs/pgadmin4/development/pgagent.html)
   
   -- Exemplo de criação de job no PostgreSQL usando PG Agent
   
```
DO $$
BEGIN
   PERFORM pg_sleep(86400); -- Intervalo de 1 mes
   -- Seu código SQL para verificar o status da matrícula
   -- e atualizar o status de inadimplente/adimplente
END $$;
```

   Após a instalação, crie um job com as seguintes configurações:

```sql
CREATE OR REPLACE FUNCTION alterar_status_matricula()
RETURNS VOID AS $$
BEGIN
    UPDATE training_user
    SET status = false
    WHERE (CURRENT_TIMESTAMP - intervalo_de_tempo) >= interval '1 month';
END;
$$ LANGUAGE plpgsql;

   ```

   

## ⚙️ Executando os testes unitários

   Basta executar as classes testes na parte inferior da aplicação! Os services estão configurados.

## 🛠️ Construído com

   Ferramentas usadas para criar o projeto.

   * Programa criado usando a ferrameta [Intelij] - https://www.jetbrains.com/pt-br/idea/ - IDE usada
   * Programa criado usando o framework [Spring Boot] - https://spring.io/ - Framework usado
   * Programa criado usando a ferrameta [GIT] - https://git-scm.com/ - Versionamento
   * Programa criado usando o banco de dados [Postgres] - https://www.postgresql.org/ - Banco de Dados usado

## 🖇️ Colaborando
### 1. Fazer o Fork

1. Na página do repositório que você deseja fazer o fork, clique no botão `Fork` no canto superior direito da página.

2. GitHub irá criar uma cópia do repositório em sua conta. Este processo pode levar alguns segundos.

### 2. Clonar o Repositório Forkado

Depois de fazer o fork, você precisará clonar o repositório para sua máquina local para começar a fazer alterações.

1. Vá para a página do seu repositório forkado. Ele estará localizado em `https://github.com/seu-usuario/nome-do-repositorio`.

2. Clique no botão `Code` e copie a URL do repositório (HTTPS, SSH, ou GitHub CLI).
   ![Clone Button](https://docs.github.com/assets/images/help/repository/https-url-clone-cli.png)

3. Abra um terminal na sua máquina local e execute o seguinte comando para clonar o repositório:

   ```bash
   git clone https://github.com/seu-usuario/nome-do-repositorio.git


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
   * Um agradecimento publicamente 👋;
