package problem3;

import org.junit.jupiter.api.Test;
import problem1.Queue;
import problem2.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

	@Test
	void addCarAndProcessRequests() {
		var fleet = new CarFleet();
		assertTrue(fleet.addCar(new Car(1, 1, 0)));
		assertTrue(fleet.addCar(new Car(2, 1, 1)));
		assertTrue(fleet.addCar(new Car(3, 2, 2)));
		assertTrue(fleet.addCar(new Car(4, 3, 3)));
		assertFalse(fleet.addCar(new Car(-1, -1, -1.0f)));

		var cars = fleet.processRequests(new Queue<>(1, 2, 3, 2, 1));
		var expected = new Queue<>(1, 3, 4, 0, 2);

		while (!expected.isEmpty()) {
			assertEquals(expected.dequeue(), cars.removeFirst().getId());
		}
	}
}