package com.cadastro.usuario.Controller;

import com.cadastro.usuario.Model.LoginUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {


    @GetMapping("/homeUser")
    public String home() {
        return "homeUser"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }

    /*@GetMapping("/homeUser")
    public ModelAndView home(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("homeUser");
        modelAndView.addObject("nome", user.getNome());
        return modelAndView;
    }*/

    /////////////////////////Tela Minha Matricula///////////////////////////////////
    @GetMapping("/matriculaUser")
    public ModelAndView showMatriculaUser(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("matriculaUser");
        modelAndView.addObject("nome", user.getNome());
        modelAndView.addObject("telefone", user.getTelefone());
        return modelAndView;
    }
}