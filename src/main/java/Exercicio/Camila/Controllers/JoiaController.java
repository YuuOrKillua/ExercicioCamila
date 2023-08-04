package Exercicio.Camila.Controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Services.BuscarJoiaPorTipo;
import Exercicio.Camila.Services.BuscarTipoComMaisValor;
import Exercicio.Camila.Services.CadastroJoia;

@RestController
@RequestMapping("/joias")
public class JoiaController {

    @Autowired
    private CadastroJoia cadastroJoia;
    @Autowired
    private BuscarJoiaPorTipo buscarJoiaPorTipo;
    @Autowired
    private BuscarTipoComMaisValor buscarTipoComMaisValor;

    @PostMapping
    public ResponseEntity<JoiaResponseDTO> cadastrarJoia(@RequestBody JoiaRequestDTO joiaRequestDTO) {
        JoiaResponseDTO joiaResponseDTO = cadastroJoia.cadastrarJoia(joiaRequestDTO);
        return new ResponseEntity<>(joiaResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<Collection<JoiaResponseDTO>> buscarJoiaPorTipo(@PathVariable String tipo) {
        Collection<JoiaResponseDTO> joiasResponseDTO = buscarJoiaPorTipo.buscarJoiaPorTipo(tipo);
        if (!joiasResponseDTO.isEmpty()) {
            return new ResponseEntity<>(joiasResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/tipo-com-maior-valor")
    public ResponseEntity<String> tipoComMaisValor() {
        String tipoMaiorValor = buscarTipoComMaisValor.tipoComMaisValor();
        if (tipoMaiorValor != null) {
            return new ResponseEntity<>(tipoMaiorValor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Não há joias cadastradas!", HttpStatus.NOT_FOUND);
        }
    }
}