package br.com.cryslefundes.main;

import java.util.*;

public class Split {

    public static List<String> splitString(String text, String regex) {
        String[] textList = text.split(regex);
        return new ArrayList<>(Arrays.asList(textList));
    }
}
