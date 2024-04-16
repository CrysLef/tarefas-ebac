package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Backtracking {
    public static List<List<Integer>> geraSubconjuntoDeTamanhoN(List<Integer> conjunto, int elementos) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        List<Integer> subconjunto = new ArrayList<>();
        geraSubconjunto(subconjunto, conjunto, elementos, subconjuntos);
        return subconjuntos;
    }

    private static void geraSubconjunto(List<Integer> subconjunto, List<Integer> conjunto, int elementos, List<List<Integer>> resultado) {
        if (subconjunto.size() == elementos) {
            resultado.add(new ArrayList<>(subconjunto));
            return;
        }
        if (conjunto.isEmpty() || subconjunto.size() + conjunto.size() < elementos) {
            return;
        }

        subconjunto.add(conjunto.get(0));
        geraSubconjunto(subconjunto, conjunto.subList(1, conjunto.size()), elementos, resultado);
        subconjunto.remove(subconjunto.size() - 1);

        geraSubconjunto(subconjunto, conjunto.subList(1, conjunto.size()), elementos, resultado);
    }
}
