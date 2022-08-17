package br.com.digix.pokedigix.ataque;


public class AtaqueRequestDTO {
    private int acuracia;
    private int forca;
    private int pontosDePoder;
    private String descricao;
    private String nome;
    private Categoria categoria;
    Long tipoId;
    public AtaqueRequestDTO(int acuracia, int forca, int pontosDePoder, String descricao, String nome,
    Categoria categoria, Long tipoId) {
        this.acuracia = acuracia;
        this.forca = forca;
        this.pontosDePoder = pontosDePoder;
        this.descricao = descricao;
        this.nome = nome;
        this.categoria = categoria;
        this.tipoId = tipoId;
    }
    public int getAcuracia() {
        return acuracia;
    }
    public void setAcuracia(int acuracia) {
        this.acuracia = acuracia;
    }
    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
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
    public Long getTipoId() {
        return tipoId;
    }
    public void setTipoId(Long tipoId) {
        this.tipoId = tipoId;
    }

    
}

