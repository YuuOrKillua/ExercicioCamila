package Exercicio.Camila.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Repositorys.JoiaRepository;

@Service
public class BuscarJoiaPorTipo {
    @Autowired
    private JoiaRepository joiaRepository;

    public List<Joia> buscarJoiaPorTipo(String tipo) {
        return joiaRepository.findAllByTipo(tipo);
    }
}
