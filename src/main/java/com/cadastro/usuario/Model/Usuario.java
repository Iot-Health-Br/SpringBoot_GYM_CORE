package com.cadastro.usuario.Model;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @DateTimeFormat
    private LocalDate nascimento;
    private String genero;
    private String estadoCivil;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String senha;
    @Lob
    private byte[] foto;
    private String categoria;

    ///Informações de saúde
    private Double altura;
    private Double peso;
    private Double IMC;
    private String pa;
    private String doencas;
    private String limitacaoFisica;
    private String restricoesAlimentar;
    private String usoMedicamento;
    private String hitoricoCirugico;

    ///Pagamento
    private boolean pagamento;
    @DateTimeFormat
    private LocalDate dataMatricula;
    @DateTimeFormat
    private LocalDate vencimentoMatricula;
    private String plano;
    private String professorResponsavel;

    //Objetivos
    private String objetivo;
    private String experiencia;
    private String atividadesFisicas;
    private String nivelCondicionamento;
    private String expectitativa;

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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Double getIMC() {
        return IMC;
    }

    public void setIMC(Double IMC) {
        this.IMC = IMC;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public String getDoencas() {
        return doencas;
    }

    public void setDoencas(String doencas) {
        this.doencas = doencas;
    }

    public String getLimitacaoFisica() {
        return limitacaoFisica;
    }

    public void setLimitacaoFisica(String limitacaoFisica) {
        this.limitacaoFisica = limitacaoFisica;
    }

    public String getRestricoesAlimentar() {
        return restricoesAlimentar;
    }

    public void setRestricoesAlimentar(String restricoesAlimentar) {
        this.restricoesAlimentar = restricoesAlimentar;
    }

    public String getUsoMedicamento() {
        return usoMedicamento;
    }

    public void setUsoMedicamento(String usoMedicamento) {
        this.usoMedicamento = usoMedicamento;
    }

    public String getHitoricoCirugico() {
        return hitoricoCirugico;
    }

    public void setHitoricoCirugico(String hitoricoCirugico) {
        this.hitoricoCirugico = hitoricoCirugico;
    }

    public Boolean getPagamento() {
        return pagamento;
    }

    public void setPagamento(Boolean pagamento) {
        this.pagamento = pagamento;
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

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(String experiencia) {
        this.experiencia = experiencia;
    }

    public String getAtividadesFisicas() {
        return atividadesFisicas;
    }

    public void setAtividadesFisicas(String atividadesFisicas) {
        this.atividadesFisicas = atividadesFisicas;
    }

    public String getNivelCondicionamento() {
        return nivelCondicionamento;
    }

    public void setNivelCondicionamento(String nivelCondicionamento) {
        this.nivelCondicionamento = nivelCondicionamento;
    }

    public String getExpectitativa() {
        return expectitativa;
    }

    public void setExpectitativa(String expectitativa) {
        this.expectitativa = expectitativa;
    }
}

