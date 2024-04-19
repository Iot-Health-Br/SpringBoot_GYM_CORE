package com.cadastro.usuario.Service;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Repository.AdmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;

    public List<Adm> listarTodosOsProfessores() {
        return admRepository.findAll();
    }
}
