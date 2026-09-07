package br.com.fiap.soulup.models;

public class Usuario {

    private int id;
    private String username;
    private String senha;
    private int pontos;

    public Usuario() {
    }

    public Usuario(String username, String senha) {
        this.username = username;
        this.senha = senha;
        this.pontos = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void adicionarPontos(int pontos) {

        if (pontos > 0) {
            this.pontos = this.pontos + pontos;
        }
    }

    public boolean podeResgatar(int pontosNecessarios) {

        return this.pontos >= pontosNecessarios;
    }

    public void gastarPontos(int pontos) {

        if (pontos > 0 && this.pontos >= pontos) {
            this.pontos = this.pontos - pontos;
        }
    }

    public String toString() {

        return "Usuario [id=" + id +
                ", username=" + username +
                ", pontos=" + pontos + "]";
    }
}