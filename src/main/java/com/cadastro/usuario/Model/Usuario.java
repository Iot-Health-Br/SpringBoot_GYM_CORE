package com.cadastro.usuario.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    /// Dados Pessoais
    private Long id;
    private String nome;
    private Date nascimento;
    private String genero;
    private String estadoCivil;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String senha;
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
    private String pagamento;
    private Date dataMatricula;
    private Date vencimentoMatricula;
    private String plano;
    private String professorResponsável;

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

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
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

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    public Date getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(Date dataMatricula) {
        this.dataMatricula = dataMatricula;
    }

    public Date getVencimentoMatricula() {
        return vencimentoMatricula;
    }

    public void setVencimentoMatricula(Date vencimentoMatricula) {
        this.vencimentoMatricula = vencimentoMatricula;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    public String getProfessorResponsável() {
        return professorResponsável;
    }

    public void setProfessorResponsável(String professorResponsável) {
        this.professorResponsável = professorResponsável;
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

