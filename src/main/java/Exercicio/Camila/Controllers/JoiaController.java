package Exercicio.Camila.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import Exercicio.Camila.DTOs.Requests.JoiaRequestDTO;
import Exercicio.Camila.DTOs.Responses.JoiaResponseDTO;
import Exercicio.Camila.Models.Joia;
import Exercicio.Camila.Services.CadastroJoia;
import Exercicio.Camila.Services.JoiaService;

@RestController
@RequestMapping("/joias")
public class JoiaController {

    private JoiaService joiaService;

    @Autowired
    public JoiaController(JoiaService joiaService) {
        this.joiaService = joiaService;
    }

    @PostMapping
    public ResponseEntity<JoiaResponseDTO> cadastrarJoia(@RequestBody JoiaRequestDTO joiaRequestDTO) {
        JoiaResponseDTO joiaResponseDTO = joiaService.cadastrarJoia(joiaRequestDTO);
        return new ResponseEntity<>(joiaResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{tipo}")
    public ResponseEntity<JoiaResponseDTO> buscarJoiaPorTipo(@PathVariable String tipo) {
        JoiaResponseDTO joiaResponseDTO = joiaService.buscarJoiaPorTipo(tipo);
        if (joiaResponseDTO != null) {
            return new ResponseEntity<>(joiaResponseDTO, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/maior-valor")
    public ResponseEntity<String> tipoMaiorValor() {
        String tipoMaiorValor = joiaService.tipoMaiorValor();
        if (tipoMaiorValor != null) {
            return new ResponseEntity<>(tipoMaiorValor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Não há joias cadastradas!", HttpStatus.NOT_FOUND);
        }
    }
}