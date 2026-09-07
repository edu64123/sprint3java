package br.com.fiap.soulup.models;

public class Postagem {

    private int id;
    private String conteudo;
    private int usuarioId;

    public Postagem() {
    }

    public Postagem(String conteudo, int usuarioId) {
        this.conteudo = conteudo;
        this.usuarioId = usuarioId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public boolean validarConteudo() {

        return conteudo != null &&
                !conteudo.trim().isEmpty() &&
                conteudo.length() <= 500;
    }

    public String toString() {

        return "Postagem [id=" + id +
                ", conteudo=" + conteudo +
                ", usuarioId=" + usuarioId + "]";
    }
}