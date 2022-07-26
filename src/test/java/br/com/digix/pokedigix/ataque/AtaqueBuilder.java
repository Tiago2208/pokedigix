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

    
    public Ataque construir() {
        return new Ataque(forcaEsperada, acuraciaEsperada, pontosDePoderEsperado, descricaoEsperada, nomeEsperado, categoriaEsperada, tipoEsperado);
    }
    
    public AtaqueBuilder comTipo(Tipo tipoEsperado) {
        this.tipoEsperado = tipoEsperado;
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
}
