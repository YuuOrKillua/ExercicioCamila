package Exercicio.Camila.Services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Repositorys.JoiaRepository;

@Service
public class BuscarTipoComMaisValor {
    @Autowired
    private JoiaRepository joiaRepository;

    public String tipoComMaisValor() {
        List<Joia> joias = joiaRepository.findAll();
        if (joias.isEmpty()) {
            return null;
        }
        Joia maiorValorJoia = joias.stream().max(Comparator.comparingDouble(Joia::getValor)).orElse(null);
        return maiorValorJoia.getTipo();
    }
}
