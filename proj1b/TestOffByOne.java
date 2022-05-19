import org.junit.Test;
import static org.junit.Assert.*;

public class TestOffByOne {
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testAlphabeticalChar(){
        assertTrue(offByOne.equalChars('a', 'b'));
        assertTrue(offByOne.equalChars('b', 'a'));
        assertFalse(offByOne.equalChars('a', 'e'));
        assertFalse(offByOne.equalChars('a', ' '));
    }

    @Test
    public void testNonAlphabeticalChar(){
        assertTrue(offByOne.equalChars('&', '%'));
        assertFalse(offByOne.equalChars('a', '*'));
    }

    @Test
    public void testUpperAndLowerCase(){
        assertFalse(offByOne.equalChars('a', 'B'));
    }
}
