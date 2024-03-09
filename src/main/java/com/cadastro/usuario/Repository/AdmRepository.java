package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdmRepository extends JpaRepository<Adm, Long> {
    Optional<Adm> findByCpfAndSenha(String cpf, String senha);
}
