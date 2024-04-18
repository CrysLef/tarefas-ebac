package main.br.com.cryslefundes;

import java.util.Arrays;

/**
 * Classe que serve para encontrar o enésimo elemento dentro da sequência de Fibonacci.
 */
public class Fibonacci {
   private static final int MAX_ELEMENTOS = 100;
   private final long[] array = new long[MAX_ELEMENTOS];

    /**
     *
     * @param elemento Elemento qual se deseja descobrir o valor na sequência de Fibonacci.
     * @return Devolve o valor que está presente no elemento na sequência de Fibonacci.
     */
    public long retornaElementoNaSequenciaFibonacci(int elemento) {
        Arrays.fill(this.array, -1);
        return geraSequenciaFibonacci(elemento);
    }

    private long geraSequenciaFibonacci(int elemento) {
        if (this.array[elemento] == -1) {
            this.array[elemento] = (elemento <= 1) ?
                    elemento :
                    geraSequenciaFibonacci(elemento - 1) + geraSequenciaFibonacci(elemento - 2);
        }
        return this.array[elemento];
    }
}
