package br.com.digix.pokedigix.pokemon;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import br.com.digix.pokedigix.ataque.Ataque;
import br.com.digix.pokedigix.tipo.Tipo;


@Entity
public class Pokemon {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false, length = 20)
    private String nome;
    
    @Column(nullable = false)
    private int nivel;
    
    @Column(nullable = false)
    private double altura;
    
    @Column(nullable = false) 
    private double peso;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Genero genero;
    
    @Column(nullable = false)
    private int numeroDaPokedex;
    
    @Column(nullable = false)
    private int felicidade;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "pokemon_tipo",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "tipo_id")
    )
    private Collection<Tipo> tipos;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "pokemon_ataque",
        joinColumns = @JoinColumn(name = "pokemon_id"),
        inverseJoinColumns = @JoinColumn(name = "ataque_id")
    )
    private Collection<Ataque> ataques;
    
    
    public Pokemon(String nome, int nivel, double altura, double peso, Genero genero, int numeroDaPokedex,
    int felicidade, Collection<Tipo> tipos, Collection<Ataque> ataques) throws NivelInvalidoDoPokemonException, FelicidadeInvalidaException {
        validarNivelDoPokemon(nivel);
        validarFelicidade(felicidade);
        this.nome = nome;
        this.nivel = nivel;
        this.altura = altura;
        this.peso = peso;
        this.genero = genero;
        this.numeroDaPokedex = numeroDaPokedex;
        this.felicidade = felicidade;
        this.tipos = tipos;
        this.ataques = ataques;
    }
    private void validarFelicidade(int felicidade) throws FelicidadeInvalidaException {
        if( (felicidade < 0) || (felicidade > 100) ) {
            throw new FelicidadeInvalidaException();
        }
    }
    private void validarNivelDoPokemon(int nivel) throws NivelInvalidoDoPokemonException {
        if ((nivel < 1) || (nivel > 100)) {
            throw new NivelInvalidoDoPokemonException();
        }
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
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
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
    public Collection<Tipo> getTipos() {
        return tipos;
    }
    public Collection<Ataque> getAtaques() {
        return ataques;
    }
}
