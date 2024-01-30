package br.com.cryslefundes.factory.concreta;

import br.com.cryslefundes.app.Audi;
import br.com.cryslefundes.app.Civic;
import br.com.cryslefundes.app.Megane;
import br.com.cryslefundes.app.Subaru;
import br.com.cryslefundes.factory.abstrata.Carro;
import br.com.cryslefundes.factory.abstrata.Fabrica;

public class SemContrato extends Fabrica {

    @Override
    public Carro getCarro(String categoriaSolicitada) {
        return switch (categoriaSolicitada) {
            case "A" -> new Civic("preto", "gasolina", 110);
            case "B" -> new Megane("prata", "gás", 90);
            default -> null;
        };
    }
}
