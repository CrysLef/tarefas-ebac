package br.com.cryslefundes.main;

import java.util.Objects;

public class Pessoa implements Comparable<Pessoa>{
    private String nome;
    private Sexo sexo;

    public Pessoa(String nome, String sexo) {
        this.nome = nome;
        this.sexo = Sexo.fromString(sexo);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo.toString();
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(nome, pessoa.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    @Override
    public String toString() {
        return "Nome: '" + nome + '\'' +
                ", Sexo: " + sexo.toString();
    }


    @Override
    public int compareTo(Pessoa p) {
        return this.nome.compareTo(p.nome);
    }
}
