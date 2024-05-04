package com.cadastro.usuario.Repository;

import com.cadastro.usuario.Model.TrainingUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainingRepository extends JpaRepository<TrainingUser, String> {

}