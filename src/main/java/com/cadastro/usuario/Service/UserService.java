package com.cadastro.usuario.Service;

import com.cadastro.usuario.Model.TrainingUser;
import com.cadastro.usuario.Repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private TrainingRepository trainingRepository;

    public TrainingUser getTreinoUserByUserId(Long idUser) {
        return trainingRepository.findByUserIdAndStatus(idUser, true);
    }
}
