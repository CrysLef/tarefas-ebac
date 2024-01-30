package br.com.cryslefundes.app;

import br.com.cryslefundes.factory.abstrata.Carro;

public class Audi extends Carro {
    public Audi(String cor, String tipoCombustivel, int forcaACavalo) {
        super(cor, tipoCombustivel, forcaACavalo);
    }

    @Override
    public void mudarMarcha() {
        System.out.println("Mudando de marcha automaticamente...");
    }


}
