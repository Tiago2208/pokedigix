
package br.com.digix.pokedigix.treinador;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.digix.pokedigix.endereco.Endereco;
import br.com.digix.pokedigix.lider.Insignia;
import br.com.digix.pokedigix.personagem.LimiteDePokemonException;
import br.com.digix.pokedigix.personagem.Personagem;
import br.com.digix.pokedigix.pokemon.Pokemon;

@Entity
public class Treinador extends Personagem {
    private static final int LIMITE_POKEMON = 6;
    @Column(nullable = false)
    private int dinheiro;
    @Column(nullable = false)
    private int nivel;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Insignia.class)
    @Column(name = "insignia")
    private Collection<Insignia> insignias;

    public Treinador(String nome, Endereco endereco, 
                    Pokemon primeiroPokemon) throws LimiteDePokemonException {
        super(nome, endereco);
        this.capturar(primeiroPokemon);
        this.dinheiro = 3000;
        this.nivel = 1;
        this.insignias = new ArrayList<>();
    }

    public void capturar(Pokemon pokemon) throws LimiteDePokemonException {
        validarQuantidadeDePokemons();
        super.pokemons.add(pokemon);
    }

    private void validarQuantidadeDePokemons() throws LimiteDePokemonException {
        if (getPokemons().size() == LIMITE_POKEMON) {
            throw new LimiteDePokemonException();
        }
    
    }

    public void receber(Insignia insignia) {
        this.insignias.add(insignia);
    }

    public int getDinheiro() {
        return dinheiro;
    }

    public int getNivel() {
        return nivel;
    }

    public Collection<Insignia> getInsignias() {
        return insignias;
    }
}
    