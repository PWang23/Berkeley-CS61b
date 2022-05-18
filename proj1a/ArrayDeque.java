public class ArrayDeque<T> {
    public T[] items;
    public int size;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public void addFirst(T item) {
        if (nextFirst == nextLast - 1) {
            resizeUp();
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    public void addLast(T item) {
        if (nextFirst == nextLast - 1) {
            resizeUp();
        }
        items[nextLast] = item;
        nextLast++;
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
        for (int i = 0; i < nextLast; i++) {
            System.out.print(items[i] + " ");
        }
        for (int j = nextFirst + 1; j < size; j++) {
            System.out.print(items[j] + " ");
        }
        System.out.println();
    }

    private void resizeUp() {
        //length * 2
        T[] resizedArray = (T[]) new Object[items.length * 2];
        //resizedArray[0 : nextLast + 1] = items[0 : nextLast + 1]
        System.arraycopy(items, 0, resizedArray, 0, nextLast);
        //resizedArray[items.length + nextFirst + 1 : items.length*2] = items[nextFirst + 1 : items.length]
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
        //resizedArray[0 : nextLast + 1] = items[0 : nextLast + 1]
        System.arraycopy(items, 0, resizedArray, 0, nextLast);
        //resizedArray[items.length + nextFirst + 1 : items.length*2] = items[nextFirst + 1 : items.length]
        int desPos = nextFirst / 2;
        int len = items.length - nextFirst - 1;
        System.arraycopy(items, nextFirst + 1, resizedArray, desPos, len);
        nextFirst = nextFirst / 2 - 1;
        items = resizedArray;
    }





    public T removeFirst() {
        if (nextFirst == items.length - 1) {
            System.out.println("empty");
            return null;
        }
        if (nextFirst == items.length) {
            System.out.println("has reach the last");
            return null;
        }
        T result = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;

        //downsize check
        int usageRatio = size / items.length;
        if (usageRatio < 0.25 && items.length >= 16) {
            resizeDown();
        }
        return result;
    }


    public T removeLast() {
        if (nextLast == 0) {
            System.out.println("empty");
            return null;
        }
        if (nextLast < 0) {
            System.out.println("has reach the last");
            return null;
        }
        T result = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        //downsize check
        double usageRatio = size / (double) items.length;
        if (usageRatio < 0.25 && items.length >= 16) {
            resizeDown();
        }
        return result;
    }

    public T get(int index) {
        return items[index];
    }
}
