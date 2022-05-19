import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Performs some basic Array Deque tests.
 * Practise Test Driven Development (TDD).
 */
public class ArrayDequeTest {
    /**
     * remove Last when last does not exist
     */
    @Test
    public void test1() {
        ArrayDeque L = new ArrayDeque();
        assertEquals(null, L.removeLast());
    }

    /**
     * remove First when First does not exist
     */
    @Test
    public void test2() {
        ArrayDeque L = new ArrayDeque();
        assertEquals(null, L.removeFirst());
    }

    /**
     * resizeUp all addLast
     */
    @Test
    public void test3() {
        ArrayDeque L = new ArrayDeque();
        L.addLast(0);
        L.addLast(1);
        L.get(0);
        L.addLast(2);
        L.addLast(3);
        L.get(3);
        L.addLast(4);
        assertEquals(3,L.get(3));
        L.addLast(5);
        L.addLast(6);
        L.addLast(7);
        L.addLast(8);
        L.addLast(9);
        L.removeFirst();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
        L.removeLast();
    }

    /**
     * add First then remove Last
     */
    @Test
    public void test4() {
        ArrayDeque L = new ArrayDeque();
        L.addFirst(1);
        L.addFirst(2);
        L.addFirst(3);
        L.addFirst(4);
        L.addFirst(5);
        L.addFirst(6);
        L.addFirst(7);
        L.addFirst(8);
        L.addFirst(9);
        L.addFirst(10);
        L.addFirst(1);
        L.addFirst(1);
    }
}
