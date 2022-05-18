public class LinkedListDeque<T> {
    private class Node {
        private Node prev;
        private T item;
        private Node next;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    public void addFirst(T item) {
        Node first = new Node(sentinel, item, sentinel.next);
        sentinel.next.prev = first;
        sentinel.next = first;
        size++;
    }

    public void addLast(T item) {
        Node last = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.next = last;
        sentinel.prev = last;
        size++;
    }

    public boolean isEmpty() {
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node node = sentinel.next;
        while (node.next != sentinel) {
            System.out.print(node.item + " ");
            node = node.next;
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        T first = sentinel.next.item;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size--;
        return first;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        T last = sentinel.prev.item;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node node = sentinel.next;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getRecHelp(sentinel.next, index);
    }

    private T getRecHelp(Node startItem, int idx) {
        if (idx ==  0) {
            return startItem.item;
        }
        startItem = startItem.next;
        return getRecHelp(startItem, idx - 1);
    }
}
