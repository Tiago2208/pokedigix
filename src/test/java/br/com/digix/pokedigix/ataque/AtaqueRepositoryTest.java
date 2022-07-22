package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Collection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.digix.pokedigix.tipo.Tipo;
import br.com.digix.pokedigix.tipo.TipoRepository;

@DataJpaTest
public class AtaqueRepositoryTest {

    @Autowired
    private AtaqueRepository ataqueRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Test
    public void deve_salvar_um_ataque() {
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Tipo tipoEsperado = new Tipo("Fogo");
        Categoria categoriaEsperada = Categoria.ESPECIAL;

        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);      
        ataqueRepository.save(ataque);

        assertNotNull(ataque.getId());
    }

    @Test
    public void deve_salvar_um_tipo_para_um_ataque() {
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Tipo tipoEsperado = new Tipo("Fogo");
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        
        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);      
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);

        Ataque ataqueRetornado = ataqueRepository.findById(ataque.getId()).get();

        assertEquals(tipoEsperado.getNome(), ataqueRetornado.getTipo().getNome());
        assertNotNull(ataqueRetornado.getTipo().getId());
    }
    @Test
    public void deve_buscar_um_ataque_pelo_seu_tipo() {
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Tipo tipoEsperado = new Tipo("Fogo");
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        
        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);      
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataqueRetornado = ataqueRepository.findByTipo(tipoEsperado);

        assertTrue(ataqueRetornado.contains(ataque));
        

        

    }
    @Test
    public void deve_buscar_um_ataque_pela_sua_categoria() {
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Tipo tipoEsperado = new Tipo("Fogo");
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        
        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);      
        tipoRepository.save(tipoEsperado);
        ataqueRepository.save(ataque);

        Collection<Ataque> ataqueRetornado = ataqueRepository.findByCategoria(categoriaEsperada);

        assertTrue(ataqueRetornado.contains(ataque));
        

        

    }
}
