package br.com.digix.pokedigix.personagem;

public class LimiteDePokemonException extends Exception{
    public LimiteDePokemonException() {
        super("Um treinador não pode ter mais de seis pokemons ao mesmo tempo.");
    }
}
