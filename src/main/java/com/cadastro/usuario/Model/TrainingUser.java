package com.cadastro.usuario.Model;

import com.cadastro.usuario.DTO.TrainingDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;


@Getter
@Setter
@Entity
public class TrainingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private String nameUser;
    private Long idTeacher;
    private String nameTeacher;
    @DateTimeFormat
    //private Date dataTreino;
    private LocalDate dataTreino;
    @DateTimeFormat
    //private Date vencimentoTreino;
    private LocalDate vencimentoTreino;

    /////////////////////// Exercicios de Costa ////////////////////////////////////////
    private String DiaCosta;
    private String Exercicio_Costa;
    private String Costa_Serie;
    private String Costa_Repeticao;
    // Segundo
    private String Exercicio_Costa2;
    private String Costa_Serie2;
    private String Costa_Repeticao2;
    // Terceiro
    private String Exercicio_Costa3;
    private String Costa_Serie3;
    private String Costa_Repeticao3;

    /////////////////////// Exercicio de Peito ////////////////////////////////////////
    private String DiaPeito;
    private String Exercicio_Peito;
    private String Peito_Serie;
    private String Peito_Repeticao;
    // Segundo
    private String Exercicio_Peito2;
    private String Peito_Serie2;
    private String Peito_Repeticao2;
    // Terceiro
    private String Exercicio_Peito3;
    private String Peito_Serie3;
    private String Peito_Repeticao3;

    /////////////////////// Exercicio de Bicipes ////////////////////////////////////////
    private String DiaBicipes;
    private String Exercicio_Bicipes;
    private String Bicipes_Serie;
    private String Bicipes_Repeticao;
    // Segundo
    private String Exercicio_Bicipes2;
    private String Bicipes_Serie2;
    private String Bicipes_Repeticao2;
    // Terceiro
    private String Exercicio_Bicipes3;
    private String Bicipes_Serie3;
    private String Bicipes_Repeticao3;

    /////////////////////// Exercicio de Tricipes ////////////////////////////////////////
    private String DiaTricipes;
    private String Exercicio_Tricipes;
    private String Tricipes_Serie;
    private String Tricipes_Repeticao;
    // Segundo
    private String Exercicio_Tricipes2;
    private String Tricipes_Serie2;
    private String Tricipes_Repeticao2;
    // Terceiro
    private String Exercicio_Tricipes3;
    private String Tricipes_Serie3;
    private String Tricipes_Repeticao3;

    /////////////////////// Exercicio de Ombro ////////////////////////////////////////
    private String DiaOmbro;
    private String Exercicio_Ombro;
    private String Ombro_Serie;
    private String Ombro_Repeticao;
    // Segundo
    private String Exercicio_Ombro2;
    private String Ombro_Serie2;
    private String Ombro_Repeticao2;
    // Terceiro
    private String Exercicio_Ombro3;
    private String Ombro_Serie3;
    private String Ombro_Repeticao3;

    /////////////////////// Exercicio de Trapezio ////////////////////////////////////////
    private String DiaTrapezio;
    private String Exercicio_Trapezio;
    private String Trapezio_Serie;
    private String Trapezio_Repeticao;
    // Segundo
    private String Exercicio_Trapezio2;
    private String Trapezio_Serie2;
    private String Trapezio_Repeticao2;
    // Terceiro
    private String Exercicio_Trapezio3;
    private String Trapezio_Serie3;
    private String Trapezio_Repeticao3;

    /////////////////////// Exercicio de Perna ////////////////////////////////////////
    private String DiaPerna;
    private String Exercicio_Perna;
    private String Perna_Serie;
    private String Perna_Repeticao;
    // Segundo
    private String Exercicio_Perna2;
    private String Perna_Serie2;
    private String Perna_Repeticao2;
    // Terceiro
    private String Exercicio_Perna3;
    private String Perna_Serie3;
    private String Perna_Repeticao3;

    //Construtor

    //Get and Setter
}
