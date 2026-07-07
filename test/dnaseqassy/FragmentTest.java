/*
 * Copyright 2021 Marc Liberatore.
 */

package dnaseqassy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import static org.junit.jupiter.api.Assertions.*;

@Timeout(value = 10)
public class FragmentTest {

	@Test
	public void testValidConstructor() {
		new Fragment("GCAT");
	}

	@Test()
	public void testInvalidConstructor1() {
		assertThrows(IllegalArgumentException.class, () -> new Fragment("MARC"));
	}

	@Test()
	public void testInvalidConstructor2() {
		assertThrows(IllegalArgumentException.class, () -> new Fragment("G C A T"));
	}

	@Test
	public void testLength1() {
		Fragment f = new Fragment("G");
		assertEquals(1, f.length());
	}

	@Test
	public void testLength5() {
		Fragment f = new Fragment("GGCAT");
		assertEquals(5, f.length());
	}

	@Test
	public void testToString() {
		Fragment f = new Fragment("GCAT");
		assertEquals("GCAT", f.toString());
	}

	@Test
	@SuppressWarnings("all")
	public void testEqualsTrue1() {
		Fragment f = new Fragment("GCAT");
		assertEquals(f, f);
	}

	@Test
	public void testEqualsTrue2() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("GCAT");
		assertEquals(f, g);
		assertEquals(g, f);
	}

	@Test
	public void testNotEqualsNull() {
		Fragment f = new Fragment("GCAT");
		assertNotEquals(null, f);
	}

	@Test
	public void testNotEqualsObject() {
		Fragment f = new Fragment("GCAT");
		assertNotEquals(new Object(), f);
	}

	@Test
	public void testNotEqual() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("TACG");
		assertNotEquals(f, g);
	}

	@Test
	public void testNoOverlap() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("CGTA");
		assertEquals(0, f.calculateOverlap(g));
	}

	@Test
	public void testOneOverlap() {
		Fragment f = new Fragment("GGGA");
		Fragment g = new Fragment("AGGG");
		assertEquals(1, f.calculateOverlap(g));
	}

	@Test
	public void testTwoOverlap() {
		Fragment f = new Fragment("GGAC");
		Fragment g = new Fragment("ACGG");
		assertEquals(2, f.calculateOverlap(g));
	}

	@Test
	public void testTwoOverlapBounds() {
		Fragment f = new Fragment("TAC");
		Fragment g = new Fragment("ACAGAT");
		assertEquals(2, f.calculateOverlap(g));
	}

	@Test
	public void testTwoOverlapReverseBounds() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("AT");
		assertEquals(2, f.calculateOverlap(g));
	}

	@Test
	public void testThreeOverlap() {
		Fragment f = new Fragment("GGAAC");
		Fragment g = new Fragment("AACGG");
		assertEquals(3, f.calculateOverlap(g));
	}

	@Test
	public void testOverlapPastBounds() {
		Fragment f = new Fragment("GGAA");
		Fragment g = new Fragment("AAGGAA");
		assertEquals(2, f.calculateOverlap(g));
	}

	@Test
	public void testMultipleOverlap() {
		Fragment f = new Fragment("GGAACA");
		Fragment g = new Fragment("AACAGG");
		assertEquals(4, f.calculateOverlap(g));
	}

	@Test
	public void testNoMerge() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("CGTA");
		assertEquals(new Fragment("GCATCGTA"), f.mergedWith(g));
	}

	@Test
	public void testOneMerge() {
		Fragment f = new Fragment("GGGA");
		Fragment g = new Fragment("AGGG");
		assertEquals(new Fragment("GGGAGGG"), f.mergedWith(g));
	}

	@Test
	public void testTwoMerge() {
		Fragment f = new Fragment("GGAC");
		Fragment g = new Fragment("ACGG");
		assertEquals(new Fragment("GGACGG"), f.mergedWith(g));
	}

	@Test
	public void testSameMergeLength() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("GCAT");
		assertEquals(4, f.calculateOverlap(g));
	}

	@Test
	public void testSameMerge() {
		Fragment f = new Fragment("GCAT");
		Fragment g = new Fragment("GCAT");
		assertEquals(new Fragment("GCAT"), f.mergedWith(g));
	}

	@Test
	public void testThreeMerge() {
		Fragment f = new Fragment("GGAAC");
		Fragment g = new Fragment("AACGG");
		assertEquals(new Fragment("GGAACGG"), f.mergedWith(g));
	}

	@Test
	public void testMultipleMerge() {
		Fragment f = new Fragment("GGAACA");
		Fragment g = new Fragment("AACAGG");
		assertEquals(new Fragment("GGAACAGG"), f.mergedWith(g));
	}
}
