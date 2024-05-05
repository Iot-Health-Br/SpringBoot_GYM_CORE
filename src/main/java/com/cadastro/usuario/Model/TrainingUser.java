package com.cadastro.usuario.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@Setter
@Entity
public class TrainingUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idUser;
    private Long idTeacher;
    @DateTimeFormat
    private Date dataTreino;
    @DateTimeFormat
    private Date vencimentoTreino;

    /////////////////////// Exercicios de Costa ////////////////////////////////////////
    private String _DiaCosta;
    private String _1ExercicioCosta;
    private String _1ECserie;
    private String _1ECSrepeticao;
    // Segundo
    private String _2ExercicioCosta;
    private String _2ECserie;
    private String _2ECSrepeticao;
    // Terceiro
    private String _3ExercicioCosta;
    private String _3ECserie;
    private String _3ECSrepeticao;

    /////////////////////// Exercicio de Peito ////////////////////////////////////////
    private String _DiaPeito;
    private String _1ExercicioPeito;
    private String _1EPserie;
    private String _1EPSrepeticao;
    // Segundo
    private String _2ExercicioPeito;
    private String _2EPserie;
    private String _2EPSrepeticao;
    // Terceiro
    private String _3ExercicioPeito;
    private String _3EPserie;
    private String _3EPSrepeticao;

    /////////////////////// Exercicio de Bicipes ////////////////////////////////////////
    private String _DiaBicipes;
    private String _1ExercicioBicipes;
    private String _1EBserie;
    private String _1EBSrepeticao;
    // Segundo
    private String _2ExercicioBicipes;
    private String _2EBserie;
    private String _2EBSrepeticao;
    // Terceiro
    private String _3ExercicioBicipes;
    private String _3EBserie;
    private String _3EBSrepeticao;

    /////////////////////// Exercicio de Tricipes ////////////////////////////////////////
    private String _DiaTricipes;
    private String _1ExercicioTricipes;
    private String _1ETserie;
    private String _1ETSrepeticao;
    // Segundo
    private String _2ExercicioTricipes;
    private String _2ETserie;
    private String _2ETSrepeticao;
    // Terceiro
    private String _3ExercicioTricipes;
    private String _3ETserie;
    private String _3ETSrepeticao;

    /////////////////////// Exercicio de Ombro ////////////////////////////////////////
    private String _DiaOmbro;
    private String _1ExercicioOmbro;
    private String _1EOserie;
    private String _1EOSrepeticao;
    // Segundo
    private String _2ExercicioOmbro;
    private String _2EOserie;
    private String _2EOSrepeticao;
    // Terceiro
    private String _3ExercicioOmbro;
    private String _3EOserie;
    private String _3EOSrepeticao;

    /////////////////////// Exercicio de Trapezio ////////////////////////////////////////
    private String _DiaTrapezio;
    private String _1ExercicioTrapezio;
    private String _1ETRserie;
    private String _1ETRSrepeticao;
    // Segundo
    private String _2ExercicioTrapezio;
    private String _2ETRserie;
    private String _2ETRSrepeticao;
    // Terceiro
    private String _3ExercicioTrapezio;
    private String _3ETRserie;
    private String _3ETRSrepeticao;

    /////////////////////// Exercicio de Perna ////////////////////////////////////////
    private String _DiaPerna;
    private String _1ExercicioPerna;
    private String _1EPRserie;
    private String _1EPRSrepeticao;
    // Segundo
    private String _2ExercicioPerna;
    private String _2EPRserie;
    private String _2EPRSrepeticao;
    // Terceiro
    private String _3ExercicioPerna;
    private String _3EPRserie;
    private String _3EPRSrepeticao;

    //Get and Setter

}
