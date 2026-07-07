package problem1;

import java.util.ArrayList;

public class Queue<T> {
	private final ArrayList<T> list = new ArrayList<>();

	@SafeVarargs
	public Queue(T... elements) {
		for (T element : elements) {
			enqueue(element);
		}
	}

	@SuppressWarnings("UnusedReturnValue")
	public int enqueue(T element) {
		list.add(element);
		return list.size();
	}

	public T dequeue() {
		return list.removeFirst();
	}

	public T peek() {
		return list.getFirst();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}
}
