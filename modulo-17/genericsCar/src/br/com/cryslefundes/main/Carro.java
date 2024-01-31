package br.com.cryslefundes.main;

public abstract class Carro {
    private String modelo;
    private String cor;
    private String tipoMarcha;
    private Long kmRodados;

    public Carro(String modelo, String cor, String tipoMarcha, Long kmRodados) {
        this.modelo = modelo;
        this.cor = cor;
        this.tipoMarcha = tipoMarcha;
        this.kmRodados = kmRodados;
    }

    @Override
    public String toString() {
        return "Modelo: " + modelo +
                " Cor: " + cor +
                " Tipo de marcha: " + tipoMarcha +
                " KM rodados: " + kmRodados;
    }
}
