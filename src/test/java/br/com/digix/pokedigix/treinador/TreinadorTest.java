package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.endereco.Endereco;

public class TreinadorTest {
    @Test
    public void deve_criar_um_treinador() {
        // Arrange
        String nomeEsperado = "Ash";
        int nivelEsperado = 30;
        double dinheiroEsperado = 10000000;
        Endereco enderecoEsperado = new Endereco("Pallet", "Kanto");

        // Act
        Treinador treinador = new Treinador(nomeEsperado, nivelEsperado, dinheiroEsperado, enderecoEsperado);

        // Assert
        assertEquals(nomeEsperado, treinador.getNome());
        assertEquals(nivelEsperado, treinador.getNivel());
        assertEquals(dinheiroEsperado, treinador.getDinheiro());
        assertEquals(enderecoEsperado, treinador.getEndereco());

    }
}
