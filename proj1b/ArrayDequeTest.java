import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class ArrayDequeTest {
    /* Test add First*/
    @Test
    public void testaddFirstandresize() {
        ArrayDeque L = new ArrayDeque();
        L.addFirst(2);
        L.addFirst(1);
        L.addLast(3);
        assertEquals(3, L.size());
    }
}