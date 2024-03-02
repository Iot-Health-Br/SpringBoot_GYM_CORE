package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}

