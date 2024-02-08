package br.com.cryslefundes;

import java.util.*;

public class Split<T> {

    public static List<String> splitString(String text, String regex) {
        String[] textList = text.split(regex);
        return new ArrayList<>(Arrays.asList(textList));
    }
}
