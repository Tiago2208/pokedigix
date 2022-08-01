package br.com.digix.pokedigix.ataque;

import br.com.digix.pokedigix.tipo.Tipo;

public class AtaqueBuilder {

    private String nomeEsperado;
    private int forcaEsperada;
    private int acuraciaEsperada;
    private int pontosDePoderEsperado;
    private String descricaoEsperada;
    private Categoria categoriaEsperada;
    private Tipo tipoEsperado;

    
    
    public AtaqueBuilder comTipo(Tipo tipoEsperado) {
        this.tipoEsperado = tipoEsperado;
        return this;
    }
    
    public AtaqueBuilder comAcuracia(int acuracia) {
        this.acuraciaEsperada = acuracia;
        return this;
    }
    public AtaqueBuilder() {
        this.nomeEsperado = "Flamethrower";
        this.forcaEsperada = 100;
        this.acuraciaEsperada = 100;
        this.pontosDePoderEsperado = 140;
        this.descricaoEsperada = "cospe fogo";
        this.categoriaEsperada = Categoria.ESPECIAL;
        this.tipoEsperado = new Tipo("Fogo");
    }
    
    public Ataque construir() throws Exception {
        if(this.categoriaEsperada.equals(Categoria.EFEITO)) {
            return new Ataque(acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado);
        } else {
            return new Ataque (forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);
        }
    }

    public AtaqueBuilder comCategoriaEfeito() {
        this.categoriaEsperada = Categoria.EFEITO;
        return this;
    }

    public AtaqueBuilder comForca(int forca) {
        this.forcaEsperada = forca;
        return this;
    }

    public AtaqueBuilder comCategoria(Categoria categoria) {
        this.categoriaEsperada = categoria;
        return this;
    }
}
