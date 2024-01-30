package br.com.cryslefundes.factory.abstrata;

public abstract class Carro {
    private String cor;
    private String tipoCombustivel;
    private int forcaACavalo;

    public Carro(String cor, String tipoCombustivel, int forcaACavalo){
        this.cor = cor;
        this.tipoCombustivel = tipoCombustivel;
        this.forcaACavalo = forcaACavalo;
    }

    public abstract void mudarMarcha();

    public void ligarMotor() {
        System.out.println("virando chave...");
        System.out.println("Seu carro foi ligado e está pronto para acelerar com uma potência de " + this.forcaACavalo + " cavalos");
    }

    public void limpar() {
        System.out.println("Seu carro foi limpo e o " + this.cor + " do seu " + getClass().getSimpleName() + " está brilhando!");
    }

    public void checarMecanica() {
        System.out.println("Mecanica verificada com sucesso, seu " + getClass().getSimpleName() + " parece bem!");
    }

    public void encherTanque() {
        System.out.println("Seu tanque está cheio, foi abastecido com " + this.tipoCombustivel);
    }
}
