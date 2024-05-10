package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.TrainingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingUser, String> {
    @Query("SELECT t FROM TrainingUser t WHERE t.dataTreino < :dataLimite")
    List<TrainingUser> findTreinosVencidos(@Param("dataLimite") LocalDate dataLimite);
}