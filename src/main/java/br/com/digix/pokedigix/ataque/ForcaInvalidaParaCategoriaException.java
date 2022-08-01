package br.com.digix.pokedigix.ataque;

public class ForcaInvalidaParaCategoriaException extends Exception {
    public ForcaInvalidaParaCategoriaException(Categoria categoria) {
        super("A categoria " + categoria.name() + " deve ter força maior que zero.");
    }
}
