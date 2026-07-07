package quiz1sample;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class WritingCodeTest {

	@Test
	void sum() {
		assertEquals(0, WritingCode.sum(new int[] {}));
		assertEquals(0, WritingCode.sum(new int[] {-1, 1}));
		assertEquals(6, WritingCode.sum(new int[] {1, 2, 3}));

		assertEquals(0, WritingCode.sum(new ArrayList<>()));
		assertEquals(0, WritingCode.sum(java.util.Arrays.asList(-1, 1)));
		assertEquals(6, WritingCode.sum(java.util.Arrays.asList(1, 2, 3)));
	}

	@Test
	void mean() {
		assertEquals(0, WritingCode.mean(new int[] {}));
		assertEquals(0, WritingCode.mean(new int[] {-1, 1}));
		assertEquals(2, WritingCode.mean(new int[] {1, 1, 4}));

		assertEquals(0, WritingCode.mean(new ArrayList<>()));
		assertEquals(0, WritingCode.mean(java.util.Arrays.asList(-1, 1)));
		assertEquals(2, WritingCode.mean(java.util.Arrays.asList(1, 1, 4)));
	}

	@Test
	void min() {
		assertEquals(0, WritingCode.min(new int[] {}));
		assertEquals(-1, WritingCode.min(new int[] {-1, 1}));
		assertEquals(1, WritingCode.min(new int[] {3, 2, 1}));

		assertEquals(0, WritingCode.min(new ArrayList<>()));
		assertEquals(-1, WritingCode.min(java.util.Arrays.asList(-1, 1)));
		assertEquals(1, WritingCode.min(java.util.Arrays.asList(3, 2, 1)));
	}

	@Test
	void max() {
		assertEquals(0, WritingCode.max(new int[] {}));
		assertEquals(1, WritingCode.max(new int[] {-1, 1}));
		assertEquals(3, WritingCode.max(new int[] {1, 2, 3}));

		assertEquals(0, WritingCode.max(new ArrayList<>()));
		assertEquals(1, WritingCode.max(java.util.Arrays.asList(-1, 1)));
		assertEquals(3, WritingCode.max(java.util.Arrays.asList(1, 2, 3)));
	}

	@Test
	void allEven() {
		assertTrue(WritingCode.allEven(new int[] {}));
		assertTrue(WritingCode.allEven(new int[] {-2, 4, 6}));
		assertFalse(WritingCode.allEven(new int[] {1, -2, 4}));

		assertTrue(WritingCode.allEven(new ArrayList<>()));
		assertTrue(WritingCode.allEven(java.util.Arrays.asList(-2, 4, 6)));
		assertFalse(WritingCode.allEven(java.util.Arrays.asList(1, -2, 4)));
	}

	@Test
	void someEven() {
		assertTrue(WritingCode.someEven(new int[] {}));
		assertTrue(WritingCode.someEven(new int[] {1, -2, 4}));
		assertFalse(WritingCode.someEven(new int[] {-1, 3, 5}));

		assertTrue(WritingCode.someEven(new ArrayList<>()));
		assertTrue(WritingCode.someEven(java.util.Arrays.asList(1, -2, 4)));
		assertFalse(WritingCode.someEven(java.util.Arrays.asList(-1, 3, 5)));
	}

	@Test
	void isSorted() {
		assertTrue(WritingCode.isSorted(new int[] {}));
		assertTrue(WritingCode.isSorted(new int[] {0, 0, 0}));
		assertTrue(WritingCode.isSorted(new int[] {-2, 4, 6}));
		assertFalse(WritingCode.isSorted(new int[] {1, 3, 2}));

		assertTrue(WritingCode.isSorted(new ArrayList<>()));
		assertTrue(WritingCode.isSorted(java.util.Arrays.asList(0, 0, 0)));
		assertTrue(WritingCode.isSorted(java.util.Arrays.asList(-2, 4, 6)));
		assertFalse(WritingCode.isSorted(java.util.Arrays.asList(1, 3, 2)));
	}

	@Test
	void isDoubling() {
		assertTrue(WritingCode.isDoubling(new int[] {}, -1));
		assertTrue(WritingCode.isDoubling(new int[] {0, 0, 0}, 0));
		assertTrue(WritingCode.isDoubling(new int[] {3, 3, 3}, 1));
		assertTrue(WritingCode.isDoubling(new int[] {1, 2, 4}, 2));
		assertTrue(WritingCode.isDoubling(new int[] {1, 3, 9}, 3));
		assertTrue(WritingCode.isDoubling(new int[] {1, -2, 4}, -2));

		assertTrue(WritingCode.isDoubling(new ArrayList<>(), -1));
		assertTrue(WritingCode.isDoubling(java.util.Arrays.asList(0, 0, 0), 0));
		assertTrue(WritingCode.isDoubling(java.util.Arrays.asList(3, 3, 3), 1));
		assertTrue(WritingCode.isDoubling(java.util.Arrays.asList(1, 2, 4), 2));
		assertTrue(WritingCode.isDoubling(java.util.Arrays.asList(1, 3, 9), 3));
		assertTrue(WritingCode.isDoubling(java.util.Arrays.asList(1, -2, 4), -2));
	}

	@Test
	void isPalindrome() {
		assertTrue(WritingCode.isPalindrome(new int[] {}));
		assertTrue(WritingCode.isPalindrome(new int[] {1}));
		assertTrue(WritingCode.isPalindrome(new int[] {1, 2, 1}));
		assertTrue(WritingCode.isPalindrome(new int[] {1, 3, 3, 1}));

		assertTrue(WritingCode.isPalindrome(new ArrayList<>()));
		assertTrue(WritingCode.isPalindrome(new ArrayList<>() {{
			add(1);
		}}));
		assertTrue(WritingCode.isPalindrome(java.util.Arrays.asList(1, 2, 1)));
		assertTrue(WritingCode.isPalindrome(java.util.Arrays.asList(1, 3, 3, 1)));
	}
}