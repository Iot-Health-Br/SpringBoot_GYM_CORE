package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
    Usuario findByCpfAndSenha(String cpf, String senha);
}

