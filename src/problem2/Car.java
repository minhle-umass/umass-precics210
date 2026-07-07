package problem2;

public class Car {
	private int id;
	private int powerSource;
	private float pricePerDay;

	public Car(int id, int powerSource, float pricePerDay) {
		this.id = id;
		this.powerSource = powerSource;
		this.pricePerDay = pricePerDay;
	}

	public int getId() {
		return id;
	}

	public int getPowerSource() {
		return powerSource;
	}

	public float getPricePerDay() {
		return pricePerDay;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPowerSource(int powerSource) {
		this.powerSource = powerSource;
	}

	public void setPricePerDay(float pricePerDay) {
		this.pricePerDay = pricePerDay;
	}
}
