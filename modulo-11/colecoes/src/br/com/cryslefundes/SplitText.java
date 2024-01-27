package br.com.cryslefundes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SplitText {

    public void printNames(List<String> nameList){
        Collections.sort(nameList);
        System.out.println("=========================");
        nameList.forEach(n -> System.out.println(n.trim()));
        System.out.println("=========================");
    }

    public List<String> splitString(String text, String regex){
        String[] textList = text.split(regex);
        return new ArrayList<>(Arrays.asList(textList));
    }

    public void separateNameGender(List<String> nameGenderList, List<String> listMasc, List<String> listFem){
        for(String name: nameGenderList){
            if(name.contains(" - M")){
                List<String> separateName = this.splitString(name, "-");
                name = separateName.get(0).trim();
                listMasc.add(name);

            } else if (name.contains(" - F")) {
                List<String> separateName = this.splitString(name, "-");
                name = separateName.get(0).trim();
                listFem.add(name);
            }
        }
    }
}
