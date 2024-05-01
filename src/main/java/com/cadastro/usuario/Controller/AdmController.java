package com.cadastro.usuario.Controller;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;

import com.cadastro.usuario.Service.AdmService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class AdmController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private AdmRepository admRepository;
    @Autowired
    private AdmService admService;


    /////////////////////////Tela Home///////////////////////////////////
    @GetMapping("/homeAdm")
    public String home() {
        return "homeAdm"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }
    /*@GetMapping("/homeAdm")
    public ModelAndView home(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView("homeAdm");
        modelAndView.addObject("nome", user.getNome());
        return modelAndView;
    }*/
    /////////////////////////Tela de Cadastro Usuário///////////////////////////////////
    @GetMapping("/cadastroUser")
    public ModelAndView mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return new ModelAndView("/cadastroUser");
    }

    @PostMapping("/cadastroUser")
    public String cadastrarUsuario(@ModelAttribute UsuarioDTO usuarioDTO,
                                   @RequestParam("file") MultipartFile file,
                                   Model model) {
        try {
            if (!file.isEmpty()) {
                usuarioDTO.setFoto(file.getBytes());  // Converting MultipartFile to byte[]
            }
            admService.saveUser(usuarioDTO);
            model.addAttribute("mensagem", "Cadastrado com sucesso!");
        } catch (IOException e) {
            model.addAttribute("mensagem", "Erro ao processar o arquivo!");
        } catch (Exception e) {
            model.addAttribute("mensagem", e.getMessage());
        }
        return "/cadastroUser";
    }


    /////////////////////////Tela de Cadastro Professor///////////////////////////////////
    @GetMapping("/cadastroAdm")
    public ModelAndView showUploadForm(Model model) {
        model.addAttribute("admDTO", new AdmDTO());
        return new ModelAndView("/cadastroAdm");
    }

    @PostMapping("/cadastroAdm")
    public String handleFileUpload(@ModelAttribute AdmDTO admDTO,
                                   @RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        try {
            if (!file.isEmpty()) {
                admDTO.setFoto(file.getBytes());  // Converting MultipartFile to byte[]
            }
            admService.saveAdm(admDTO);
            redirectAttributes.addFlashAttribute("mensagemSucesso", "Cadastrado com sucesso!");
        } catch (IOException e) {
            redirectAttributes.addFlashAttribute("mensagemErro", "Erro ao processar o arquivo!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensagemErro", e.getMessage());
        }
        // Redirecionando para o método GET após o processamento
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
    /////////////////////////API Lista de Professor ///////////////////////////////////
    @RestController
    @RequestMapping("/api/professores")
    public class ProfessorController {
        @Autowired
        private AdmService admService;

        @GetMapping
        public ResponseEntity<List<Adm>> getProfessores() {
            List<Adm> professores = admService.listarTodosOsProfessores();
            return ResponseEntity.ok().body(professores);
        }
    }
}

