package br.com.cryslefundes;

import java.util.Scanner;

public class Wrappers {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        System.out.print("Digite um numero: ");
        int num = leitura.nextInt();
        System.out.println("Variavel do tipo primitivo int -> " + num);
        Integer numWrapper = num;
        System.out.println("Variavel do tipo Wrapper Integer -> " + numWrapper);
    }


}
