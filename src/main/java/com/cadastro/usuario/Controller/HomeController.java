package com.cadastro.usuario.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home() {
        return "home"; // Retorna o nome do arquivo home.html que está em src/main/resources/templates
    }
}

