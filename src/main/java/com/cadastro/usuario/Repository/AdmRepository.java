package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.Adm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AdmRepository extends JpaRepository<Adm, String> {
    Adm findByCpfAndSenha(String cpf, String senha);
}