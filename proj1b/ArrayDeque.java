public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    public void addFirst(T item) {
        if (size == items.length) {
            resizeUp();
        }
        items[nextFirst] = item;
        if (nextFirst == 0) {
            nextFirst = items.length - 1;
        } else {
            nextFirst--;
        }
        size++;
    }

    public void addLast(T item) {
        if (size == items.length) {
            resizeUp();
        }
        items[nextLast] = item;
        if (nextLast == items.length - 1) {
            nextLast = 0;
        } else {
            nextLast++;
        }
        size++;
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        // if nextFirst < nextLast print items[nextFirst + 1 : nextLast]
        if (nextFirst < nextLast) {
            for (int i = nextFirst + 1; i < nextLast; i++) {
                System.out.print(items[i] + " ");
            }
            // if nextFirst >= nextLast
            // print items[nextFirst + 1 : ]
            // print items[ : nexLast]
        } else {
            for (int j = nextFirst + 1; j < items.length; j++) {
                System.out.print(items[j] + " ");
            }
            for (int m = 0; m < nextLast; m++) {
                System.out.print(items[m] + " ");
            }
        }
        System.out.println();
    }

    private void resizeUp() {
        //length * 2
        T[] resizedArray = (T[]) new Object[items.length * 2];
        //resizedArray[0 : nextLast] = items[0 : nextLast]
        System.arraycopy(items, 0, resizedArray, 0, nextLast);
        //resizedArray
        // [items.length + nextFirst + 1 : items.length*2]
        // = items[nextFirst + 1 : items.length]
        int desPos = items.length + nextFirst + 1;
        int len = items.length - nextFirst - 1;
        System.arraycopy(items, nextFirst + 1, resizedArray, desPos, len);
        //nextLast does not need change
        nextFirst = items.length + nextFirst;
        items = resizedArray;
    }

    private void resizeDown() {
        //length / 2
        T[] resizedArray = (T[]) new Object[items.length / 2];
        //resizedArray[0 : nextLast] = items[0 : nextLast]
        System.arraycopy(items, 0, resizedArray, 0, nextLast);
        //resizedArray
        // [items.length + nextFirst + 1 : items.length*2]
        // = items[nextFirst + 1 : items.length]
        int desPos = nextFirst / 2;
        int len = items.length - nextFirst - 1;
        System.arraycopy(items, nextFirst + 1, resizedArray, desPos, len);
        nextFirst = nextFirst / 2 - 1;
        items = resizedArray;
    }

    public T removeFirst() {
        if (isEmpty()) {
            System.out.println("empty");
            return null;
        }

        // Special case:
        // First just turn to the last in the deque (items.length - 1)
        T removedFirst = items[0];
        if (nextFirst != items.length - 1) {
            removedFirst = items[nextFirst + 1];
            items[nextFirst + 1] = null;
            nextFirst++;
        } else {
            items[0] = null;
            nextFirst = 0;
        }
        size--;

        //downsize check
        double usageRatio = size / (double) items.length;
        if (usageRatio < 0.25 && items.length >= 16) {
            resizeDown();
        }
        return removedFirst;
    }


    public T removeLast() {
        if (isEmpty()) {
            System.out.println("empty");
            return null;
        }

        // Special case:
        // Last just turn to the start of the deque (0)
        T removedLast = items[items.length - 1];
        if (nextLast != 0) {
            removedLast = items[nextLast - 1];
            items[nextLast - 1] = null;
            nextLast--;
        } else {
            items[items.length - 1] = null;
            nextLast = items.length - 1;
        }
        size--;

        //downsize check
        double usageRatio = size / (double) items.length;
        if (usageRatio < 0.25 && items.length >= 16) {
            resizeDown();
        }
        return removedLast;
    }

    public T get(int index) {
        if (nextFirst + 1 + index <= items.length - 1) {
            return items[nextFirst + 1 + index];
        } else {
            return items[nextFirst + 1 + index - items.length];
        }
    }
}
