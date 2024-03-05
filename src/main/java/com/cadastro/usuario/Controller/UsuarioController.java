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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AdmRepository admRepository;

    @GetMapping("/cadastroUser")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "cadastroUser";
    }

    @PostMapping("/cadastroUser")
    public String cadastrarUsuario(Usuario usuario, Model model) {
        try {
            usuarioRepository.save(usuario);
            model.addAttribute("mensagem", "Cadastrado com sucesso !");
        } catch (Exception e) {
            model.addAttribute("mensagem", "Erro ao Cadastrar !");
        }
        return "cadastroUser";
    }


    //////////////////Cadastro Professor/////////////////////

    @GetMapping("/cadastroAdm")
    public String mostrarFormularioDeCadastroAdm(Model model) {
        model.addAttribute("adm", new Adm());
        return "cadastroAdm";
    }
    @PostMapping("/cadastroAdm")
    public String cadastrarAdm(Adm adm, RedirectAttributes redirectAttributes) {
        try {
            admRepository.save(adm);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastrado com sucesso!"); // Mensagem de sucesso
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao Cadastrar!"); // Mensagem de erro
        }
        return "redirect:/cadastroAdm";
    }


    /////////// Tela Teste ///////////
    @GetMapping("/teste")
    public String mostrarFormularioDeCadastroTeste(Model model) {
        model.addAttribute("user", new Usuario());
        return "teste";
    }
    @PostMapping("/teste")
    public String cadastrarTeste(Usuario user, RedirectAttributes redirectAttributes) {
        try {
            usuarioRepository.save(user); // Tenta salvar os dados no banco
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastrado com sucesso!"); // Mensagem de sucesso
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao Cadastrar!"); // Mensagem de erro
        }
        return "redirect:/teste"; // Redireciona para a mesma página para evitar reenvio
    }
}

