package Exercicio.Camila.DTOs.Responses;

import lombok.Getter;

@Getter
public class JoiaResponseDTO {
    private double valor;
    private double peso;
    private String material;
    private int quantidade;
    private String tipo;

    //No args
    public JoiaResponseDTO(){

    }

    //All args
    public JoiaResponseDTO(double valor, double peso, String material, int quantidade, String tipo) {
        this.valor = valor;
        this.peso = peso;
        this.material = material;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }
}
