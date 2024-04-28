package com.cadastro.usuario.Controller;

import com.cadastro.usuario.DTO.LoginDTO;
import com.cadastro.usuario.Exception.UsuarioNaoEncontradoException;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import com.cadastro.usuario.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public String login() {
        return "/login";  // Nome do arquivo HTML ou template do login
    }

    @PostMapping("/login")
    public ModelAndView performLogin(@RequestParam String cpf, @RequestParam String senha) {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setCpf(cpf);
        loginDTO.setSenha(senha);

        ModelAndView modelAndView = new ModelAndView();
        try {
            String viewName = loginService.login(loginDTO);
            modelAndView.setViewName("redirect:"+viewName);
        } catch (UsuarioNaoEncontradoException e) {
            modelAndView.setViewName("/login");
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }
}