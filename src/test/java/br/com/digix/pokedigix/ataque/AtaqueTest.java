package br.com.digix.pokedigix.ataque;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueTest {
    @Test
    public void deve_criar_um_ataque() throws Exception {
        // Arrange
        String nomeEsperado = "Flamethrower";
        int forcaEsperada = 100;
        int acuraciaEsperada = 100;
        int pontosDePoderEsperado = 140;
        String descricaoEsperada = "cospe fogo";
        Categoria categoriaEsperada = Categoria.ESPECIAL;
        Tipo tipoEsperado = new Tipo("Fogo");

        // Act
        Ataque ataque = new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada,
                nomeEsperado, categoriaEsperada, tipoEsperado);

        // Assert
        assertEquals(nomeEsperado, ataque.getNome());
        assertEquals(forcaEsperada, ataque.getForca());
        assertEquals(acuraciaEsperada, ataque.getAcuracia());
        assertEquals(pontosDePoderEsperado, ataque.getPontosDePoder());
        assertEquals(descricaoEsperada, ataque.getDescricao());
        assertEquals(categoriaEsperada, ataque.getCategoria());
    }

    @Test
    public void deve_ser_obrigatorio_informar_um_tipo() throws Exception {
        Tipo tipoEsperado = new Tipo("Fogo");
        Ataque ataque = new AtaqueBuilder().comTipo(tipoEsperado).construir();

        assertEquals(tipoEsperado, ataque.getTipo());

    }

    @Test
    public void nao_deve_ter_acuracia_menor_que_zero() throws Exception {
        // Arrange
        int acuracia = -1;
        // Assert
        assertThrows(AcuraciaInvalidaException.class, () -> {
            // Action
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        });
         // Assert
         assertThrows(AcuraciaInvalidaException.class, () -> {
            // Action
            new AtaqueBuilder().comAcuracia(acuracia).comCategoriaEfeito().construir();
        });

    }

    @Test
    public void nao_deve_ter_acuracia_maior_que_cem() throws Exception {
        // Arrange
        int acuracia = 102;
        // Assert
        assertThrows(AcuraciaInvalidaException.class, () -> {
            // Action
            new AtaqueBuilder().comAcuracia(acuracia).construir();
        });
        // Assert
        assertThrows(AcuraciaInvalidaException.class, () -> {
            // Action
            new AtaqueBuilder().comAcuracia(acuracia).comCategoriaEfeito().construir();
        });
    }

    @Test
    public void deve_ter_acuracia_igual_a_zero() throws Exception {
        int acuraciaEsperada = 0;

        Ataque ataque = new AtaqueBuilder().comAcuracia(acuraciaEsperada).construir();

        assertEquals(acuraciaEsperada, ataque.getAcuracia());
    }

    @Test
    public void nao_deve_ter_forca_nem_tipo_quando_a_categoria_for_efeito() throws Exception {
        Categoria categoria = Categoria.EFEITO;
        int forca = 0;
        Tipo tipo = null;

        Ataque ataque = new AtaqueBuilder().comCategoriaEfeito().construir();

        assertEquals(categoria, ataque.getCategoria());
        assertEquals(forca, ataque.getForca());
        assertEquals(tipo, ataque.getTipo());
    }

    @Test
    public void nao_deve_ter_ataque_de_categoria_fisica_sem_forca() throws ForcaInvalidaParaCategoriaException{
        Categoria categoria = Categoria.FISICO;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
            new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
        });
    }

    @Test
    public void nao_deve_ter_ataque_de_categoria_fisica_sem_tipo() throws TipoInvalidoParaCategoriaException {
        Categoria categoria = Categoria.FISICO;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
            new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
        });
    }
    @Test
    public void nao_deve_ter_ataque_de_categoria_especial_sem_forca() throws ForcaInvalidaParaCategoriaException{
        Categoria categoria = Categoria.ESPECIAL;
        int forca = 0;

        assertThrows(ForcaInvalidaParaCategoriaException.class, () -> {
            new AtaqueBuilder().comForca(forca).comCategoria(categoria).construir();
        });
    }
    @Test
    public void nao_deve_ter_ataque_de_categoria_especial_sem_tipo() throws TipoInvalidoParaCategoriaException {
        Categoria categoria = Categoria.ESPECIAL;
        Tipo tipo = null;

        assertThrows(TipoInvalidoParaCategoriaException.class, () -> {
            new AtaqueBuilder().comTipo(tipo).comCategoria(categoria).construir();
        });
    }
}
