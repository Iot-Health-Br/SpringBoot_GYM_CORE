package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByCpfAndSenha(String cpf, String senha);
}

