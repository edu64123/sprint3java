package br.com.fiap.soulup.models;

public class BilheteUnico {

    private int id;
    private int usuarioId;
    private double saldoDinheiro;
    private int passagens;
    private int valesDesconto;

    public BilheteUnico() {
    }

    public BilheteUnico(int usuarioId) {
        this.usuarioId = usuarioId;
        this.saldoDinheiro = 0;
        this.passagens = 0;
        this.valesDesconto = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getSaldoDinheiro() {
        return saldoDinheiro;
    }

    public void setSaldoDinheiro(double saldoDinheiro) {
        this.saldoDinheiro = saldoDinheiro;
    }

    public int getPassagens() {
        return passagens;
    }

    public void setPassagens(int passagens) {
        this.passagens = passagens;
    }

    public int getValesDesconto() {
        return valesDesconto;
    }

    public void setValesDesconto(int valesDesconto) {
        this.valesDesconto = valesDesconto;
    }

    public void adicionarSaldo(double valor) {

        if (valor > 0) {
            this.saldoDinheiro = this.saldoDinheiro + valor;
        }
    }

    public boolean usarSaldo(double valor) {

        if (valor > 0 && this.saldoDinheiro >= valor) {

            this.saldoDinheiro = this.saldoDinheiro - valor;

            return true;
        }

        return false;
    }

    public void adicionarPassagem() {

        this.passagens = this.passagens + 1;
    }

    public String toString() {

        return "BilheteUnico [id=" + id +
                ", usuarioId=" + usuarioId +
                ", saldoDinheiro=" + saldoDinheiro +
                ", passagens=" + passagens +
                ", valesDesconto=" + valesDesconto + "]";
    }
}