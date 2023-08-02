package Exercicio.Camila.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.ToString;

@Entity
@ToString
@Table(name="joias")
@Getter
public class Joia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private double valor;
    private double peso;
    private String material;
    private int quantidade;
    private String tipo;

    public Joia() {
        
    }

    public Joia(double valor, double peso, String material, int quantidade, String tipo) {
        this.valor = valor;
        this.peso = peso;
        this.material = material;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
