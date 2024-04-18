package main.br.com.cryslefundes;

/**
 * Classe que realiza operações básicas de uma calculadora.
 */
public class Calculadora {

    /**
     * Realiza a soma entre dois elementos.
     * @param a elemento a ser somado.
     * @param b valor que irá ser adicionado ao elemento a.
     * @return A soma entre os elementos a e b.
     */
    public int adicionar(int a, int b) {
        return a + b;
    }

    /**
     * Realiza a subtração entre dois elementos.
     * @param a elemento a ser subtraido.
     * @param b valor que irá ser subtraido do elemento a.
     * @return A subtração entre os elementos a e b.
     */
    public int subtrair(int a, int b) {
        return a - b;
    }

    /**
     * Realiza a multiplicação entre dois elementos.
     * @param a elemento a ser multiplicado.
     * @param b valor que irá multiplicar o elemento a.
     * @return A multiplicação entre os elementos a e b.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Realiza a divisão entre dois elementos.
     * @param a elemento a ser divido.
     * @param b valor que irá dividir o elemento a.
     * @return A divisão entre os elementos a e b.
     */
    public int dividir(int a, int b) {
        return a / b;
    }
}
