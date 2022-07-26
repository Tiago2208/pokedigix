package br.com.digix.pokedigix.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;



import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.ataque.AtaqueBuilder;
import br.com.digix.pokedigix.tipo.Tipo;

@DataJpaTest
public class PokemonRepositoryTest {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Test
    public void deve_salvar_um_pokemon() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        Pokemon pokemon = new PokemonBuilder().construir();
        pokemonRepository.save(pokemon);

        assertNotNull(pokemon.getId());
    }

    @Test
    public void deve_salvar_um_pokemon_com_um_tipo() throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        int quantidadeDeTiposEsperada = 1;
        Tipo fogo = new Tipo("Fogo");
        Pokemon charmander = new PokemonBuilder().comTipo(fogo).construir();
        pokemonRepository.save(charmander);

        
        Pokemon charmanderRetornado = pokemonRepository.findById(charmander.getId()).get();
        
        assertNotNull(charmanderRetornado.getTipos());
        assertEquals(quantidadeDeTiposEsperada, charmanderRetornado.getTipos().size());
            assertTrue(charmanderRetornado.getTipos().contains(fogo));
    }
    
    @Test
    public void deve_salvar_um_pokemon_com_ataque() throws Exception {
        Ataque ataque = new AtaqueBuilder().construir();
        Pokemon pokemon = new PokemonBuilder().comAtaque(ataque).construir();
        
        pokemonRepository.save(pokemon);

        assertTrue(pokemon.getAtaques().contains(ataque));
    }
}


