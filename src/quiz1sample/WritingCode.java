package quiz1sample;

import java.util.List;

public class WritingCode {
	public static int sum(int[] a) {
		int sum = 0;
		for (int j : a) {
			sum += j;
		}
		return sum;
	}

	public static int sum(List<Integer> l) {
		int sum = 0;
		for (Integer i : l) {
			sum += i;
		}
		return sum;
	}

	public static int mean(int[] a) {
		return a.length == 0 ? 0 : sum(a) / a.length;
	}

	public static int mean(List<Integer> l) {
		return l.isEmpty() ? 0 : sum(l) / l.size();
	}

	public static int min(int[] a) {
		if (a.length == 0)
			return 0;

		int min = a[0];
		for (int j : a)
			if (j < min)
				min = j;
		return min;
	}

	public static int min(List<Integer> l) {
		if (l.isEmpty())
			return 0;

		int min = l.getFirst();
		for (int j : l)
			if (j < min)
				min = j;
		return min;
	}

	public static int max(int[] a) {
		if (a.length == 0)
			return 0;

		int max = a[0];
		for (int j : a)
			if (j > max)
				max = j;
		return max;
	}

	public static int max(List<Integer> l) {
		if (l.isEmpty())
			return 0;

		int max = l.getFirst();
		for (int j : l)
			if (j > max)
				max = j;
		return max;
	}

	public static boolean allEven(int[] a) {
		for (int j : a)
			if (j % 2 != 0)
				return false;
		return true;
	}

	public static boolean allEven(List<Integer> l) {
		for (int j : l)
			if (j % 2 != 0)
				return false;
		return true;
	}

	public static boolean someEven(int[] a) {
		if (a.length == 0)
			return true;

		for (int j : a)
			if (j % 2 == 0)
				return true;
		return false;
	}

	public static boolean someEven(List<Integer> l) {
		if (l.isEmpty())
			return true;

		for (int j : l)
			if (j % 2 == 0)
				return true;
		return false;
	}

	public static boolean isSorted(int[] a) {
		if (a.length <= 1)
			return true;

		for (int i = 1; i < a.length; ++i)
			if (a[i - 1] > a[i])
				return false;
		return true;
	}

	public static boolean isSorted(List<Integer> l) {
		if (l.size() <= 1)
			return true;

		for (int i = 1; i < l.size(); ++i)
			if (l.get(i - 1) > l.get(i))
				return false;
		return true;
	}

	public static boolean isDoubling(int[] a, int n) {
		if (a.length <= 1)
			return true;

		for (int i = 1; i < a.length; ++i)
			if (a[i - 1] * n != a[i])
				return false;
		return true;
	}

	public static boolean isDoubling(List<Integer> l, int n) {
		if (l.size() <= 1)
			return true;

		for (int i = 1; i < l.size(); ++i)
			if (l.get(i - 1) * n != l.get(i))
				return false;
		return true;
	}

	public static boolean isPalindrome(int[] a) {
		for (int i = 0; i < (a.length + 1) / 2; ++i)
			if (a[i] != a[a.length - i - 1])
				return false;
		return true;
	}

	public static boolean isPalindrome(List<Integer> l) {
		for (int i = 0; i < (l.size() + 1) / 2; ++i)
			if (!l.get(i).equals(l.get(l.size() - i - 1)))
				return false;
		return true;
	}
}
