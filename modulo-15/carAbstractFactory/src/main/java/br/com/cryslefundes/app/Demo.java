package br.com.cryslefundes.app;

import br.com.cryslefundes.factory.abstrata.Fabrica;
import br.com.cryslefundes.factory.concreta.ComContrato;
import br.com.cryslefundes.factory.concreta.SemContrato;

public class Demo {

    public static void main(String[] args) {
        var cliente = new Cliente(true, "B");
        var fabrica = getFabrica(cliente);
        var carro =  fabrica.criar(cliente.getCategoria());
        carro.ligarMotor();
        carro.mudarMarcha();
    }

    private static Fabrica getFabrica(Cliente c) {
        if (c.isTemContrato()) {
            return new ComContrato();
        } else {
            return new SemContrato();
        }
    }
}
