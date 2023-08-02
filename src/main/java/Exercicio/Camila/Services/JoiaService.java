package Exercicio.Camila.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Services.CadastroJoia;

@Service
public class JoiaService {

    private CadastroJoia cadastroJoia;

    @Autowired
    public JoiaService(CadastroJoia cadastroJoia) {
        this.cadastroJoia = cadastroJoia;
    }

    public JoiaResponseDTO cadastrarJoia(JoiaRequestDTO joiaRequestDTO) {
        cadastroJoia.cadastrarJoia(joiaRequestDTO.getValor(), joiaRequestDTO.getPeso(),
                joiaRequestDTO.getMaterial(), joiaRequestDTO.getQuantidade(), joiaRequestDTO.getTipo());

        return new JoiaResponseDTO(joiaRequestDTO.getValor(), joiaRequestDTO.getPeso(),
                joiaRequestDTO.getMaterial(), joiaRequestDTO.getQuantidade(), joiaRequestDTO.getTipo());
    }

    public JoiaResponseDTO buscarJoiaPorTipo(String tipo) {
        Joia joiaEncontrada = cadastroJoia.buscarJoiaPorTipo(tipo);
        if (joiaEncontrada != null) {
            return new JoiaResponseDTO(joiaEncontrada.getValor(), joiaEncontrada.getPeso(),
                    joiaEncontrada.getMaterial(), joiaEncontrada.getQuantidade(), joiaEncontrada.getTipo());
        } else {
            return null;
        }
    }

    public String tipoMaiorValor() {
        return cadastroJoia.tipoComMaisValor();
    }
}