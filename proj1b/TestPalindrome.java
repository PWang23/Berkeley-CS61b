import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome1() {
        assertFalse(palindrome.isPalindrome("persiflage"));
    }

    @Test
    public void testisPalindrome2() {
        assertTrue(palindrome.isPalindrome(""));
    }

    @Test
    public void testisPalindrome3() {
        assertTrue(palindrome.isPalindrome("a"));
    }

    @Test
    public void testisPalindrome4() {
        assertFalse(palindrome.isPalindrome("aA"));
    }

    @Test
    public void testisPalindrome5() {
        assertTrue(palindrome.isPalindrome("racecar"));
    }

    @Test
    public void testisPalindrome6() {
        assertTrue(palindrome.isPalindrome("noon"));
    }

    @Test
    public void testisPalindromeOffByOne1() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("noon", cc));
        assertTrue(palindrome.isPalindrome("flake", cc));
    }
}
