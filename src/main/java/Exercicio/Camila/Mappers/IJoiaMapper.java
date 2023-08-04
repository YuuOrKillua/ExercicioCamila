package Exercicio.Camila.Mappers;

import java.util.Collection;

import org.mapstruct.Mapper;
import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Models.Joia;

@Mapper(componentModel = "spring")
public interface IJoiaMapper {

    public Joia joiaRequestParaJoia(JoiaRequestDTO joiaRequestDTO);

    public JoiaResponseDTO joiaParaJoiaResponse(Joia joia);

    public Collection<JoiaResponseDTO> joiaParaJoiasResponse(Collection<Joia> joias);
}