package br.com.cryslefundes;

import main.br.com.cryslefundes.Calculadora;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {
    Calculadora calculadora = new Calculadora();

    @Test
    void adicionar_HappyPath() {
        int resultado = calculadora.adicionar(1,1);
        assertEquals(2, resultado);
    }

    @Test
    void subtrair_HappyPath() {
        int resultado = calculadora.subtrair(1,1);
        assertEquals(0, resultado);
    }

    @Test
    void multiplicar_HappyPath() {
        int resultado = calculadora.multiplicar(1,1);
        assertEquals(1, resultado);
    }

    @Test
    void dividir_HappyPath() {
        int resultado = calculadora.dividir(1,1);
        assertEquals(1, resultado);
    }

    @Test
    void dividir_RetornaErroAoDividirPorZero() {
        assertThrows(
                ArithmeticException.class,
                () -> calculadora.dividir(1,0)
        );
    }
}