package com.cadastro.usuario.Model;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class LoginUser {
    private Long id;
    private byte[]foto;
    private String nome;
    private String cpf;
    private String telefone;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataMatricula;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate vencimentoMatricula;

    //Construtor
    /*public LoginUser(Long id, Byte[]foto, String nome, String telefone) {
        this.id = id;
        this.foto=foto;
        this.nome = nome;
        this.telefone = telefone;
    }*/

    public LoginUser(Long id, byte[] foto, String nome, String telefone) {
        this.id = id;
        this.foto=foto;
        this.nome = nome;
        this.telefone = telefone;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public LocalDate getVencimentoMatricula() {
        return vencimentoMatricula;
    }

    public void setVencimentoMatricula(LocalDate vencimentoMatricula) {
        this.vencimentoMatricula = vencimentoMatricula;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
}

