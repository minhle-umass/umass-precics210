/*
 * Copyright 2021 Marc Liberatore.
 */

package dnaseqassy;

import java.util.ArrayList;
import java.util.List;

public class Assembler {
	private final ArrayList<Fragment> fragments;
	private int left, right, max, result;

	/**
	 * Creates a new Assembler containing a list of fragments.
	 * <p>
	 * The list is copied into this assembler so that the original list will not be
	 * modified by the actions of this assembler.
	 *
	 * @param fragments The list of fragments to assemble
	 */
	public Assembler(List<Fragment> fragments) {
		this.fragments = new ArrayList<>(fragments);
	}

	/**
	 * Returns the current list of fragments this assembler contains.
	 *
	 * @return the current list of fragments
	 */
	public List<Fragment> getFragments() {
		return fragments;
	}

	/**
	 * Attempts to perform a single assembly, returning true iff an assembly was
	 * performed.
	 * <p>
	 * This method chooses the best assembly possible, that is, it merges the two
	 * fragments with the largest overlap, breaking ties between merged fragments by
	 * choosing the shorter merged fragment.
	 * <p>
	 * Merges must have an overlap of at least 1.
	 * <p>
	 * After merging two fragments into a new fragment, the new fragment is inserted
	 * into the list of fragments in this assembler, and the two original fragments
	 * are removed from the list.
	 *
	 * @return true iff an assembly was performed
	 */
	public boolean assembleOnce() {
		max = 0;
		result = -1;

		for (int i = 0; i < fragments.size(); ++i)
			for (int j = 0; j < fragments.size(); ++j) {
				if (i == j)
					continue;

				doAttempt(i, j);
				doAttempt(j, i);
			}

		if (max == 0)
			return false;

		var a = fragments.get(left);
		var b = fragments.get(right);
		fragments.add(a.mergedWith(b));
		fragments.remove(a);
		fragments.remove(b);
		return true;
	}

	private void doAttempt(int i, int j) {
		var attempt = fragments.get(i).calculateOverlap(fragments.get(j));
		var fragment = fragments.get(i).mergedWith(fragments.get(j)).length();

		if (attempt > max || attempt == max && (fragment < result && result < 0)) {
			left = i;
			right = j;
			max = attempt;
			result = fragment;
		}
	}

	/**
	 * Repeatedly assembles fragments until no more assembly can occur.
	 */
	@SuppressWarnings("all")
	public void assembleAll() {
		while (assembleOnce()) ;
	}
}
