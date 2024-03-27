package structs;

import java.util.Arrays;
import java.util.Objects;

public class Queue<E> {

    private Object[] queue;
    private int elementCount;
    private int tail;
    private int first;
    private static final int DEFAULT_STACK_CAPACITY = 10;
    private static final int MAX_STACK_CAPACITY = 1024;

    public Queue() {
        this.queue = new Object[DEFAULT_STACK_CAPACITY];
        this.elementCount = 0;
        this.tail = -1;
        this.first = 0;
    }

    public void enqueue(E element) {
        if (elementCount == MAX_STACK_CAPACITY) throw new ArrayIndexOutOfBoundsException("Max capacity reached");
        if (queue.length == elementCount) queue = grow();
        queue[tail + 1] = element;
        elementCount++;
        tail++;
    } // O(1)
    public void dequeue() {
        if (isEmpty()) {
            this.first = 0;
            throw new ArrayIndexOutOfBoundsException("Your queue is already empty.");
        }

        queue[first] = null;
        first++;

        elementCount--;
        tail--;
    } // O(1)

    public Object rear() {
        if (tail == - 1) return queue[tail + 1];
        return queue[tail];
    } // O(1)

    public Object front() {
        return queue[first];
    } // O(1)

    public int size() {
        return elementCount;
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    private Object[] grow() {
        int minCapacity = elementCount + 1;
        int oldCapacity = queue.length;
        int minGrowth = minCapacity - oldCapacity;
        int prefGrowth = (oldCapacity < 64) ? oldCapacity + 2 : (oldCapacity >> 1);

        int newCapacity = newArrayCapacity(oldCapacity, minGrowth, prefGrowth);
        if (newCapacity > MAX_STACK_CAPACITY) newCapacity = MAX_STACK_CAPACITY;
        return Arrays.copyOf(queue, newCapacity);
    }

    private int newArrayCapacity(int oldCapacity, int minGrowth, int prefGrowth) {
        return oldCapacity + Math.max(minGrowth, prefGrowth);
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "[]";

        var sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < elementCount; i++) {
            sb.append(queue[i]);
            if (Objects.equals(queue[i], rear()) && i == (elementCount - 1)) {
                sb.append(']');
            } else {
                sb.append(',').append(' ');
            }
        }
        return sb.toString();
    }

    public void print() {
        System.out.printf(
                """
                front=%s
                isEmpty=%b
                size=%d
                stack=%s
                \n
                """,
                front(), isEmpty(), size(), this
        );
    }

}
