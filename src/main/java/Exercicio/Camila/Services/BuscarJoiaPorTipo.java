package Exercicio.Camila.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Mappers.JoiaMapper;
import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Repositorys.JoiaRepository;

@Service
public class BuscarJoiaPorTipo {
    @Autowired
    private JoiaRepository joiaRepository;
    @Autowired
    JoiaMapper joiaMapper;

    public Collection<JoiaResponseDTO> buscarJoiaPorTipo(String tipo) {
        Collection<Joia> joiasTipo = joiaRepository.findAllByTipo(tipo);
        return joiaMapper.joiaParaJoiasResponse(joiasTipo);
    }
}
