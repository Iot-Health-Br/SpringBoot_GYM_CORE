package com.cadastro.usuario.Controller;

import com.cadastro.usuario.DTO.LoginDTO;
import com.cadastro.usuario.Exception.UserNotFound;
import com.cadastro.usuario.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

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
        } catch (UserNotFound e) {
            modelAndView.setViewName("/login");
            modelAndView.addObject("error", e.getMessage());
        }
        return modelAndView;
    }
}