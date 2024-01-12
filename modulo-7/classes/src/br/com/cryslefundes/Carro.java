package br.com.cryslefundes;

/**
 * @author Crystian Lefundes
 * @version 1.0
 */
public class Carro {
    private String marca;
    private String modelo;
    private String placa;
    private int quantidadeCombustivel;
    public int quilometragem;
    public int ano;

    /**
     * Método que aciona a buzina do carro.
     *
     * @return String com a onomatopeia da buzina.
     */
    public String buzina() {
        return "Bi bi";
    }

    public void dirigir() {
        System.out.println("Ligando o carro...");
        // Loop que faz o carro andar até que seu combustível acabe, sem opção de freio.
        while (quantidadeCombustivel > 0) {
            quilometragem++;
            System.out.println("Quilometragem total do carro: " + quilometragem);
            quantidadeCombustivel--;
            System.out.println("Qtd. de combustivel restante: " + quantidadeCombustivel);
        }
        System.out.println("Parando carro...");
    }

}
