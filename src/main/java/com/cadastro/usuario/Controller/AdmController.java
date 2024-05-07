package com.cadastro.usuario.Controller;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.TrainingDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Exception.TrainingAlreadyExists;
import com.cadastro.usuario.Exception.TrainingRegistred;
import com.cadastro.usuario.Exception.UserRegistred;
import com.cadastro.usuario.Exception.UserAlreadyExists;
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
    /*@GetMapping("/homeAdm")
    public String home() {
        return "homeAdm"; // Retorna o nome do arquivo homeAdm.html que está em src/main/resources/templates
    }*/
    @GetMapping("/homeAdm")
    public ModelAndView home(HttpSession session) {
        LoginUser user = (LoginUser) session.getAttribute("loggedUser");
        ModelAndView modelAndView = new ModelAndView("homeAdm");
        modelAndView.addObject("nome", user.getNome());
        return modelAndView;
    }


    /////////////////////////Tela de Cadastro Usuário///////////////////////////////////
    @GetMapping("/cadastroUser")
    public ModelAndView mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return new ModelAndView("/cadastroUser");
    }

    @PostMapping("/cadastroUser")
    public String cadastrarUsuario(@ModelAttribute UsuarioDTO usuarioDTO, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (!file.isEmpty()) {
                usuarioDTO.setFoto(file.getBytes());
            }
            // Captura a mensagem de retorno do serviço
            String resultado = admService.saveUser(usuarioDTO);
            redirectAttributes.addFlashAttribute("mensagemSucesso", resultado);
            return "redirect:/cadastroUser";
        }
        catch (UserAlreadyExists e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuarioDTO", usuarioDTO); // Adiciona o DTO ao model para manter os dados no formulário
            return "cadastroUser"; // Retorna a view sem redirecionamento
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




    /////////////////////////Tela de Cadastro Professor///////////////////////////////////
    @GetMapping("/cadastroAdm")
    public ModelAndView showUploadForm(Model model) {
        model.addAttribute("admDTO", new AdmDTO());
        return new ModelAndView("/cadastroAdm");
    }

    @PostMapping("/cadastroAdm")
    public String handleFileUpload(@ModelAttribute AdmDTO admDTO, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (!file.isEmpty()) {
                admDTO.setFoto(file.getBytes());
            }
            // Captura a mensagem de retorno do serviço
            String resultado = admService.saveAdm(admDTO);
            redirectAttributes.addFlashAttribute("mensagemSucesso", resultado);
            return "redirect:/cadastroAdm";
        }
        catch (UserAlreadyExists e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("admDTO", admDTO); // Adiciona o DTO ao model para manter os dados no formulário
            return "cadastroAdm"; // Retorna a view sem redirecionamento
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /////////////////////////Tela de Cadastro de Treino ///////////////////////////////////
    @GetMapping("/treinoAluno")
    public ModelAndView getTreinoAluno(Model model) {
        model.addAttribute("trainingDTO", new TrainingDTO());
        return new ModelAndView("/treinoAluno");
    }

    @PostMapping("/treinoAluno")
    public String postTreinoAluno(@ModelAttribute TrainingDTO trainingDTO, RedirectAttributes redirectAttributes, Model model) {
        try {
            // Captura a mensagem de retorno do serviço
            String resultado = admService.saveTreino(trainingDTO);
            redirectAttributes.addFlashAttribute("mensagemSucesso", resultado);
            return "redirect:/treinoAluno";
        }
        catch (TrainingRegistred e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("trainingDTO", trainingDTO); // Adiciona o DTO ao model para manter os dados no formulário
            return "treinoAluno"; // Retorna a view sem redirecionamento
        }

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


    /////////////////////////API Lista de Alunos ///////////////////////////////////
    @RestController
    @RequestMapping("/api/alunos")
    public class AlunosController {
        @GetMapping
        public ResponseEntity<List<Usuario>> getAlunos() {
            List<Usuario> alunos = admService.listarTodosOsAlunos();
            return ResponseEntity.ok().body(alunos);
        }
    }
    /////////////////////////API Lista de Professor ///////////////////////////////////
    @RestController
    @RequestMapping("/api/professores")
    public class ProfessorController {
        @GetMapping
        public ResponseEntity<List<Adm>> getProfessores() {
            List<Adm> professores = admService.listarTodosOsProfessores();
            return ResponseEntity.ok().body(professores);
        }
    }
}

