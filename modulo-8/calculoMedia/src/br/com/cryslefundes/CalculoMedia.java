package br.com.cryslefundes;

public class CalculoMedia {
    private double[] notas;

    public CalculoMedia(double nota1, double nota2, double nota3, double nota4){
        this.notas = new double[]{nota1, nota2, nota3, nota4};
    }

    public double[] getNotas() {
        return notas;
    }
    public double calcularMedia(){
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public String statusAluno(){
        double media = this.calcularMedia();
        if(media >= 7){
            return "Aprovado";
        }else if(media < 7 && media >= 5){
            return "Em recuperação";
        }else {
            return "Reprovado";
        }
    }
}
