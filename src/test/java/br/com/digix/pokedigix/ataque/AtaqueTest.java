package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class AtaqueTest {
    @Test
    public void deve_criar_um_ataque() {
        // Arrange
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Categoria categoriaEsperada = Categoria.ESPECIAL;

        // Act
       Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada);
        
        // Assert
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forcaEsperada, ataque.getForca());
        assertEquals(acuraciaEsperada, ataque.getAcuracia());
        assertEquals(pontosDePoderEsperado, ataque.getPontosDePoder());
        assertEquals(descricaoEsperada, ataque.getDescricao());
        assertEquals(categoriaEsperada, ataque.getCategoria());
    }
}