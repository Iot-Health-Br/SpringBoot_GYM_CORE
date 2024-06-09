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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AdmService {
    @Autowired
    private AdmRepository admRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TrainingRepository trainingRepository;

    public List<TrainingUser> listarTodosOsTreinos() {
        LocalDate thirtyDaysAgo = LocalDate.now().minusDays(30);
        return trainingRepository.findExpiredTrainings(thirtyDaysAgo);
    }

    //Lista de Alunos
    public List<Usuario> listarTodosOsAlunos() {
        return usuarioRepository.findAll();
    }
    //Lista de Professores
    public List<Adm> listarTodosOsProfessores() {
        return admRepository.findAll();
    }

    public Usuario findUsuarioById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
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
            user.setSick(usuarioDTO.getSick());
            user.setLimitacaoFisica(usuarioDTO.getLimitacaoFisica());
            user.setRestricoesAlimentar(usuarioDTO.getRestricoesAlimentar());
            user.setUsoMedicamento(usuarioDTO.getUsoMedicamento());
            user.setSurgicalHistory(usuarioDTO.getSurgicalHistory());
            user.setPagamento(true);
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

            List<TrainingUser> lastTrainings = trainingRepository.findLastTrainingByUserId(trainingDTO.getIdUser());
            if (!lastTrainings.isEmpty()) {
                TrainingUser lastTraining = lastTrainings.get(0);
                System.out.println("Último treino encontrado: " + lastTraining); // Log
                if (lastTraining.getStatus()) {
                    lastTraining.setStatus(false);
                    trainingRepository.save(lastTraining); // Salva o treino anterior com status falso
                    System.out.println("Status do último treino alterado para falso."); // Log
                }
            }

            TrainingUser treino = new TrainingUser();
            treino.setIdUser(trainingDTO.getIdUser());
            treino.setNameUser(trainingDTO.getNameUser());

            treino.setIdTeacher(trainingDTO.getIdTeacher());
            treino.setNameTeacher(trainingDTO.getNameTeacher());

            treino.setDataTreino(trainingDTO.getDataTreino());
            treino.setVencimentoTreino(trainingDTO.getVencimentoTreino());
            treino.setStatus(trainingDTO.getStatus());

            // Atribuições para exercícios de costa
            treino.setDiaCosta(trainingDTO.getDiaCosta());
            treino.setExercicio_Costa(trainingDTO.getExercicio_Costa());
            treino.setCosta_Serie(trainingDTO.getCosta_Serie());
            treino.setCosta_Repeticao(trainingDTO.getCosta_Repeticao());
            treino.setExercicio_Costa2(trainingDTO.getExercicio_Costa2());
            treino.setCosta_Serie2(trainingDTO.getCosta_Serie2());
            treino.setCosta_Repeticao2(trainingDTO.getCosta_Repeticao2());
            treino.setExercicio_Costa3(trainingDTO.getExercicio_Costa3());
            treino.setCosta_Serie3(trainingDTO.getCosta_Serie3());
            treino.setCosta_Repeticao3(trainingDTO.getCosta_Repeticao3());

            // Atribuições para exercícios de peito
            treino.setDiaPeito(trainingDTO.getDiaPeito());
            treino.setExercicio_Peito(trainingDTO.getExercicio_Peito());
            treino.setPeito_Serie(trainingDTO.getPeito_Serie());
            treino.setPeito_Repeticao(trainingDTO.getPeito_Repeticao());
            treino.setExercicio_Peito2(trainingDTO.getExercicio_Peito2());
            treino.setPeito_Serie2(trainingDTO.getPeito_Serie2());
            treino.setPeito_Repeticao2(trainingDTO.getPeito_Repeticao2());
            treino.setExercicio_Peito3(trainingDTO.getExercicio_Peito3());
            treino.setPeito_Serie3(trainingDTO.getPeito_Serie3());
            treino.setPeito_Repeticao3(trainingDTO.getPeito_Repeticao3());

            // Atribuições para exercícios de bíceps
            treino.setDiaBicipes(trainingDTO.getDiaBicipes());
            treino.setExercicio_Bicipes(trainingDTO.getExercicio_Bicipes());
            treino.setBicipes_Serie(trainingDTO.getBicipes_Serie());
            treino.setBicipes_Repeticao(trainingDTO.getBicipes_Repeticao());
            treino.setExercicio_Bicipes2(trainingDTO.getExercicio_Bicipes2());
            treino.setBicipes_Serie2(trainingDTO.getBicipes_Serie2());
            treino.setBicipes_Repeticao2(trainingDTO.getBicipes_Repeticao2());
            treino.setExercicio_Bicipes3(trainingDTO.getExercicio_Bicipes3());
            treino.setBicipes_Serie3(trainingDTO.getBicipes_Serie3());
            treino.setBicipes_Repeticao3(trainingDTO.getBicipes_Repeticao3());

            // Atribuições para exercícios de tríceps
            treino.setDiaTricipes(trainingDTO.getDiaTricipes());
            treino.setExercicio_Tricipes(trainingDTO.getExercicio_Tricipes());
            treino.setTricipes_Serie(trainingDTO.getTricipes_Serie());
            treino.setTricipes_Repeticao(trainingDTO.getTricipes_Repeticao());
            treino.setExercicio_Tricipes2(trainingDTO.getExercicio_Tricipes2());
            treino.setTricipes_Serie2(trainingDTO.getTricipes_Serie2());
            treino.setTricipes_Repeticao2(trainingDTO.getTricipes_Repeticao2());
            treino.setExercicio_Tricipes3(trainingDTO.getExercicio_Tricipes3());
            treino.setTricipes_Serie3(trainingDTO.getTricipes_Serie3());
            treino.setTricipes_Repeticao3(trainingDTO.getTricipes_Repeticao3());

            // Atribuições para exercícios de ombro
            treino.setDiaOmbro(trainingDTO.getDiaOmbro());
            treino.setExercicio_Ombro(trainingDTO.getExercicio_Ombro());
            treino.setOmbro_Serie(trainingDTO.getOmbro_Serie());
            treino.setOmbro_Repeticao(trainingDTO.getOmbro_Repeticao());
            treino.setExercicio_Ombro2(trainingDTO.getExercicio_Ombro2());
            treino.setOmbro_Serie2(trainingDTO.getOmbro_Serie2());
            treino.setOmbro_Repeticao2(trainingDTO.getOmbro_Repeticao2());
            treino.setExercicio_Ombro3(trainingDTO.getExercicio_Ombro3());
            treino.setOmbro_Serie3(trainingDTO.getOmbro_Serie3());
            treino.setOmbro_Repeticao3(trainingDTO.getOmbro_Repeticao3());

            // Atribuições para exercícios de trapézio
            treino.setDiaTrapezio(trainingDTO.getDiaTrapezio());
            treino.setExercicio_Trapezio(trainingDTO.getExercicio_Trapezio());
            treino.setTrapezio_Serie(trainingDTO.getTrapezio_Serie());
            treino.setTrapezio_Repeticao(trainingDTO.getTrapezio_Repeticao());
            treino.setExercicio_Trapezio2(trainingDTO.getExercicio_Trapezio2());
            treino.setTrapezio_Serie2(trainingDTO.getTrapezio_Serie2());
            treino.setTrapezio_Repeticao2(trainingDTO.getTrapezio_Repeticao2());
            treino.setExercicio_Trapezio3(trainingDTO.getExercicio_Trapezio3());
            treino.setTrapezio_Serie3(trainingDTO.getTrapezio_Serie3());
            treino.setTrapezio_Repeticao3(trainingDTO.getTrapezio_Repeticao3());

            // Atribuições para exercícios de perna
            treino.setDiaPerna(trainingDTO.getDiaPerna());
            treino.setExercicio_Perna(trainingDTO.getExercicio_Perna());
            treino.setPerna_Serie(trainingDTO.getPerna_Serie());
            treino.setPerna_Repeticao(trainingDTO.getPerna_Repeticao());
            treino.setExercicio_Perna2(trainingDTO.getExercicio_Perna2());
            treino.setPerna_Serie2(trainingDTO.getPerna_Serie2());
            treino.setPerna_Repeticao2(trainingDTO.getPerna_Repeticao2());
            treino.setExercicio_Perna3(trainingDTO.getExercicio_Perna3());
            treino.setPerna_Serie3(trainingDTO.getPerna_Serie3());
            treino.setPerna_Repeticao3(trainingDTO.getPerna_Repeticao3());

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
