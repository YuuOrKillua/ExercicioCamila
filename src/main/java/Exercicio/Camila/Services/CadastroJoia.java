package Exercicio.Camila.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import Exercicio.Camila.Models.Joia;

@Service
public class CadastroJoia {
    private List<Joia> joias;

    public CadastroJoia() {
        joias = new ArrayList<>();
    }

    public void cadastrarJoia(double valor, double peso, String material, int quantidade, String tipo) {
        Joia joia = new Joia(valor, peso, material, quantidade, tipo);
        joias.add(joia);
    }

    public Joia buscarJoiaPorTipo(String tipo) {
        for (Joia joia : joias) {
            if (joia.getTipo().equalsIgnoreCase(tipo)) {
                return joia;
            }
        }
        return null;
    }

    public String tipoComMaisValor() {
        if (joias.isEmpty()) {
            return null;
        }

        Joia maiorValorJoia = joias.get(0);
        for (Joia joia : joias) {
            if (joia.getValor() > maiorValorJoia.getValor()) {
                maiorValorJoia = joia;
            }
        }

        return maiorValorJoia.getTipo();
    }
}
