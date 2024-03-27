package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import structs.Queue;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    private final Queue<Integer> queue;

    QueueTest() {
        this.queue = new Queue<>();
    }

    @BeforeEach
    void setUp() {
        for (int i = 1; i <= 9; i++) {
            queue.enqueue(i);
        }
    }

    @Test
    @DisplayName("Valida se o método dequeue() remove o primeiro elemento.")
    void validaSeRemoveOPrimeiroElemento() {
        queue.dequeue();
        assertEquals(2, queue.front());
    }

    @Test
    @DisplayName("Valida se o método enqueue() ao adicionar mais de 10 elementos, a fila cresce.")
    void validaSeAumentaAFila() {
        for (int i = 10; i <= 100; i++) {
            queue.enqueue(i);
        }
        assertEquals(100, queue.rear());
        assertEquals(1, queue.front());
        assertEquals(100, queue.size());
    }

    @Test
    @DisplayName("Valida se o método dequeue() remove todos os elementos.")
    void validaSeRemoveTodosOsElementos() {
        while (!queue.isEmpty()) {
            queue.dequeue();
        }
        assertEquals(0, queue.size());
        assertNull(queue.rear());
        assertNull(queue.front());
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Valida se retorna erro ao aumentar a capacidade da pilha para mais de 1024 elementos.")
    void validaSeRetornaErroAoPassarDoLimiteDeCapacidade() {

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            for (int i = 10; i <= 1025; i++) {
                queue.enqueue(i);
            }
        });
        assertEquals(1024, queue.size());
        assertEquals(1024, queue.rear());
        assertEquals(1, queue.front());
    }
}