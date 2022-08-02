package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
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
    public void deve_cadastrar_um_tipo_para_o_pokemon() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        Tipo tiposEsperados = new Tipo("Fogo");
        Pokemon charmander = new PokemonBuilder().comTipo(tiposEsperados).construir();

        // Assert
        assertTrue(charmander.getTipos().contains(tiposEsperados));

    }

    @Test
    public void deve_ter_nivel_minimo_um() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        int nivelMinimo = 1;
        Pokemon pokemon = new PokemonBuilder().comNivel(nivelMinimo).construir();

        assertEquals(nivelMinimo, pokemon.getNivel());
    }

    @Test
    public void deve_ter_nivel_maximo_cem() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        int nivelMaximo = 100;
        Pokemon pokemon = new PokemonBuilder().comNivel(nivelMaximo).construir();

        assertEquals(nivelMaximo, pokemon.getNivel());
    }

    @Test
    public void nao_pode_ter_nivel_menor_que_um() throws NivelInvalidoDoPokemonException {
        int nivel = 0;
        
        assertThrows(NivelInvalidoDoPokemonException.class, () -> {
            new PokemonBuilder().comNivel(nivel).construir();
            
        });
        
    }

    @Test
    public void nao_pode_ter_nivel_maior_que_cem() throws NivelInvalidoDoPokemonException {
        int nivel = 101;
        
        assertThrows(NivelInvalidoDoPokemonException.class, () -> {
            new PokemonBuilder().comNivel(nivel).construir();
            
        });
        
    }

    @Test
    public void deve_ter_felicidade_minima_zero() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        int felicidadeMinima = 0;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMinima).construir();

        assertEquals(felicidadeMinima, pokemon.getFelicidade());
    }

    @Test
    public void deve_ter_felicidade_maxima_cem() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        int felicidadeMaxima = 100;

        Pokemon pokemon = new PokemonBuilder().comFelicidade(felicidadeMaxima).construir();

        assertEquals(felicidadeMaxima, pokemon.getFelicidade());
    }

    @Test
    public void nao_pode_ter_felicidade_menor_que_zero() {
        int felicidadeInvalida = -1;

        assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidadeInvalida).construir();
        });
    }
    
    @Test
    public void nao_pode_ter_felicidade_maior_que_cem() {
        int felicidadeInvalida = 101;

        assertThrows(FelicidadeInvalidaException.class, () -> {
            new PokemonBuilder().comFelicidade(felicidadeInvalida).construir();
        });
    }
}
