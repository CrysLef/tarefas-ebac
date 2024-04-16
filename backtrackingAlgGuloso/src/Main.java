import algoritmos.AlgoritmoGuloso;
import backtracking.Backtracking;

import java.util.List;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        List<Integer> conjunto = List.of(1,2,3);
        var result = Backtracking.geraSubconjuntoDeTamanhoN(conjunto, 2);
        result.forEach(System.out::println);

        Stack<Integer> moedasDisponiveis = new Stack<>();
        moedasDisponiveis.add(5);
        moedasDisponiveis.add(2);
        moedasDisponiveis.add(1);

        List<Integer> troco = AlgoritmoGuloso.calculaTroco(18, moedasDisponiveis);
        System.out.println("\ntroco: " + troco);
    }
}