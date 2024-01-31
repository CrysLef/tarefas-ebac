package br.com.cryslefundes.main;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Subaru impreza = new Subaru("Impreza", "vermelho", "manual", 0L);
        Subaru forest = new Subaru("Forest", "preto", "automatico", 30000L);
        Subaru legacy = new Subaru("Legacy", "prata", "manual", 100000L);

        Audi a5 = new Audi("A5", "azul escuro", "manual", 20000L);
        Audi q3 = new Audi("Q3", "preto", "automatico", 0L);
        Audi tt = new Audi("TT", "amarelo", "manual", 11000L);

        Honda civic = new Honda("Civic", "preto", "manual", 300000L);
        Honda wrx =  new Honda("WRX", "vermelho", "automatico", 23000L);
        Honda fit = new Honda("Fit", "azul", "manual", 230000L);

        List<Subaru> carrosSubaru = new ArrayList<>();
        carrosSubaru.add(impreza);
        carrosSubaru.add(forest);
        carrosSubaru.add(legacy);
        imprimeCarro(carrosSubaru);

        List<Audi> carrosAudi = new ArrayList<>();
        carrosAudi.add(a5);
        carrosAudi.add(q3);
        carrosAudi.add(tt);
        imprimeCarro(carrosAudi);

        List<Honda> carrosHonda = new ArrayList<>();
        carrosHonda.add(civic);
        carrosHonda.add(wrx);
        carrosHonda.add(fit);
        imprimeCarro(carrosHonda);
    }

    private static void imprimeCarro(List<? extends Carro> carros) {
        String nomeMarcaCarro = carros.get(0).getClass().getSimpleName();
        System.out.println("\n========== " + nomeMarcaCarro + " ==========");
        carros.forEach(System.out::println);
        System.out.println("==============================");
    }
}
