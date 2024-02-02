package br.com.cryslefundes.main;

import br.com.cryslefundes.SplitText;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var splitText = new SplitText();
        Scanner leitura = new Scanner(System.in);

        // Tarefa 1:
        System.out.print("Digite nomes separados por virgula: ");
        String names = leitura.nextLine();

        List<String> nameList = splitText.splitString(names, ",");
        splitText.printNames(nameList);

        // Tarefa 2:
        System.out.print("Digite nomes e sexo separados por virgula: ");
        String nameGender = leitura.nextLine();

        List<String> nameGenderList = splitText.splitString(nameGender,",");

        // Streams:
        System.out.println("***** Stream *****");
        nameGenderList.stream()
                .filter(p -> p.contains(" - F"))
                .map(f -> f.split("-")[0])
                .forEach(System.out::println);

        System.out.println("***** Método convencional *****");
        List<String> listMasc = new ArrayList<>();
        List<String> listFem = new ArrayList<>();
        splitText.separateNameGender(nameGenderList, listMasc, listFem);
        splitText.printNames(listFem);
        splitText.printNames(listMasc);

    }
}
