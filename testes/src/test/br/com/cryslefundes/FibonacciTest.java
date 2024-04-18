package br.com.cryslefundes;

import main.br.com.cryslefundes.Fibonacci;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FibonacciTest {
    Fibonacci fibonacci = new Fibonacci();

    @Test
    void retornaSequenciaFibonacci_HappyPath() {
        long resultado = fibonacci.retornaSequenciaFibonacci(4);
        assertEquals(3, resultado);
    }

    @Test
    void retornaSequenciaFibonacci_retornaZeroQuandoElementoEhZero() {
        long resultado = fibonacci.retornaSequenciaFibonacci(0);
        assertEquals(0, resultado);
    }

    @Test
    void retornaSequenciaFibonacci_retornaUmQuandoElementoEhUm() {
        long resultado = fibonacci.retornaSequenciaFibonacci(1);
        assertEquals(1, resultado);
    }

    @Test
    void retornaSequenciaFibonacci_retornaErroAoPassarNumeroNegativo() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> fibonacci.retornaSequenciaFibonacci(-1)
        );
    }
}