package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structs.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    private final LinkedList<Integer> linkedList;

    public LinkedListTest() {
        this.linkedList = new LinkedList<>();
    }

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 9; i++) {
            linkedList.push(i);
        }
    }

    @Test
    @DisplayName("Valida se o método push() não adiciona mais do que 1024 elementos.")
    void validaSeNaoAddMaisDoque1024Elementos() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            for (int i = 0; i <= 1025; i++) {
                linkedList.push(i);
            }
        });
        assertEquals(1024, linkedList.size());
    }

    @Test
    @DisplayName("Valida se o método pop() remove o último elemento.")
    void validaSeRemoveOPrimeiroElemento() {
        Integer removedElement = linkedList.pop();
        assertEquals(8, linkedList.elementAt(7));
        assertEquals(9, removedElement);
    }

    @Test
    @DisplayName("Valida se o método pop() remove todos os elemento.")
    void validaSeRemoveTodosOsElementos() {
        while (!linkedList.isEmpty()) linkedList.pop();
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @Test
    @DisplayName("Valida se o método pop() não remove uma quantidade maior do que a capacidade da lista.")
    void validaSeNaoRemoveELementosAMais() {
        assertThrows(RuntimeException.class, () -> {
            for (int i = 0; i < 100; i++) {
                linkedList.pop();
            }
        });
        assertEquals(0, linkedList.size());
    }

    @Test
    @DisplayName("Valida se o método insert() insere um elemento no final da lista.")
    void validaSeInsereElementoNoFinal() {
        int indexFinal = linkedList.size();
        linkedList.insert(42, indexFinal);

        assertEquals(42, linkedList.elementAt(indexFinal));
    }

    @Test
    @DisplayName("Valida se o método insert() insere um elemento no meio da lista.")
    void validaSeInsereElementoNoMeio() {
        linkedList.insert(33, 3);
        assertEquals(33, linkedList.elementAt(3));
    }

    @Test
    @DisplayName("Valida se o método insert() insere um elemento no inicio da lista.")
    void validaSeInsereElementoNoInicio() {
        linkedList.insert(23, 0);
        assertEquals(23, linkedList.elementAt(0));
    }

    @Test
    @DisplayName("Valida se o método insert() não insere um elemento em um index inválido.")
    void validaSeNaoInsereElementoEmIndexInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.insert(99, 10));
    }

    @Test
    @DisplayName("Valida se o método remove() remove um elemento no final da lista.")
    void validaSeRemoveElementoNoFinal() {;
        linkedList.remove(linkedList.size());

        assertEquals(8, linkedList.size());
        assertEquals(8, linkedList.elementAt(linkedList.size()));
    }

    @Test
    @DisplayName("Valida se o método remove() remove um elemento no meio da lista.")
    void validaSeRemoveElementoNoMeio() {
        linkedList.remove(linkedList.size());

        assertEquals(8, linkedList.size());
        assertEquals(8, linkedList.elementAt(linkedList.size()));
    }

    @Test
    @DisplayName("Valida se o método remove() remove um elemento no inicio da lista.")
    void validaSeRemoveElementoNoInicio() {
        linkedList.remove(0);

        assertEquals(8, linkedList.size());
        assertEquals(2, linkedList.elementAt(0));
    }

    @Test
    @DisplayName("Valida se o método remove() não remove um elemento em um index inválido.")
    void validaSeNaoRemoveElementoEmIndexInvalido() {
        assertThrows(IndexOutOfBoundsException.class, () -> linkedList.remove( 10));
    }


}