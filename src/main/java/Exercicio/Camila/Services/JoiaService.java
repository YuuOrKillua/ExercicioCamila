package Exercicio.Camila.Services;

import java.util.ArrayList;
import java.util.List;

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

    public List<JoiaResponseDTO> buscarJoiasPorTipo(String tipo) {
        List<Joia> joiasEncontradas = cadastroJoia.buscarJoiaPorTipo(tipo);
        List<JoiaResponseDTO> joiasResponseDTO = new ArrayList<>();

        for (Joia joia : joiasEncontradas) {
            JoiaResponseDTO dto = new JoiaResponseDTO(joia.getValor(), joia.getPeso(),
                    joia.getMaterial(), joia.getQuantidade(), joia.getTipo());
            joiasResponseDTO.add(dto);
        }

        return joiasResponseDTO;
    }

    public String tipoComMaisValor() {
        return cadastroJoia.tipoComMaisValor();
    }
}