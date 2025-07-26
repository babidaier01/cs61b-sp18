public class LinkedListDeque<T> {
    private class IntNode {
        public T item;
        public IntNode next;
        public IntNode prev;

        public IntNode(T i, IntNode n, IntNode p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private IntNode sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        IntNode newNode = new IntNode(item, sentinel.next, sentinel);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
        size++;
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T item) {
        IntNode newNode = new IntNode(item, sentinel, sentinel.prev);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        IntNode p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        T removedItem = sentinel.next.item;

        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;

        size--;

        return removedItem;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        T removedItem = sentinel.prev.item;

        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;

        size--;

        return removedItem;
    }

    public T get(int index) {
        if (index < 0 || index >= size) { //check
            return null;
        }

        IntNode p = sentinel.next;
        int i = 0;

        while (i < index) {
            p = p.next;
            i++;
        }
        return p.item;
    }
}