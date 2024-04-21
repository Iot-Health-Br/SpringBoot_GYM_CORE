package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Teste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface TesteRepository extends JpaRepository<Teste, Long> {
    Optional<Teste> findByCpfAndSenha(String cpf, String senha);
}