package br.com.digix.pokedigix.pokemon;

public class Pokemon {
    private String nome;
    private int nivel;
    private String tipo;
    private int altura;
    private int peso;
    private String genero;
    private int numeroDaPokedex;
    private int felicidade;
    public Pokemon(String nome, int nivel, String tipo, int altura, int peso, String genero, int numeroDaPokedex,
            int felicidade) {
        this.nome = nome;
        this.nivel = nivel;
        this.tipo = tipo;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numeroDaPokedex = numeroDaPokedex;
        this.felicidade = felicidade;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getAltura() {
        return altura;
    }
    public void setAltura(int altura) {
        this.altura = altura;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }
    public int getNumeroDaPokedex() {
        return numeroDaPokedex;
    }
    public void setNumeroDaPokedex(int numeroDaPokedex) {
        this.numeroDaPokedex = numeroDaPokedex;
    }
    public int getFelicidade() {
        return felicidade;
    }
    public void setFelicidade(int felicidade) {
        this.felicidade = felicidade;
    }
}
