package problem3;

import problem1.Queue;
import problem2.Car;

import java.util.ArrayList;

public class CarFleet {
	final Queue<Car> gasolineCars = new Queue<>();
	final Queue<Car> hybridCars = new Queue<>();
	final Queue<Car> electricCars = new Queue<>();

	public boolean addCar(Car car) {
		switch (car.getPowerSource()) {
			case 1:
				gasolineCars.enqueue(car);
				break;
			case 2:
				hybridCars.enqueue(car);
				break;
			case 3:
				electricCars.enqueue(car);
				break;
			default:
				return false;
		}
		return true;
	}

	public ArrayList<Car> processRequests(Queue<Integer> requests) {
		ArrayList<Car> processedCars = new ArrayList<>();

		while (!requests.isEmpty()) {
			int request = requests.dequeue();
			Queue<Car> queue;

			switch (request) {
				case 1:
					queue = gasolineCars;
					break;
				case 2:
					queue = hybridCars;
					break;
				case 3:
					queue = electricCars;
					break;
				default:
					continue;
			}

			if (!queue.isEmpty()) {
				processedCars.add(queue.dequeue());
			} else {
				processedCars.add(new Car(0, request, 0.0f));
			}
		}

		return processedCars;
	}
}
