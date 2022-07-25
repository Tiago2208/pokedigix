package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PokemonTest {
    @Test
    public void deve_criar_um_pokemon() {
        // Arrange
        String nomeEsperado = "Charmander";
        int nivelEsperado = 15;
        double alturaEsperada = 0.90;
        double pesoEsperado = 10.0;
        Genero generoEsperado = Genero.MASCULINO;
        int numeroDaPokedexEsperado = 4;
        int felicidadeEsperada = 100;

        // Act
        Pokemon pokemon = new Pokemon(nomeEsperado, nivelEsperado, alturaEsperada, pesoEsperado, generoEsperado, numeroDaPokedexEsperado, felicidadeEsperada);
        
        // Assert
        assertEquals(nomeEsperado, pokemon.getNome());
        assertEquals(nivelEsperado, pokemon.getNivel());
        assertEquals(alturaEsperada, pokemon.getAltura());
        assertEquals(pesoEsperado, pokemon.getPeso());
        assertEquals(generoEsperado, pokemon.getGenero());
        assertEquals(numeroDaPokedexEsperado, pokemon.getNumeroDaPokedex());
        assertEquals(felicidadeEsperada, pokemon.getFelicidade());

    }
}
