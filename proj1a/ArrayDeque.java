public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque(){
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 7;
        nextLast = 0;
    }

    public void printDeque(){
        for (int i = 0; i < nextLast; i++) {
            System.out.print(items[i] + " ");
        }
        for (int j = nextFirst + 1; j < size; j++) {
            System.out.print(items[j] + " ");
        }
        System.out.println();
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public T get(int index){
        return items[index];
    }

    public int size(){
        return size;
    }

    public void resize(){
        T[] resizedArray = (T[]) new Object[items.length*2];
        System.arraycopy(items,0,resizedArray,0,nextLast);
        System.arraycopy(items,nextFirst + 1,resizedArray,items.length + nextFirst + 1,items.length-nextFirst-1);
        nextFirst = items.length + nextFirst;
        items = resizedArray;
    }

    public void addFirst(T item){
        if (nextFirst == nextLast){
            resize();
        }
        items[nextFirst] = item;
        nextFirst--;
        size++;
    }

    public void addLast(T item){
        if (nextFirst == nextLast){
            resize();
        }
        items[nextLast] = item;
        nextFirst++;
        size++;
    }

    public T removeFirst(){
        if (isEmpty()){
            System.out.println("empty");
            return null;
        }
        if (nextFirst == items.length){
            System.out.println("has reach the last");
            return null;
        }
        T result = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst++;
        size--;
        return result;
    }

    public T removeLast(){
        if (isEmpty()){
            System.out.println("empty");
            return null;
        }
        if (nextLast < 0){
            System.out.println("has reach the last");
            return null;
        }
        T result = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast--;
        size--;
        return result;
    }
}
