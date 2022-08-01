package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon() throws Exception {
        // Arrange
        String nomeEsperado = "Charmander";
        int nivelEsperado = 15;
        double alturaEsperada = 0.90;
        double pesoEsperado = 10.0;
        Genero generoEsperado = Genero.MASCULINO;
        int numeroDaPokedexEsperado = 4;
        int felicidadeEsperada = 100;
        List<Tipo> tiposEsperados = new ArrayList<>();
        tiposEsperados.add(new Tipo("Fogo"));
        List<Ataque> ataques = new ArrayList<>();
        ataques.add(new AtaqueBuilder().construir());

        // Act
        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, alturaEsperada, pesoEsperado, generoEsperado,
                numeroDaPokedexEsperado, felicidadeEsperada, tiposEsperados, ataques);

        // Assert
        assertEquals(nomeEsperado, pokemon.getNome());
        assertEquals(nivelEsperado, pokemon.getNivel());
        assertEquals(alturaEsperada, pokemon.getAltura());
        assertEquals(pesoEsperado, pokemon.getPeso());
        assertEquals(generoEsperado, pokemon.getGenero());
        assertEquals(numeroDaPokedexEsperado, pokemon.getNumeroDaPokedex());
        assertEquals(felicidadeEsperada, pokemon.getFelicidade());

    }

    @Test
    public void deve_cadastrar_um_tipo_para_o_pokemon() {
        Tipo tiposEsperados = new Tipo("Fogo");
        Pokemon charmander = new PokemonBuilder().comTipo(tiposEsperados).construir();

        // Assert
        assertTrue(charmander.getTipos().contains(tiposEsperados));

    }
}
