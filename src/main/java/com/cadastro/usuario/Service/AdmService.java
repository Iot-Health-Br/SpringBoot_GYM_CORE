package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.TrainingDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Exception.TrainingAlreadyExists;
import com.cadastro.usuario.Exception.TrainingRegistred;
import com.cadastro.usuario.Exception.UserRegistred;
import com.cadastro.usuario.Exception.UserAlreadyExists;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.TrainingUser;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.TrainingRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    /*
    @Autowired
    private ModelMapper modelMapper;*/

    //Lista de Alunos
    public List<Usuario> listarTodosOsAlunos() {
        return usuarioRepository.findAll();
    }
    //Lista de Professores
    public List<Adm> listarTodosOsProfessores() {
        return admRepository.findAll();
    }

    // Verifica se os dados do professor ja está cadastrado, só dps salva.
    public String saveAdm(AdmDTO admDTO) throws UserAlreadyExists {
        boolean cpfAdm = admRepository.existsByCpf(admDTO.getCpf());
        boolean nomeAdm = admRepository.existsByNome(admDTO.getNome());
        boolean cpfUser = usuarioRepository.existsByCpf(admDTO.getCpf());
        boolean nomeUser = usuarioRepository.existsByNome(admDTO.getNome());
        if (cpfAdm || nomeAdm) {
            throw new UserAlreadyExists("Professor já cadastrado!");
        }
        else if (cpfUser || nomeUser ) {
            throw new UserAlreadyExists("Dados já cadastrado na Tabela Usuário!");
        }
        else {
                Adm adm = new Adm();
                adm.setNome(admDTO.getNome());
                adm.setNascimento(admDTO.getNascimento());
                adm.setGenero(admDTO.getGenero());
                adm.setEstadoCivil(admDTO.getEstadoCivil());
                adm.setEndereco(admDTO.getEndereco());
                adm.setTelefone(admDTO.getTelefone());
                adm.setEmail(admDTO.getEmail());
                adm.setCpf(admDTO.getCpf());
                adm.setSenha(admDTO.getSenha());
                adm.setFoto(admDTO.getFoto());
                adm.setCategoria(admDTO.getCategoria());
                admRepository.save(adm);
                return "Usuário cadastrado com sucesso!";
        }
    }

    /*
    // Definindo o ModelMapper como um bean no seu contexto do Spring
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public void saveUser(UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario user = modelMapper.map(usuarioDTO, Usuario.class);

        try {
            usuarioRepository.save(user);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar o Aluno", e);
        }
    }*/

    // Verifica se os dados do Aluno ja está cadastrado, só dps salva.
    public String saveUser(UsuarioDTO usuarioDTO) throws UserAlreadyExists {
        boolean cpfUser = usuarioRepository.existsByCpf(usuarioDTO.getCpf());
        boolean nomeUser = usuarioRepository.existsByNome(usuarioDTO.getNome());
        boolean cpfAdm = admRepository.existsByCpf(usuarioDTO.getCpf());
        boolean nomeAdm = admRepository.existsByNome(usuarioDTO.getNome());
        if (cpfUser || nomeUser) {
            throw new UserAlreadyExists("Usuário já cadastrado!");
        }
        else if (cpfAdm || nomeAdm) {
            throw new UserAlreadyExists("Dados já cadastrado na Tabela Adm!");
        }
        else {
            Usuario user = new Usuario();
            user.setNome(usuarioDTO.getNome());
            user.setNascimento(usuarioDTO.getNascimento());
            user.setGenero(usuarioDTO.getGenero());
            user.setEstadoCivil(usuarioDTO.getEstadoCivil());
            user.setEndereco(usuarioDTO.getEndereco());
            user.setTelefone(usuarioDTO.getTelefone());
            user.setEmail(usuarioDTO.getEmail());
            user.setCpf(usuarioDTO.getCpf());
            user.setSenha(usuarioDTO.getSenha());
            user.setFoto(usuarioDTO.getFoto());
            user.setCategoria(usuarioDTO.getCategoria());

            user.setAltura(usuarioDTO.getAltura());
            user.setPeso(usuarioDTO.getPeso());
            user.setIMC(usuarioDTO.getIMC());
            user.setPa(usuarioDTO.getPa());
            user.setDoencas(usuarioDTO.getDoencas());
            user.setLimitacaoFisica(usuarioDTO.getLimitacaoFisica());
            user.setRestricoesAlimentar(usuarioDTO.getRestricoesAlimentar());
            user.setUsoMedicamento(usuarioDTO.getUsoMedicamento());
            user.setHitoricoCirugico(usuarioDTO.getHitoricoCirugico());
            user.setPagamento(usuarioDTO.getPagamento());
            user.setDataMatricula(usuarioDTO.getDataMatricula());
            user.setVencimentoMatricula(usuarioDTO.getVencimentoMatricula());
            user.setPlano(usuarioDTO.getPlano());
            user.setProfessorResponsavel(usuarioDTO.getProfessorResponsavel());
            user.setObjetivo(usuarioDTO.getObjetivo());
            user.setExperiencia(usuarioDTO.getExperiencia());
            user.setAtividadesFisicas(usuarioDTO.getAtividadesFisicas());
            user.setNivelCondicionamento(usuarioDTO.getNivelCondicionamento());
            user.setExpectitativa(usuarioDTO.getExpectitativa());
            usuarioRepository.save(user);
            return "Usuário cadastrado com sucesso!";
        }
    }

    /// Utilizando a bliblioteca Mapper para salvar o objeto

    public String saveTreino(TrainingDTO trainingDTO) throws TrainingRegistred {
        if (trainingDTO != null){
            TrainingUser treino = new TrainingUser(trainingDTO);
            trainingRepository.save(treino);
            return "Treino cadastrado com sucesso!";
        }
        else {
            return "Erro ao Salvar o treino !";
        }
    }


    /*
    // Definindo o ModelMapper como um bean no seu contexto do Spring
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    public String saveTreino(TrainingDTO trainingDTO) throws TrainingRegistred {
        if(trainingDTO != null){
            TrainingUser treino = modelMapper.map(trainingDTO, TrainingUser.class);
            trainingRepository.save(treino);
            return "Treino cadastrado com sucesso!";
        }
        else {
            return "Erro ao Salvar o treino !";
        }

    }*/
}
