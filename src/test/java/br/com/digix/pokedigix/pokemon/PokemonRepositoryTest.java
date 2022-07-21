package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() {
        String nomeEsperado = "Charmander";
        int nivelEsperado = 15;
        String tipoEsperado = "Fogo";
        double alturaEsperada = 0.90;
        double pesoEsperado = 10.0;
        String generoEsperado = "Masculino";
        int numeroDaPokedexEsperado = 4;
        int felicidadeEsperada = 100;

        Long idEsperado = 1L;

        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, tipoEsperado, alturaEsperada, pesoEsperado, generoEsperado, numeroDaPokedexEsperado, felicidadeEsperada);
        pokemonRepository.save(pokemon);

        assertEquals(idEsperado, pokemon.getId());
    }

}


