package br.com.digix.pokedigix.treinador;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.com.digix.pokedigix.endereco.Endereco;


@Entity
public class Treinador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;
    
    
    private String nome;
    
    private int nivel;
    
    private double dinheiro;
    
    @OneToOne
    private Endereco endereco;
    

    public Treinador(String nome, int nivel, double dinheiro, Endereco endereco) {
        this.nome = nome;
        this.nivel = nivel;
        this.dinheiro = dinheiro;
        this.endereco = endereco;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public double getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(double dinheiro) {
        this.dinheiro = dinheiro;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public Long getId() {
        return this.id;
    }
}
