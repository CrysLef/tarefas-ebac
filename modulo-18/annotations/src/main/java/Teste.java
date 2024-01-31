import java.util.Map;

public class Teste {
    @Tabela("Tabela de nomes")
    private Map<Integer, String> tabelaNomes;

    @Tabela(value = "Tabela de preços")
    public Map<Long, Double> preencheTabelaPreco() {
        return null;
    }

}
