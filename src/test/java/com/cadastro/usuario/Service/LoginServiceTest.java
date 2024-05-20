package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.LoginDTO;
import com.cadastro.usuario.Exception.UserNotFound;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.LoginUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import jakarta.servlet.http.HttpSession;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class LoginServiceTest {

    @Mock
    private AdmRepository admRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private HttpSession session;

    @InjectMocks
    private LoginService loginService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void login_Success_Admin() throws UserNotFound {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setCpf("12345678900");
        loginDTO.setSenha("password");

        Adm adm = new Adm();
        adm.setId(1L);
        adm.setFoto("fotoAdmin.jpg".getBytes());
        adm.setNome("Admin Teste");
        adm.setTelefone("123456789");

        when(admRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha())).thenReturn(adm);

        String result = loginService.login(loginDTO, session);

        assertEquals("/homeAdm", result);
        verify(session, times(1)).setAttribute(eq("loggedUser"), any(LoginUser.class));
    }

    @Test
    void login_Success_User() throws UserNotFound {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setCpf("12345678900");
        loginDTO.setSenha("password");

        Usuario user = new Usuario();
        user.setId(1L);
        user.setFoto("fotoUser.jpg".getBytes());
        user.setNome("User Teste");
        user.setTelefone("123456789");

        when(usuarioRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha())).thenReturn(user);

        String result = loginService.login(loginDTO, session);

        assertEquals("/homeUser", result);
        verify(session, times(1)).setAttribute(eq("loggedUser"), any(LoginUser.class));
    }

    @Test
    void login_ThrowsException_UserNotFound() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setCpf("12345678900");
        loginDTO.setSenha("wrongpassword");

        when(admRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha())).thenReturn(null);
        when(usuarioRepository.findByCpfAndSenha(loginDTO.getCpf(), loginDTO.getSenha())).thenReturn(null);

        UserNotFound exception = assertThrows(UserNotFound.class, () -> {
            loginService.login(loginDTO, session);
        });

        assertEquals("Usuário não encontrado", exception.getMessage());
        verify(session, times(0)).setAttribute(eq("loggedUser"), any(LoginUser.class));
    }
}



/*
** Explicação dos Testes

* login_Success_Admin: Verifica se o login é bem-sucedido para um administrador e se a sessão é atualizada corretamente.
* login_Success_User: Verifica se o login é bem-sucedido para um usuário e se a sessão é atualizada corretamente.
* login_ThrowsException_UserNotFound: Verifica se uma exceção UserNotFound é lançada quando nenhum usuário ou administrador é encontrado com as credenciais fornecidas.

 */
