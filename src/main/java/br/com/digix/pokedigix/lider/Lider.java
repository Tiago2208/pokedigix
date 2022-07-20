package br.com.digix.pokedigix.lider;

public class Lider {
    private String nome;
    private int nivel;
    private String insignia;
    public Lider(String nome, int nivel, String insignia) {
        this.nome = nome;
        this.nivel = nivel;
        this.insignia = insignia;
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
    public String getInsignia() {
        return insignia;
    }
    public void setInsignia(String insignia) {
        this.insignia = insignia;
    }
}
