package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class AtaqueRepositoryTest {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Test
    public void deve_salvar_um_ataque() {
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Categoria categoriaEsperada = Categoria.ESPECIAL;

        Long idEsperado = 1L;
        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada);      
        ataqueRepository.save(ataque);

        assertEquals(idEsperado, ataque.getId());
    }

}
