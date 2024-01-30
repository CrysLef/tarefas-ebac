package br.com.cryslefundes.app;

public class Cliente {
    private boolean temContrato;
    private String categoria;

    public Cliente(boolean temContrato, String categoria) {
        this.temContrato = temContrato;
        this.categoria = categoria;
    }

    public boolean isTemContrato() {
        return temContrato;
    }

    public String getCategoria() {
        return categoria;
    }
}
