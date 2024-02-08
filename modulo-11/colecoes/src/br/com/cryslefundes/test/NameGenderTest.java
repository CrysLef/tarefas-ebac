package br.com.cryslefundes.test;

import br.com.cryslefundes.main.Pessoa;
import br.com.cryslefundes.main.Sexo;
import br.com.cryslefundes.main.Split;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.cryslefundes.main.Main.separateGender;

public class NameGenderTest {
    @Test
    public void validaListaFeminina() {
        String userInput = "Crystian - M, Ana - F, Joao - M, Maria - F";

        List<String> nameGenderList = Split.splitString(userInput,",");
        List<Pessoa> listaDePessoas = nameGenderList.stream()
                .filter(p -> p.contains(" - "))
                .map(p -> p.split(" - "))
                .map(p -> new Pessoa(p[0].trim(), p[1].trim()))
                .collect(Collectors.toList());

        List<Pessoa> listaFem = separateGender(listaDePessoas, Sexo.FEM);
        Assert.assertTrue(listaFem.stream().allMatch(m -> m.getSexo().equalsIgnoreCase(Sexo.FEM.name())));

    }
}
