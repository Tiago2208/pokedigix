package br.com.digix.pokedigix.pokemon;

public class NivelInvalidoDoPokemonException extends Exception {

    public NivelInvalidoDoPokemonException() {
        super("O nível de um pokemon deve estar entre 1 e 100.");
    }
    
}
