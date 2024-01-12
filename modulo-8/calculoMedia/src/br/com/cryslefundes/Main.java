package br.com.cryslefundes;

public class Main {
    public static void main(String[] args) {
        CalculoMedia media = new CalculoMedia(4.5, 7.2, 9.1, 8.6);
        System.out.println(media.calcularMedia());
        System.out.println(media.statusAluno());
    }
}
