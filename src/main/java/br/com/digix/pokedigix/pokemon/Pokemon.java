package br.com.digix.pokedigix.pokemon;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 20)
    private String nome;
    
    @Column(nullable = false)
    private int nivel;
    
    @Column(nullable = false, length = 20)
    private String tipo;
    
    @Column(nullable = false)
    private double altura;
    
    @Column(nullable = false) 
    private double peso;
    
    @Column(nullable = false, length = 15)
    private String genero;
    
    @Column(nullable = false)
    private int numeroDaPokedex;
    
    @Column(nullable = false)
    private int felicidade;
    
    
    public Pokemon(String nome, int nivel, String tipo, double altura, double peso, String genero, int numeroDaPokedex,
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
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
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
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
}
