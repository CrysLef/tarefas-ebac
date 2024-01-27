package br.com.cryslefundes.main;

import br.com.cryslefundes.SplitText;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        List<String> listMasc = new ArrayList<>();
        List<String> listFem = new ArrayList<>();
        splitText.separateNameGender(nameGenderList, listMasc, listFem);
        splitText.printNames(listFem);
        splitText.printNames(listMasc);

    }
}
