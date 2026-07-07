package problem1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

	@Test
	void constructor() {
		var queue = new Queue<>(1, 2, 3);
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
		assertEquals(3, queue.dequeue());
	}

	@Test
	void enqueue() {
		var queue = new Queue<Integer>();
		assertEquals(1, queue.enqueue(1));
		assertEquals(1, queue.peek());
	}

	@Test
	void dequeue() {
		var queue = new Queue<Integer>();
		queue.enqueue(1);
		queue.enqueue(2);
		assertEquals(1, queue.dequeue());
		assertEquals(2, queue.dequeue());
	}

	@Test
	void peek() {
		var queue = new Queue<Integer>();
		queue.enqueue(1);
		assertEquals(1, queue.peek());
		queue.enqueue(2);
		assertEquals(1, queue.peek());
	}

	@Test
	void isEmpty() {
		var queue = new Queue<Integer>();
		assertTrue(queue.isEmpty());
		queue.enqueue(1);
		assertFalse(queue.isEmpty());
	}
}