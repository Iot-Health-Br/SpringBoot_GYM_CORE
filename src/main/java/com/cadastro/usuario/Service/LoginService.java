package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.LoginDTO;
import com.cadastro.usuario.Exception.UserNotFound;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
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
    public String login(LoginDTO loginDTO, HttpSession session) throws UserNotFound {
        Adm adm = admRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha());
        Usuario user = usuarioRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha());
        if (adm != null) {
            LoginUser loginAdm = new LoginUser(adm.getNome(), adm.getTelefone());
            session.setAttribute("loggedUser", loginAdm);
            return "/homeAdm";
        }
        else if (user != null) {
            LoginUser loginUser = new LoginUser(user.getNome(), user.getTelefone());
            session.setAttribute("loggedUser", loginUser);
            return "/homeUser";
        }
        else {
            throw new UserNotFound("Usuário não encontrado");
        }
    }
}





