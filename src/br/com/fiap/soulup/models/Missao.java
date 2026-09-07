package br.com.fiap.soulup.models;

public class Missao {

    private int id;
    private String descricao;
    private int recompensaPontos;

    public Missao() {
    }

    public Missao(int id, String descricao, int recompensaPontos) {
        this.id = id;
        this.descricao = descricao;
        this.recompensaPontos = recompensaPontos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getRecompensaPontos() {
        return recompensaPontos;
    }

    public void setRecompensaPontos(int recompensaPontos) {
        this.recompensaPontos = recompensaPontos;
    }

    public String toString() {

        return "Missão " + id +
                ": " + descricao +
                " - Recompensa: " +
                recompensaPontos +
                " pontos.";
    }
}