package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, String> {
    Login findByCpfAndSenha(String cpf, String senha);
}
