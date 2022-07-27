package br.com.digix.pokedigix.personagem;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.pokemon.PokemonBuilder;
import br.com.digix.pokedigix.treinador.Treinador;

public class TreinadorBuilder {
    private String nome;
    private Endereco endereco;
    private Pokemon pokemon;

    public TreinadorBuilder() {
        this.nome = "Ash";
        this.endereco = new EnderecoBuilder().construir();
        this.pokemon = new PokemonBuilder().construir();
    }

    public Treinador construir() {
        return new Treinador(nome, endereco, pokemon);
    }
}