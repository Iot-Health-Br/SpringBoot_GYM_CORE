package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface AdmRepository extends JpaRepository<Adm, Long> {
    Adm findByCpfAndSenha(String cpf, String senha);
    boolean existsByCpf(String cpf);
    boolean existsByNome(String nome);
    Optional<Adm> findByCpf(String cpf);
}