package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structs.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class HashMapTest {

    private final HashMap<Integer, String> hashMap;

    public HashMapTest() {
        this.hashMap = new HashMap<>();
    }

    @BeforeEach
    void setUp() {
        for (int i = 10; i <= 80; i += 10) {
             hashMap.put(i * 123, ((i % 4 == 0) ? "crystian" : "lefundes"));
        }
    }

    @Test
    @DisplayName("Valida se o método put() não adiciona mais do que 10 elementos.")
    void validaSeNaoAddMaisDoque10Elementos() {
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 10; i <= 100; i++) {
                hashMap.put(i * 8, "lefundes");
            }
        });
    }

    @Test
    @DisplayName("Valida se o método hash() retorna erro ao adicionar uma chave inválida.")
    void validaSeRetornaErroAoPassarChaveInvalida() {
        assertThrows(IllegalArgumentException.class, () -> hashMap.put(null, "lefundes"));
    }

    @Test
    @DisplayName("Valida se o método get() retorna o elemento esperado.")
    void validaSeRetornaElementoEsperado() {
        assertEquals("crystian", hashMap.get(1230));
    }

    @Test
    @DisplayName("Valida se o método clear() limpa o mapa.")
    void validaSeLimpaOMapa() {
        hashMap.clear();
        assertEquals("{}", hashMap.toString());
        assertTrue( hashMap.isEmpty());
    }

    @Test
    @DisplayName("Valida se o método delete() remove um elemento no mapa.")
    void validaSeRemoveUmElementoNoMapa() {
        hashMap.delete(1230);
        assertNull(hashMap.get(1230));
    }

    @Test
    @DisplayName("Valida se o método delete() remove todos os elementos.")
    void validaSeRemoveTodosOsElementos() {
        assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < 100; i++) {
                hashMap.delete(i * 123);
            }
        });
        assertTrue(hashMap.isEmpty());
    }

}