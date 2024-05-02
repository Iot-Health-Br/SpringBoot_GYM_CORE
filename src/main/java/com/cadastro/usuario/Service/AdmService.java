package com.cadastro.usuario.Service;

import com.cadastro.usuario.DTO.AdmDTO;
import com.cadastro.usuario.DTO.UsuarioDTO;
import com.cadastro.usuario.Exception.UserRegistred;
import com.cadastro.usuario.Exception.UserAlreadyExists;
import com.cadastro.usuario.Model.Adm;
import com.cadastro.usuario.Model.Usuario;
import com.cadastro.usuario.Repository.AdmRepository;
import com.cadastro.usuario.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    //@Autowired
    //private ModelMapper modelMapper;

    public List<Adm> listarTodosOsProfessores() {
        return admRepository.findAll();
    }

    public String saveAdm(AdmDTO admDTO) throws UserAlreadyExists {
        boolean cpfExists = admRepository.existsByCpf(admDTO.getCpf());
        boolean nomeExists = admRepository.existsByNome(admDTO.getNome());
        if (cpfExists || nomeExists) {
            throw new UserAlreadyExists("Usuário já cadastrado!");
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


    public String saveUser(UsuarioDTO usuarioDTO) throws UserAlreadyExists {
        boolean cpfExists = usuarioRepository.existsByCpf(usuarioDTO.getCpf());
        boolean nomeExists = usuarioRepository.existsByNome(usuarioDTO.getNome());
        if (cpfExists || nomeExists) {
            throw new UserAlreadyExists("Usuário já cadastrado!");
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
}
