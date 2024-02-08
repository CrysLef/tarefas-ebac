package br.com.cryslefundes.main;

public enum Sexo {
    MASC("M"),
    FEM("F");

    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public static Sexo fromString(String sx) {
        for (Sexo s: Sexo.values()) {
            if (s.sexo.equalsIgnoreCase(sx)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Sexo especificado digitado incorretamente.");
    }
}
