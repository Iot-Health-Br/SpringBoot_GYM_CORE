package com.cadastro.usuario.Model;

import com.cadastro.usuario.DTO.TrainingDTO;
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

    //Construtor

    public TrainingUser(TrainingDTO trainingDTO) {
        this.id = trainingDTO.getId();
        this.idUser = trainingDTO.getIdUser();
        this.idTeacher = trainingDTO.getIdTeacher();
        this.dataTreino = trainingDTO.getDataTreino();
        this.vencimentoTreino = trainingDTO.getVencimentoTreino();

        // Costa
        this._DiaCosta = trainingDTO.get_DiaCosta();
        this._1ExercicioCosta = trainingDTO.get_1ExercicioCosta();
        this._1ECserie = trainingDTO.get_1ECserie();
        this._1ECSrepeticao = trainingDTO.get_1ECSrepeticao();
        this._2ExercicioCosta = trainingDTO.get_2ExercicioCosta();
        this._2ECserie = trainingDTO.get_2ECserie();
        this._2ECSrepeticao = trainingDTO.get_2ECSrepeticao();
        this._3ExercicioCosta = trainingDTO.get_3ExercicioCosta();
        this._3ECserie = trainingDTO.get_3ECserie();
        this._3ECSrepeticao = trainingDTO.get_3ECSrepeticao();

        // Peito
        this._DiaPeito = trainingDTO.get_DiaPeito();
        this._1ExercicioPeito = trainingDTO.get_1ExercicioPeito();
        this._1EPserie = trainingDTO.get_1EPserie();
        this._1EPSrepeticao = trainingDTO.get_1EPSrepeticao();
        this._2ExercicioPeito = trainingDTO.get_2ExercicioPeito();
        this._2EPserie = trainingDTO.get_2EPserie();
        this._2EPSrepeticao = trainingDTO.get_2EPSrepeticao();
        this._3ExercicioPeito = trainingDTO.get_3ExercicioPeito();
        this._3EPserie = trainingDTO.get_3EPserie();
        this._3EPSrepeticao = trainingDTO.get_3EPSrepeticao();

        // Bíceps
        this._DiaBicipes = trainingDTO.get_DiaBicipes();
        this._1ExercicioBicipes = trainingDTO.get_1ExercicioBicipes();
        this._1EBserie = trainingDTO.get_1EBserie();
        this._1EBSrepeticao = trainingDTO.get_1EBSrepeticao();
        this._2ExercicioBicipes = trainingDTO.get_2ExercicioBicipes();
        this._2EBserie = trainingDTO.get_2EBserie();
        this._2EBSrepeticao = trainingDTO.get_2EBSrepeticao();
        this._3ExercicioBicipes = trainingDTO.get_3ExercicioBicipes();
        this._3EBserie = trainingDTO.get_3EBserie();
        this._3EBSrepeticao = trainingDTO.get_3EBSrepeticao();

        // Tríceps
        this._DiaTricipes = trainingDTO.get_DiaTricipes();
        this._1ExercicioTricipes = trainingDTO.get_1ExercicioTricipes();
        this._1ETserie = trainingDTO.get_1ETserie();
        this._1ETSrepeticao = trainingDTO.get_1ETSrepeticao();
        this._2ExercicioTricipes = trainingDTO.get_2ExercicioTricipes();
        this._2ETserie = trainingDTO.get_2ETserie();
        this._2ETSrepeticao = trainingDTO.get_2ETSrepeticao();
        this._3ExercicioTricipes = trainingDTO.get_3ExercicioTricipes();
        this._3ETserie = trainingDTO.get_3ETserie();
        this._3ETSrepeticao = trainingDTO.get_3ETSrepeticao();

        // Ombro
        this._DiaOmbro = trainingDTO.get_DiaOmbro();
        this._1ExercicioOmbro = trainingDTO.get_1ExercicioOmbro();
        this._1EOserie = trainingDTO.get_1EOserie();
        this._1EOSrepeticao = trainingDTO.get_1EOSrepeticao();
        this._2ExercicioOmbro = trainingDTO.get_2ExercicioOmbro();
        this._2EOserie = trainingDTO.get_2EOserie();
        this._2EOSrepeticao = trainingDTO.get_2EOSrepeticao();
        this._3ExercicioOmbro = trainingDTO.get_3ExercicioOmbro();
        this._3EOserie = trainingDTO.get_3EOserie();
        this._3EOSrepeticao = trainingDTO.get_3EOSrepeticao();

        // Trapézio
        this._DiaTrapezio = trainingDTO.get_DiaTrapezio();
        this._1ExercicioTrapezio = trainingDTO.get_1ExercicioTrapezio();
        this._1ETRserie = trainingDTO.get_1ETRserie();
        this._1ETRSrepeticao = trainingDTO.get_1ETRSrepeticao();
        this._2ExercicioTrapezio = trainingDTO.get_2ExercicioTrapezio();
        this._2ETRserie = trainingDTO.get_2ETRserie();
        this._2ETRSrepeticao = trainingDTO.get_2ETRSrepeticao();
        this._3ExercicioTrapezio = trainingDTO.get_3ExercicioTrapezio();
        this._3ETRserie = trainingDTO.get_3ETRserie();
        this._3ETRSrepeticao = trainingDTO.get_3ETRSrepeticao();

        // Perna
        this._DiaPerna = trainingDTO.get_DiaPerna();
        this._1ExercicioPerna = trainingDTO.get_1ExercicioPerna();
        this._1EPRserie = trainingDTO.get_1EPRserie();
        this._1EPRSrepeticao = trainingDTO.get_1EPRSrepeticao();
        this._2ExercicioPerna = trainingDTO.get_2ExercicioPerna();
        this._2EPRserie = trainingDTO.get_2EPRserie();
        this._2EPRSrepeticao = trainingDTO.get_2EPRSrepeticao();
        this._3ExercicioPerna = trainingDTO.get_3ExercicioPerna();
        this._3EPRserie = trainingDTO.get_3EPRserie();
        this._3EPRSrepeticao = trainingDTO.get_3EPRSrepeticao();
    }


    //Get and Setter
}
