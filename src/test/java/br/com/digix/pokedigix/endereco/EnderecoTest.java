package br.com.digix.pokedigix.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class EnderecoTest {
    @Test
    public void deve_criar_um_treinador(){
        // Arrange
        String cidadeEsperada = "Pallet";
        String regiaoEsperada = "Kanto";
        // Act
        Endereco endereco = new Endereco(cidadeEsperada, regiaoEsperada);

        // Assert
        assertEquals(cidadeEsperada, endereco.getCidade());
        assertEquals(regiaoEsperada, endereco.getRegiao());
    }
}
