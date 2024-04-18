package com.cadastro.usuario.Controller;

import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    private UsuarioRepository userRepository;
    @Autowired
    private AdmRepository admRepository;

    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    // Inclua isso para limpar o atributo quando necessário
    @GetMapping("/logout")
    public String logout(SessionStatus status) {
        status.setComplete();
        return "redirect:/login";
    }

    @PostMapping("/login")
    public ModelAndView processLogin(@RequestParam("cpf") String cpf, @RequestParam("senha") String senha, HttpSession session) {
        Optional<Adm> adm = admRepository.findByCpfAndSenha(cpf, senha);
        Optional<Usuario> user = userRepository.findByCpfAndSenha(cpf, senha);

        if (adm.isPresent()) {
            Adm admin = adm.get();
            LoginUser loginUser = new LoginUser();
            loginUser.setNome(admin.getNome());
            loginUser.setTelefone(admin.getTelefone());
            session.setAttribute("user", loginUser);
            return new ModelAndView("redirect:/homeAdm");
        }
        else if (user.isPresent()) {
            Usuario usuario = user.get();
            LoginUser loginUser = new LoginUser();
            loginUser.setNome(usuario.getNome());
            loginUser.setTelefone(usuario.getTelefone());
            session.setAttribute("user", loginUser);
            return new ModelAndView("redirect:/homeUser");
        }
        else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("error", "Usuário não encontrado");
            return modelAndView;
        }
    }
}
