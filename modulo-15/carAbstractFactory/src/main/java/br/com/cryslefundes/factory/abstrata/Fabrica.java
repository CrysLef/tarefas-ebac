package br.com.cryslefundes.factory.abstrata;

public abstract class Fabrica {
    public Carro criar(String categoriaSolicitada) {
        var carro = getCarro(categoriaSolicitada);
        carro = preparaCarro(carro);
        return carro;
    }

    public Carro preparaCarro(Carro carro) {
        carro.limpar();
        carro.checarMecanica();
        carro.encherTanque();
        return carro;
    }

    public abstract Carro getCarro(String categoriaSolicitada);
}
