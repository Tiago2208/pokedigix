package br.com.digix.pokedigix.tipo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class TipoRepositoryTest {
    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_tipo() {
        String nomeEsperado = "Fogo";
        Tipo tipo = new Tipo(nomeEsperado);
        
        tipoRepository.save(tipo);

        assertNotNull(tipo.getId());
    }

    @Test
    public void deve_buscar_um_tipo_pelo_nome() {
        String nomeEsperado = "Eletrico";
        Tipo tipoEsperado = new Tipo(nomeEsperado);
        tipoRepository.save(tipoEsperado);

        Collection<Tipo> tiposRetornados = tipoRepository.findByNome(nomeEsperado);
        
        assertTrue(tiposRetornados.contains(tipoEsperado));
    }
}
