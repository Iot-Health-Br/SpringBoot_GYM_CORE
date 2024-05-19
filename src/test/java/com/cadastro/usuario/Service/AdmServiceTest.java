package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.TrainingDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Exception.TrainingRegistred;
import com.cadastro.usuario.Exception.UserAlreadyExists;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.TrainingUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.TrainingRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AdmServiceTest {

    @Mock
    private AdmRepository admRepository;

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private TrainingRepository trainingRepository;

    @InjectMocks
    private AdmService admService;

    @BeforeEach
    void setUp() {
        try {
            MockitoAnnotations.openMocks(this);
        }catch (Error error){
            error.printStackTrace();
        }

    }

    @Test
    void listarTodosOsTreinos() {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        when(trainingRepository.findExpiredTrainings(thirtyDaysAgo)).thenReturn(Collections.emptyList());

        List<TrainingUser> treinos = admService.listarTodosOsTreinos();

        assertNotNull(treinos);
        assertEquals(0, treinos.size());
        verify(trainingRepository, times(1)).findExpiredTrainings(thirtyDaysAgo);
    }

    @Test
    void listarTodosOsAlunos() {
        when(usuarioRepository.findAll()).thenReturn(Collections.emptyList());

        List<Usuario> alunos = admService.listarTodosOsAlunos();

        assertNotNull(alunos);
        assertEquals(0, alunos.size());
        verify(usuarioRepository, times(1)).findAll();
    }

    @Test
    void listarTodosOsProfessores() {
        when(admRepository.findAll()).thenReturn(Collections.emptyList());

        List<Adm> professores = admService.listarTodosOsProfessores();

        assertNotNull(professores);
        assertEquals(0, professores.size());
        verify(admRepository, times(1)).findAll();
    }

    @Test
    void saveAdm_ThrowsException_WhenAdmExists() {
        AdmDTO admDTO = new AdmDTO();
        admDTO.setCpf("12345678900");
        admDTO.setNome("Professor Teste");

        when(admRepository.existsByCpf(admDTO.getCpf())).thenReturn(true);

        UserAlreadyExists exception = assertThrows(UserAlreadyExists.class, () -> {
            admService.saveAdm(admDTO);
        });

        assertEquals("Professor já cadastrado!", exception.getMessage());
        verify(admRepository, times(1)).existsByCpf(admDTO.getCpf());
    }

    @Test
    void saveUser_ThrowsException_WhenUserExists() {
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setCpf("12345678900");
        usuarioDTO.setNome("Aluno Teste");

        when(usuarioRepository.existsByCpf(usuarioDTO.getCpf())).thenReturn(true);

        UserAlreadyExists exception = assertThrows(UserAlreadyExists.class, () -> {
            admService.saveUser(usuarioDTO);
        });

        assertEquals("Usuário já cadastrado!", exception.getMessage());
        verify(usuarioRepository, times(1)).existsByCpf(usuarioDTO.getCpf());
    }

    @Test
    void saveTreino_Success() throws TrainingRegistred {
        TrainingDTO trainingDTO = new TrainingDTO();
        trainingDTO.setIdUser(1L);
        trainingDTO.setIdTeacher(1L);
        trainingDTO.setDataTreino(LocalDate.now());
        trainingDTO.setVencimentoTreino(LocalDate.now().plusDays(30));

        String result = admService.saveTreino(trainingDTO);

        assertEquals("Treino cadastrado com sucesso!", result);
        verify(trainingRepository, times(1)).save(any(TrainingUser.class));
    }

    @Test
    void saveTreino_Fails_WhenDTOIsNull() throws TrainingRegistred {
        String result = admService.saveTreino(null);

        assertEquals("Erro ao Salvar o treino !", result);
        verify(trainingRepository, times(0)).save(any(TrainingUser.class));
    }
}








/*
**Explicação dos Testes

* setUp(): Inicializa os mocks e os injecta no AdmService.

* listarTodosOsTreinos(): Verifica se o método retorna uma lista vazia quando o repositório retorna uma lista vazia.

* listarTodosOsAlunos(): Verifica se o método retorna uma lista vazia quando o repositório retorna uma lista vazia.

* listarTodosOsProfessores(): Verifica se o método retorna uma lista vazia quando o repositório retorna uma lista vazia.

* saveAdm_ThrowsException_WhenAdmExists(): Verifica se o método lança uma exceção quando um professor com o mesmo CPF já existe.

* saveUser_ThrowsException_WhenUserExists(): Verifica se o método lança uma exceção quando um usuário com o mesmo CPF já existe.

* saveTreino_Success(): Verifica se o método salva com sucesso quando os dados do treino são válidos.

* saveTreino_Fails_WhenDTOIsNull(): Verifica se o método retorna uma mensagem de erro quando o TrainingDTO é nulo.
*/