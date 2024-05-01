package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.LoginDTO;
import com.cadastro.usuario.Exception.UserNotFound;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private AdmRepository admRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public String login(LoginDTO loginDTO) throws UserNotFound {
        Adm adm = admRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha());
        Usuario user = usuarioRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha());
        if (adm != null) {
            return "/homeAdm";
        }
        else if (user != null) {
            return "/homeUser";
        }
        else {
            throw new UserNotFound("Usuário não encontrado");
        }
    }
}





