package Exercicio.Camila.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Mappers.JoiaMapper;
import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Repositorys.JoiaRepository;

@Service
public class CadastroJoia {

    @Autowired
    private JoiaRepository joiaRepository;
    @Autowired
    private JoiaMapper joiaMapper;

    public JoiaResponseDTO cadastrarJoia(JoiaRequestDTO joiaRequestDTO) {
        Joia joia= joiaMapper.joiaRequestParaJoia(joiaRequestDTO);
        joiaRepository.save(joia);
        return joiaMapper.joiaParaJoiaResponse(joia);
    }
}
