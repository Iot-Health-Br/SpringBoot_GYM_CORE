package com.cadastro.usuario.Controller;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private AdmRepository admRepository;

    @GetMapping("/cadastro")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastroUser";
    }

    @PostMapping("/cadastro")
    public String cadastrarUsuario(Usuario usuario, Model model) {
        try {
            usuarioRepository.save(usuario);
            model.addAttribute("mensagem", "Cadastrado com sucesso !");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao Cadastrar !");
        }
        return "cadastroUser";
    }

    @GetMapping("/cadastroAdm")
    public String mostrarFormularioDeCadastroAdm(Model model) {
        model.addAttribute("adm", new Adm());
        return "cadastroAdm";
    }
    @PostMapping("/cadastroAdm")
    public String cadastrarAdm(Adm adm, Model model) {
        try {
            admRepository.save(adm);
            model.addAttribute("mensagem", "Cadastrado com sucesso !");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao Cadastrar !");
        }
        return "cadastroAdm";
    }
}

