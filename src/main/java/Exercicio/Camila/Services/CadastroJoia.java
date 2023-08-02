package Exercicio.Camila.Services;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Repositorys.JoiaRepository;

@Service
public class CadastroJoia {
    private JoiaRepository joiaRepository;

    @Autowired
    public CadastroJoia(JoiaRepository joiaRepository) {
        this.joiaRepository = joiaRepository;
    }

    public void cadastrarJoia(double valor, double peso, String material, int quantidade, String tipo) {
        Joia joia = new Joia(valor, peso, material, quantidade, tipo);
        joiaRepository.save(joia);

    }

    public List<Joia> buscarJoiaPorTipo(String tipo) {
        return joiaRepository.findAllByTipo(tipo);
    }

    public String tipoComMaisValor() {
        List<Joia> joias = joiaRepository.findAll();
        if (joias.isEmpty()) {
            return null;
        }

        Joia maiorValorJoia = joias.stream().max(Comparator.comparingDouble(Joia::getValor)).orElse(null);
        if (maiorValorJoia != null) {
            return maiorValorJoia.getTipo();
        } else {
            return null;
        }
    }
}
