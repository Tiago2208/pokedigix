package br.com.digix.pokedigix.endereco;

public class Endereco {
    private String regiao;
    private String cidade;
    public Endereco(String regiao, String cidade) {
        this.regiao = regiao;
        this.cidade = cidade;
    }
    public String getRegiao() {
        return regiao;
    }
    public void setRegiao(String regiao) {
        this.regiao = regiao;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
