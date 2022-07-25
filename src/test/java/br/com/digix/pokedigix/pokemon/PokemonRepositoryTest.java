package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() {
        String nomeEsperado = "Charmander";
        int nivelEsperado = 15;
        double alturaEsperada = 0.90;
        double pesoEsperado = 10.0;
        Genero generoEsperado = Genero.MASCULINO;
        int numeroDaPokedexEsperado = 4;
        int felicidadeEsperada = 100;
        List<Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Fogo"));


        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, alturaEsperada, pesoEsperado, generoEsperado, numeroDaPokedexEsperado, felicidadeEsperada, tiposEsperados);
        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

}


