package com.cadastro.usuario.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/homeUser")
    public String home() {
        return "homeUser"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }
}