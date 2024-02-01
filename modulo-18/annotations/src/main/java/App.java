import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
        var teste = new Teste();
        getAnnottationFieldValue(teste);
        getAnnottationMethodValue(teste);
    }
    private static <T> void getAnnottationFieldValue(T entidade) {
        Field[] fields = entidade.getClass().getDeclaredFields();
        for (Field field: fields) {
            if (field.isAnnotationPresent(Tabela.class)) {
                String tabela = field.getAnnotation(Tabela.class).value();
                System.out.println(tabela);
            }
        }

    }

    private static <T> void getAnnottationMethodValue(T entidade) {
        Method[] methods = entidade.getClass().getDeclaredMethods();
        for (Method m: methods) {
            if (m.isAnnotationPresent(Tabela.class)) {
                String tabela = m.getAnnotation(Tabela.class).value();
                System.out.println(tabela);
            }
        }
    }
}
