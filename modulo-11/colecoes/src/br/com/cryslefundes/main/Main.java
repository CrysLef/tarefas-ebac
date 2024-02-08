package br.com.cryslefundes.main;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);

        // Tarefa 1:
        System.out.print("Digite nomes separados por virgula: ");
        String names = leitura.nextLine();

        List<String> nameList = Split.splitString(names, ",");
        printSorted(nameList);

        // Tarefa 2:
        System.out.print("Digite nomes e sexo separados por virgula (Ex. Foo - M, Bar - F): ");
        String nameGender = leitura.nextLine();

        List<String> nameGenderList = Split.splitString(nameGender,",");
        List<Pessoa> listaDePessoas = nameGenderList.stream()
                .filter(p -> p.contains(" - "))
                .map(p -> p.split(" - "))
                .map(p -> new Pessoa(p[0].trim(), p[1].trim()))
                .collect(Collectors.toList());

        List<Pessoa> listaMasc = separateGender(listaDePessoas, Sexo.MASC);
        printSorted(listaMasc);

        List<Pessoa> listaFem = separateGender(listaDePessoas, Sexo.FEM);
        printSorted(listaFem);


    }

    public static void printSorted(List<?> list){
        List<?> sortedList = list.stream()
                .sorted()
                .toList();
        System.out.println("=========================");
        sortedList.forEach(n -> System.out.println(n.toString().trim()));
        System.out.println("=========================");
    }

    public static List<Pessoa> separateGender(List<Pessoa> lista, Sexo gender) {
        List<Pessoa> genderSeparatedList = lista.stream()
                .filter(p -> p.getSexo().equalsIgnoreCase(gender.name()))
                .toList();
        return genderSeparatedList;
    }
}
