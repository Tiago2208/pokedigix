package br.com.digix.pokedigix.treinador;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.endereco.Endereco;

@DataJpaTest
public class TreinadorRepositoryTest {
    @Autowired
    private TreinadorRepository treinadorRepository;
    
    @Test
    public void deve_salvar_um_treinador() {
        String nomeEsperado = "Ash";
        int nivelEsperado = 30;
        double dinheiroEsperado = 10000000.0;
        Endereco enderecoEsperado = new Endereco("Pallet", "Kanto");

        Treinador treinador = new Treinador(nomeEsperado, nivelEsperado, dinheiroEsperado, enderecoEsperado);
        
        treinadorRepository.save(treinador);

        assertNotNull(treinador.getId());
    }
}
