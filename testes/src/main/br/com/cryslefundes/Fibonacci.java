package main.br.com.cryslefundes;

import java.util.Arrays;

public class Fibonacci {
   private static final int MAX_ELEMENTOS = 100;
   private final long[] array = new long[MAX_ELEMENTOS];

    public long retornaSequenciaFibonacci(int elemento) {
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
