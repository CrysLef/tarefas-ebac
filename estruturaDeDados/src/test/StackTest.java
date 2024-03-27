package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structs.Stack;


import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    private final Stack<Integer> stack;

    StackTest() {
        this.stack = new Stack<>();
    }

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 9; i++) {
            stack.push(i);
        }
    }

    @Test
    @DisplayName("Valida se o método pop() remove o último elemento.")
    void validaSeRemoveUltimoElemento() {
        stack.pop();
        assertEquals(8, stack.top());
    }

    @Test
    @DisplayName("Valida se o método push() ao adicionar mais de 10 elementos, a pilha cresce.")
    void validaSeAumentaAPilha() {
        for (int i = 10; i <= 100; i++) {
            stack.push(i);
        }
        assertEquals(100, stack.top());
        assertEquals(100, stack.size());
    }

    @Test
    @DisplayName("Valida se o método pop() remove todos os elementos.")
    void validaSeRemoveTodosOsElementos() {
        while (!stack.isEmpty()) {
            stack.pop();
        }
        assertEquals(0, stack.size());
        assertNull(stack.top());
        assertTrue(stack.isEmpty());
    }

    @Test
    @DisplayName("Valida se retorna erro ao aumentar a capacidade da pilha para mais de 1024 elementos.")
    void validaSeRetornaErroAoPassarDoLimiteDeCapacidade() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 10; i <= 1025; i++) {
                stack.push(i);
            }
        });
        assertEquals(1024, stack.size());
        assertEquals(1024, stack.top());
    }

}