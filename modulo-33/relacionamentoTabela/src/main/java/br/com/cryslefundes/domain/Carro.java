package main.java.br.com.cryslefundes.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CARROS")
public class Carro {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private Integer ano;
    @ManyToOne
    @JoinTable(
            name = "TB_CARRO_MARCA",
            joinColumns = { @JoinColumn(name = "id_carro") },
            inverseJoinColumns = { @JoinColumn(name = "id_marca") }
    )
    private Marca marca;
    @ManyToMany
    @JoinTable(
            name = "TB_CARROS_ACESSORIOS",
            joinColumns = { @JoinColumn(name = "id_carro") },
            inverseJoinColumns = { @JoinColumn(name = "id_acessorio") }
    )
    private List<Acessorio> acessorios;

    public Carro() {
        this.acessorios = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public List<Acessorio> getAcessorios() {
        return acessorios;
    }

    public void setAcessorios(List<Acessorio> acessorios) {
        this.acessorios = acessorios;
    }


    public void add(Acessorio acessorio) {
        this.acessorios.add(acessorio);
    }
}
