package problem2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CarTest {

	@Test
	void getId() {
		var car = new Car(123, 0, 0.0f);
		assertEquals(123, car.getId());
	}

	@Test
	void getPowerSource() {
		var car = new Car(0, 123, 0.0f);
		assertEquals(123, car.getPowerSource());
	}

	@Test
	void getPricePerDay() {
		var car = new Car(0, 0, 123.0f);
		assertEquals(123.0f, car.getPricePerDay());
	}

	@Test
	void setId() {
		var car = new Car(0, 0, 0.0f);
		car.setId(123);
		assertEquals(123, car.getId());
	}

	@Test
	void setPowerSource() {
		var car = new Car(0, 0, 0.0f);
		car.setPowerSource(123);
		assertEquals(123, car.getPowerSource());
	}

	@Test
	void setPricePerDay() {
		var car = new Car(0, 0, 0.0f);
		car.setPricePerDay(123.0f);
		assertEquals(123.0f, car.getPricePerDay());
	}
}