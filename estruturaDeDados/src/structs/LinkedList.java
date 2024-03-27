package structs;

public class LinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private int index;
    private static final int MAX_LINKED_LIST_CAPACITY = 1024;

    public LinkedList() {
        this.size = 0;
        this.index = -1;
    }

    public void push(E element) {
        if (size == MAX_LINKED_LIST_CAPACITY) throw new IndexOutOfBoundsException("Max capacity reached.");
        Node<E> newNode = new Node<>(element, tail, null);
        if (tail == null) {
            head = newNode;
        } else {
            Node<E> oldNode = tail;
            oldNode.next = newNode;
        }
        tail = newNode;
        size++;
        index++;
    } // O(1)

    public E pop() {
        if (isEmpty()) throw new RuntimeException("Your linked list is already empty.");
        Node<E> oldTail = tail;
        Node<E> prevOfOldTail = tail.prev;
        E removedElement = tail.item;

        if (prevOfOldTail != null) prevOfOldTail.next = null;
        tail = prevOfOldTail;

        oldTail.prev = null;
        oldTail.item = null;
        size--;
        index--;
        return removedElement;
    } // O(1)

    public void insert(E element, int index) {
        if (size == 1024) throw new IndexOutOfBoundsException("Max capacity reached.");
        Node<E> oldNode = getNodeAt(index);
        Node<E> newNode;

        if (oldNode == null) {
            newNode = new Node<>(element, null, null);
            head = newNode;
            tail = newNode;
        } else if (oldNode.next == null) {
            newNode = new Node<>(element, oldNode, null);
            tail = newNode;
        } else if (oldNode.prev == null) {
            newNode = new Node<>(element, null, oldNode);
            head = newNode;
        } else {
            Node<E> prevOfOldNode = oldNode.prev;
            newNode = new Node<>(element, prevOfOldNode, oldNode);
            if (newNode.prev == null) head = newNode;
            else prevOfOldNode.next = newNode;

            if (newNode.next == null) tail = newNode;

            oldNode.prev = newNode;
        }
        size++;
        this.index++;
    } // O(N)

    public void remove(int index) {
        Node<E> nodeToRemove = getNodeAt(index);
        Node<E> nextOfOldNode = nodeToRemove.next;
        Node<E> prevOfOldNode = nodeToRemove.prev;

        if (prevOfOldNode == null)
            head = nextOfOldNode;
        else {
            prevOfOldNode.next = nextOfOldNode;
            nodeToRemove.prev = null;
        }

        if (nextOfOldNode == null)
            tail = prevOfOldNode;
        else {
            nextOfOldNode.prev = prevOfOldNode;
            nodeToRemove.next = null;
        }

        nodeToRemove.item = null;
        size--;
        this.index--;
    } // O(N)

    public E elementAt(int index) {
        return getNodeAt(index).item;
    } // O(N)

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String list = null;
        if (isEmpty()) list = "[]";

        var sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++) {
            sb.append(elementAt(i));
            if (i == size - 1 && tail.next == null) {
                list = sb.append(']').toString();
                return list;
            }
            sb.append(',').append(' ');
        }
        return list;
    }

    public void printList() {
        System.out.printf("""
                head: %s
                tail: %s
                size: %d
                isEmpty: %b
                list: %s
                \n
                """,
                head, tail, size(), isEmpty(), this
                );
    }

    private Node<E> getNodeAt(int index) {
        if (!isIndexValid(index)) {
            throw new IndexOutOfBoundsException("Seu index nâo é válido.");
        }
        Node<E> n;
        if (index < (size >> 1)) {
            n = head;
            for (int i = 0; i < index; i++)
                n = n.next;
        } else {
            n = tail;
            for (int i = this.index; i > index ; i--)
                n = n.prev;
        }
        return n;
    }

    private boolean isIndexValid(int index) {
        return index <= size && index >= 0;
    }


    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        public Node(E item, Node<E> prev, Node<E> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return item.toString();
        }
    }
}
