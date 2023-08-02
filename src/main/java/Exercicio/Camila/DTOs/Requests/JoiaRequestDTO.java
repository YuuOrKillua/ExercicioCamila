package Exercicio.Camila.DTOs.Requests;

import lombok.Getter;

@Getter
public class JoiaRequestDTO {
    private double valor;
    private double peso;
    private String material;
    private int quantidade;
    private String tipo;

    //No args
    public JoiaRequestDTO(){

    }

    //All args
    public JoiaRequestDTO(double valor, double peso, String material, int quantidade, String tipo) {
        this.valor = valor;
        this.peso = peso;
        this.material = material;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }
}
