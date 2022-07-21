package br.com.digix.pokedigix.endereco;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class EnderecoRepositoryTest {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Test
    public void deve_salvar_um_endereco() {
        String cidadeEsperada = "Pallet";
        String regiaoEsperada = "Kanto";

        Long idEsperado = 1L;

        Endereco endereco = new Endereco(cidadeEsperada, regiaoEsperada);
        enderecoRepository.save(endereco);

        assertEquals(idEsperado, endereco.getId());
    }

}
