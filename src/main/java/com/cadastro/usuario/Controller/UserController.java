package com.cadastro.usuario.Controller;

import ch.qos.logback.core.model.Model;
import com.cadastro.usuario.Model.LoginUser;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;

@Controller
public class UserController {


    /*@GetMapping("/homeUser")
    public String home() {
        return "homeUser"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }*/

    @GetMapping("/homeUser")
    public ModelAndView home(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        ModelAndView modelAndView = new ModelAndView("homeUser");
        modelAndView.addObject("nome", user.getNome());
        return modelAndView;
    }

    /////////////////////////Tela Minha Matricula///////////////////////////////////
    @GetMapping("/matriculaUser")
    public ModelAndView showMatriculaUser(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        ModelAndView modelAndView = new ModelAndView("matriculaUser");
        // Convertendo a imagem para base64
        String base64Encoded = Base64.getEncoder().encodeToString(user.getFoto());
        modelAndView.addObject("foto", base64Encoded);

        modelAndView.addObject("id", user.getId());
        modelAndView.addObject("nome", user.getNome());
        modelAndView.addObject("telefone", user.getTelefone());
        modelAndView.addObject("cpf", user.getCpf());  // Adicionando o CPF ao modelo
        return modelAndView;
    }

}