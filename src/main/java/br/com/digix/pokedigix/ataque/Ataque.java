package br.com.digix.pokedigix.ataque;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import br.com.digix.pokedigix.pokemon.Pokemon;
import br.com.digix.pokedigix.tipo.Tipo;

@Entity
public class Ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(nullable = false)
    private int forca;
    
    @Column(nullable = false)
    private int acuracia;
    
    @Column(nullable = false)
    private int pontosDePoder;
    
    @Column(nullable = false, length = 100)
    private String descricao;
    
    @Column(nullable = false, length = 15)
    private String nome;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 15)
    private Categoria categoria;
    
    @ManyToOne
    private Tipo tipo;

    @ManyToMany(mappedBy = "ataques")
    private Collection<Pokemon> pokemons;
    
    protected Ataque() {}
    
    public Ataque(int forca, int acuracia, int pontosDePoder, String descricao, String nome, Categoria categoria, Tipo tipo) throws AcuraciaInvalidaException, ForcaInvalidaParaCategoriaException, TipoInvalidoParaCategoriaException  {
    
    validarAcuracia(acuracia);
    validarForca(categoria, forca);
    validarTipo(categoria, tipo);
    
    this.forca = forca;
        this.acuracia = acuracia;
        this.pontosDePoder = pontosDePoder;
        this.descricao = descricao;
        this.nome = nome;
        this.categoria = categoria;
        this.tipo = tipo;
    }
    private void validarTipo(Categoria categoria, Tipo tipo) throws TipoInvalidoParaCategoriaException {
        if( !categoria.equals(Categoria.EFEITO) && tipo == null) {
            throw new TipoInvalidoParaCategoriaException(categoria);
        }
    }
    public Ataque(int acuracia, int pontosDePoderEsperado, String descricaoEsperada, String nomeEsperado) throws AcuraciaInvalidaException {
        validarAcuracia(acuracia);
        this.acuracia = acuracia;
        this.pontosDePoder = pontosDePoderEsperado;
        this.descricao = descricaoEsperada;
        this.nome = nomeEsperado;
        this.categoria = Categoria.EFEITO;
        
    }
    private void validarForca(Categoria categoria, int forca) throws ForcaInvalidaParaCategoriaException {
        if( (!categoria.equals(Categoria.EFEITO)) && forca <= 0) {
            throw new ForcaInvalidaParaCategoriaException(categoria);
        }
    }
    private void validarAcuracia(int acuracia) throws AcuraciaInvalidaException {
        if(acuracia < 0 || acuracia > 100) {
            throw new AcuraciaInvalidaException();
        }
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public int getAcuracia() {
        return acuracia;
    }
    public void setAcuracia(int acuracia) {
        this.acuracia = acuracia;
    }
    public int getPontosDePoder() {
        return pontosDePoder;
    }
    public void setPontosDePoder(int pontosDePoder) {
        this.pontosDePoder = pontosDePoder;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Collection<Pokemon> getPokemons() {
        return pokemons;
    }
}
