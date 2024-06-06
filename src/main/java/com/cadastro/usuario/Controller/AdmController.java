package com.cadastro.usuario.Controller;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.TrainingDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Exception.TrainingRegistred;
import com.cadastro.usuario.Exception.UserAlreadyExists;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.TrainingUser;
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

    /////////////////////////-- Manter Usuário --///////////////////////////////////

    @GetMapping("/manterAluno")
    public ModelAndView FormularioDeCadastroUser(Model model) {
        model.addAttribute("usuarioDTO", new UsuarioDTO());
        return new ModelAndView("/manterAluno");
    }
    @PostMapping("/manterAluno")
    public String manterUsuario(@ModelAttribute UsuarioDTO usuarioDTO, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Model model) {
        try {
            if (!file.isEmpty()) {
                usuarioDTO.setFoto(file.getBytes());
            }
            // Captura a mensagem de retorno do serviço
            String resultado = admService.saveUser(usuarioDTO);
            redirectAttributes.addFlashAttribute("mensagemSucesso", resultado);
            return "redirect:/manterAluno";
        }
        catch (UserAlreadyExists e) {
            model.addAttribute("error", e.getMessage());
            model.addAttribute("usuarioDTO", usuarioDTO); // Adiciona o DTO ao model para manter os dados no formulário
            return "manterAluno"; // Retorna a view sem redirecionamento
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @GetMapping("/manterAluno/{id}")
    public ResponseEntity<UsuarioDTO> getUsuarioById(@PathVariable Long id) {
        Usuario usuario = admService.findUsuarioById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        UsuarioDTO dto = convertToDTO(usuario);
        return ResponseEntity.ok(dto);
    }

    private UsuarioDTO convertToDTO(Usuario usuario) {
        // Aqui você pode usar ModelMapper ou mapear manualmente
        UsuarioDTO dto = new UsuarioDTO();
        dto.setId(usuario.getId());
        dto.setNome(usuario.getNome());
        dto.setCpf(usuario.getCpf());
        dto.setFoto(usuario.getFoto());
        dto.setNascimento(usuario.getNascimento());
        dto.setGenero(usuario.getGenero());
        dto.setEstadoCivil(usuario.getEstadoCivil());
        dto.setEndereco(usuario.getEndereco());
        dto.setTelefone(usuario.getTelefone());
        dto.setEmail(usuario.getEmail());
        dto.setSenha(usuario.getSenha());

        ///Informações da saúde
        dto.setAltura(usuario.getAltura());
        dto.setPeso(usuario.getPeso());
        dto.setIMC(usuario.getIMC());
        dto.setPa(usuario.getPa());
        dto.setDoencas(usuario.getDoencas());
        dto.setLimitacaoFisica(usuario.getLimitacaoFisica());
        dto.setRestricoesAlimentar(usuario.getRestricoesAlimentar());
        dto.setUsoMedicamento(usuario.getUsoMedicamento());
        dto.setHitoricoCirugico(usuario.getHitoricoCirugico());

        ///Dados Pagamento
        dto.setVencimentoMatricula(usuario.getVencimentoMatricula());
        dto.setPlano(usuario.getPlano());
        dto.setProfessorResponsavel(usuario.getProfessorResponsavel());

        // Objetivos
        dto.setExperiencia(usuario.getExperiencia());
        dto.setNivelCondicionamento(usuario.getNivelCondicionamento());
        dto.setObjetivo(usuario.getObjetivo());
        dto.setAtividadesFisicas(usuario.getAtividadesFisicas());
        dto.setExpectitativa(usuario.getExpectitativa());
        // Complete o mapeamento com todos os campos necessários
        return dto;
    }

    @PostMapping("/manterAluno/update")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {
        return admService.saveUsuario(usuario);
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
    public String showForm(Model model) {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setStatus(true); // Setando o valor padrão como true
        model.addAttribute("trainingDTO", trainingDTO);
        return "treinoAluno"; // nome da página HTML
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


    /////////////////////////*** API Lista de Alunos ***///////////////////////////////////
    @RestController
    @RequestMapping("/api/alunos")
    public class AlunosController {
        @GetMapping
        public ResponseEntity<List<Usuario>> getAlunos() {
            List<Usuario> alunos = admService.listarTodosOsAlunos();
            return ResponseEntity.ok().body(alunos);
        }
    }
    /////////////////////////*** API Lista de Professor ***///////////////////////////////////
    @RestController
    @RequestMapping("/api/professores")
    public class ProfessorController {
        @GetMapping
        public ResponseEntity<List<Adm>> getProfessores() {
            List<Adm> professores = admService.listarTodosOsProfessores();
            return ResponseEntity.ok().body(professores);
        }
    }
    /////////////////////////*** API Lista de Treinos ***///////////////////////////////////
    @Controller
    public class TreinosController {
        @GetMapping("/treinoAtualizar")
        public String showExpiredTrainings(Model model) {
            List<TrainingUser> expiredTrainings = admService.listarTodosOsTreinos();
            model.addAttribute("treinoTabela", expiredTrainings);
            return "treinoAtualizar"; // Nome do arquivo HTML
        }
    }

}

