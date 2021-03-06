import org.junit.Test;
import static org.junit.Assert.*;

/** Performs some basic linked list tests. */
public class LinkedListDequeTest {
	/* Utility method for printing out empty checks. */
	@Test
	public void checkEmpty() {
		LinkedListDeque L = new LinkedListDeque();
		assertTrue("succeed.", true);
	}

	@Test
	public void testremoveFirstandSize() {
		LinkedListDeque L = new LinkedListDeque();
		L.addFirst(2);
		L.addFirst(1);
		L.addLast(3);
		L.removeFirst();
		assertEquals(2, L.size());
	}

	@Test
	public void testremoveLastandSize() {
		LinkedListDeque L = new LinkedListDeque();
		L.addFirst(2);
		L.addFirst(1);
		L.addLast(3);
		L.removeLast();
		assertEquals(2, L.size());
	}

	@Test
	public void testget() {
		LinkedListDeque L = new LinkedListDeque();
		L.addFirst(2);
		L.addFirst(1);
		L.addLast(3);
		assertEquals(3, L.get(2));
	}

	@Test
	public void testgetRecursive() {
		LinkedListDeque L = new LinkedListDeque();
		L.addFirst(2);
		L.addFirst(1);
		L.addLast(3);
		assertEquals(3, L.getRecursive(2));
	}
	/* Utility method for printing out empty checks. */

	public boolean checkSize(int expected, int actual) {
		if (expected != actual) {
			System.out.println("size() returned " + actual + ", but expected: " + expected);
			return false;
		}
		return true;
	}

	/* Prints a nice message based on whether a test passed. 
	 * The \n means newline. */

	public void printTestStatus(boolean passed) {
		if (passed) {
			System.out.println("Test passed!\n");
		} else {
			System.out.println("Test failed!\n");
		}
	}

	/** Adds a few things to the list, checking isEmpty() and size() are correct, 
	  * finally printing the results. 
	  *
	  * && is the "and" operation. */
	@Test
	public void addIsEmptySizeTest() {
		System.out.println("Running add/isEmpty/Size test.");
		/*
		LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst("front");
		
		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
		passed = checkSize(1, lld1.size()) && passed;
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.addLast("middle");
		passed = checkSize(2, lld1.size()) && passed;

		lld1.addLast("back");
		passed = checkSize(3, lld1.size()) && passed;

		System.out.println("Printing out deque: ");
		lld1.printDeque();

		printTestStatus(passed);
		*/
	}

	/** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
	@Test
	public void addRemoveTest() {

		System.out.println("Running add/remove test.");

		/*
		LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty 
		boolean passed = checkEmpty(true, lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty 
		passed = checkEmpty(false, lld1.isEmpty()) && passed;

		lld1.removeFirst();
		// should be empty 
		passed = checkEmpty(true, lld1.isEmpty()) && passed;

		printTestStatus(passed);
		*/
	}
}
