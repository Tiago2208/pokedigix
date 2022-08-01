package br.com.digix.pokedigix.ataque;

public class TipoInvalidoParaCategoriaException extends Exception {

    public TipoInvalidoParaCategoriaException(Categoria categoria) {
        super("O ataque da categoria " + categoria.name() + " não pode ser nulo.");
    }
    
}
