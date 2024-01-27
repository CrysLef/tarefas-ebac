package br.com.cryslefundes.pessoa;

public class PessoaFisica extends Pessoa {
    private String cpf;
    private String dataNascimento;

    public PessoaFisica(String cpf, String dataNascimento) {
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void declaraIRPF(){
        System.out.println("O imposto de renda de " + this.nome + ", cujo o CPF é " + this.cpf + " foi declarado com sucesso!");
    }

    @Override
    public void atualizarDadosCadastrais() {
        System.out.println("Dados atualizados com sucesso!");
    }
}
