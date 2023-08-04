package Exercicio.Camila.Mappers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;

import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Models.Joia;

@Component
public class JoiaMapper implements IJoiaMapper{
    @Override
    public Joia joiaRequestParaJoia(JoiaRequestDTO joiaRequestDTO) {
        return new Joia(joiaRequestDTO.getValor(), joiaRequestDTO.getPeso(), joiaRequestDTO.getMaterial(), joiaRequestDTO.getQuantidade(), joiaRequestDTO.getTipo());
    }

    @Override
    public JoiaResponseDTO joiaParaJoiaResponse(Joia joia) {
        return new JoiaResponseDTO(joia.getValor(), joia.getPeso(), joia.getMaterial(), joia.getQuantidade(), joia.getTipo());
    }
    
    @Override
    public Collection<JoiaResponseDTO> joiaParaJoiasResponse(Collection<Joia> joias) {
        Collection<JoiaResponseDTO> joiasRespostamappeada = new ArrayList<JoiaResponseDTO>();
        for (Joia joia : joias) {
            joiasRespostamappeada.add(joiaParaJoiaResponse(joia));
        }
        return joiasRespostamappeada;
    }

}
