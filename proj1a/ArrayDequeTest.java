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
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
        L.addLast(1);
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
        L.removeLast();
        assertEquals(null, L.removeLast());
    }
}
