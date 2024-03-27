package structs;

import java.util.Arrays;
import java.util.Objects;

public class Stack<E> {

    private int top;
    private Object[] stack;
    private int elementCount;
    private static final int DEFAULT_STACK_CAPACITY = 10;
    private static final int MAX_STACK_CAPACITY = 1024;

    public Stack() {
        this.stack = new Object[DEFAULT_STACK_CAPACITY];
        this.top = -1;
        this.elementCount = 0;
    }

    public void push(E element) {
        if (elementCount == MAX_STACK_CAPACITY) throw new ArrayIndexOutOfBoundsException("Max capacity reached");
        if (stack.length == elementCount) stack = grow();
        stack[top + 1] = element;
        top++;
        elementCount++;
    }  // O(1)

    public void pop() {
        if (top <= -1) throw new ArrayIndexOutOfBoundsException("Your stack is already empty.");

        stack[top] = null;
        elementCount--;
        top--;
    } // O(1)

    public Object top() {
        if (top == -1) return stack[top + 1];
        return stack[top];
    }

    public boolean isEmpty() {
        return elementCount == 0;
    }

    public int size() {
        return elementCount;
    }

    private Object[] grow() {
        int minCapacity = elementCount + 1;
        int oldCapacity = stack.length;
        int minGrowth = minCapacity - oldCapacity;
        int prefGrowth = (oldCapacity < 64) ? oldCapacity + 2 : (oldCapacity >> 1);

        int newCapacity = newArrayCapacity(oldCapacity, minGrowth, prefGrowth);
        if (newCapacity > MAX_STACK_CAPACITY) newCapacity = MAX_STACK_CAPACITY;
        return Arrays.copyOf(stack, newCapacity);
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
            sb.append(stack[i]);
            if (Objects.equals(stack[i], top())) {
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
                top=%s
                isEmpty=%b
                size=%d
                stack=%s
                \n
                """,
                top(), isEmpty(), size(), this
        );
    }
}
