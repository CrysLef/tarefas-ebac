package br.com.cryslefundes.main;

import br.com.cryslefundes.pessoa.PessoaFisica;
import br.com.cryslefundes.pessoa.PessoaJuridica;

public class Main {
    public static void main(String[] args) {
        PessoaFisica p1 = new PessoaFisica("227.387.430-80", "13/11/2003" );
        PessoaJuridica p2 = new PessoaJuridica("35.504.382/0001-75", "Madureira Comunicação e Participações S.A.");
        p1.setNome("Crystian");
        p1.declaraIRPF();
        p2.atualizarDadosCadastrais();
    }
}
