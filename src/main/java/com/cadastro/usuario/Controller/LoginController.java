package com.cadastro.usuario.Controller;

import com.cadastro.usuario.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @Autowired
    private LoginRepository loginRepository;

    // Método para exibir a página de login
    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Método para processar o login
    @PostMapping("/login")
    public ModelAndView processLogin(@RequestParam("cpf") String cpf, @RequestParam("senha") String senha) {
        if (loginRepository.findByCpfAndSenha(cpf, senha) != null) {
            return new ModelAndView("redirect:/home");
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Usuário não encontrado");
            return modelAndView;
        }
    }
}

