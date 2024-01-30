package br.com.cryslefundes.app;

import br.com.cryslefundes.factory.abstrata.Carro;

public class Megane extends Carro {
    public Megane(String cor, String tipoCombustivel, int forcaACavalo) {
        super(cor, tipoCombustivel, forcaACavalo);
    }

    @Override
    public void mudarMarcha() {
        System.out.println("Mudando de marcha manualmente...");
    }


}
