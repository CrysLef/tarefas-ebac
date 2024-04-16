package algoritmos;

import java.util.*;

public class AlgoritmoGuloso {

    public static List<Integer> calculaTroco(int quantia, Stack<Integer> moedasDisponiveis) {
        List<Integer> troco = new ArrayList<>();

        Collections.sort(moedasDisponiveis);

        int maior_moeda = moedasDisponiveis.pop();

        while (quantia > 0) {
            if ((quantia - maior_moeda) >= 0) {
                quantia -= maior_moeda;
                troco.add(maior_moeda);
            } else {
                maior_moeda = moedasDisponiveis.pop();
            }
        }

        return troco;
    }

}
