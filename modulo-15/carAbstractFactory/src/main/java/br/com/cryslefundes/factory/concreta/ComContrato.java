package br.com.cryslefundes.factory.concreta;

import br.com.cryslefundes.app.Audi;
import br.com.cryslefundes.app.Subaru;
import br.com.cryslefundes.factory.abstrata.Carro;
import br.com.cryslefundes.factory.abstrata.Fabrica;

public class ComContrato extends Fabrica {

    @Override
    public Carro getCarro(String categoriaSolicitada) {
        return switch (categoriaSolicitada) {
            case "A" -> new Audi("vermelho", "gasolina", 120);
            case "B" -> new Subaru("azul", "gasolina", 100);
            default -> null;
        };
    }
}
