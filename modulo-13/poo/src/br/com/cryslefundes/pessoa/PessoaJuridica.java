package br.com.cryslefundes.pessoa;

public class PessoaJuridica extends Pessoa{
    private String cnpj;
    private String razaoSocial;

    public PessoaJuridica(String cnpj, String razaoSocial) {
        this.cnpj = cnpj;
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public void atualizarDadosCadastrais() {
        System.out.println("Dados atualizados com sucesso!");
    }
}
