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
public class AdmController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AdmRepository admRepository;

    /////////////////////////Tela Home///////////////////////////////////
    @GetMapping("/homeAdm")
    public String home() {
        return "homeAdm"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }

    /////////////////////////Tela de Cadastro Usuário///////////////////////////////////

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

    /////////////////////////Tela de Cadastro Professor///////////////////////////////////

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

    /////////////////////////Tela de Teste///////////////////////////////////

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





    /////////////////////////Teste do Luidy///////////////////////////////////

    @GetMapping("/telaTreinoAluno")
    public String mostrarFormularioDeCadastroLuidy(Model model) {
        model.addAttribute("user", new Usuario());
        return "telaTreinoAluno";
    }
    @PostMapping("/telaTreinoAluno")
    public String cadastrarLuidy(Usuario user, RedirectAttributes redirectAttributes) {
        try {
            usuarioRepository.save(user); // Tenta salvar os dados no banco
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastrado com sucesso!"); // Mensagem de sucesso
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao Cadastrar!"); // Mensagem de erro
        }
        return "redirect:/Luidy"; // Redireciona para a mesma página para evitar reenvio
    }




    @GetMapping("/telaMatriculaAluno")
    public String mostrarFormularioDeMatriculaAluno(Model model) {
        model.addAttribute("user", new Usuario());
        return "telaTreinoAluno";
    }
    @PostMapping("/telaMatriculaAluno")
    public String MatricularAluno(Usuario user, RedirectAttributes redirectAttributes) {
        try {
            usuarioRepository.save(user); // Tenta salvar os dados no banco
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastrado com sucesso!"); // Mensagem de sucesso
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao Cadastrar!"); // Mensagem de erro
        }
        return "redirect:/Luidy"; // Redireciona para a mesma página para evitar reenvio
    }
}

