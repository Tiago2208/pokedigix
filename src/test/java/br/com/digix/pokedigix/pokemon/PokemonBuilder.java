package br.com.digix.pokedigix.pokemon;

import java.util.ArrayList;
import java.util.Collection;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonBuilder {

    private Collection<Ataque> ataques;
    private String nomeEsperado;
    private int nivelEsperado;
    private double alturaEsperada;
    private double pesoEsperado;
    private Genero generoEsperado;
    private int numeroDaPokedexEsperado;
    private int felicidadeEsperada;
    private Collection<Tipo> tiposEsperados;
    private Tipo tipo;

    public PokemonBuilder() {
        this.nomeEsperado = "Charmander";
        this.nivelEsperado = 15;
        this.alturaEsperada = 0.90;
        this.pesoEsperado = 10.0;
        this.generoEsperado = Genero.MASCULINO;
        this.numeroDaPokedexEsperado = 4;
        this.felicidadeEsperada = 100;
        this.tiposEsperados = new ArrayList<>();
        this.ataques = new ArrayList<>();
    }

    public PokemonBuilder comAtaque(Ataque ataque) {
        this.ataques.add(ataque);
        return this;
    }

    public Pokemon construir() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        return new Pokemon(nomeEsperado, nivelEsperado, alturaEsperada, pesoEsperado, generoEsperado, numeroDaPokedexEsperado, felicidadeEsperada, tiposEsperados, ataques);
    }

    public PokemonBuilder comTipo(Tipo tipo) {
        this.tiposEsperados.add(tipo);
        return this;
    }

    public PokemonBuilder comNivel(int nivel) {
        this.nivelEsperado = nivel;
        return this;
    }

    public PokemonBuilder comFelicidade(int felicidade) {
        this.felicidadeEsperada = felicidade;
        return this;
    }
    
}
