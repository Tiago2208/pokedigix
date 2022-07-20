package br.com.digix.pokedigix.treinador;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.pokemon.Pokemon;

public class Treinador {
    private String nome;
    private int nivel;
    private int dinheiro;
    private Endereco endereco;
    Pokemon pokemon;

    public Treinador(String nome, int nivel, int dinheiro, Endereco endereco) {
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
    public int getDinheiro() {
        return dinheiro;
    }
    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
