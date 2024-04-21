package com.cadastro.usuario.Model;

import jakarta.persistence.*;

@Entity
public class Teste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /// Dados Pessoais
    private Long id;
    private String nome;
    @Lob
    private byte[] foto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
}
