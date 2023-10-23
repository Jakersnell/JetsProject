package com.skilldistillery.jets.entities;
import java.util.Objects;
import static com.skilldistillery.jets.app.Util.printGreen;
public abstract class Jet {
	private String model;
	private double maxMachSpeed;
	private int rangeInKm;
	private long price;
	private Pilot pilot;

	public Jet(String model, double maxMachSpeed, int rangeInKm, long price) {
		this.model = model;
		this.maxMachSpeed = maxMachSpeed;
		this.rangeInKm = rangeInKm;
		this.price = price;
		assignRandomPilot();
	}

	abstract void fly();

	public void assignRandomPilot() {
		pilot = new Pilot();
	}

	public String getDisplayAsSelf() {
		String display;
		if (this instanceof CargoJet) {
			display = ((CargoJet) this).toString();
		}
		if (this instanceof FighterJet) {
			display = ((FighterJet) this).toString();
		} else if (this instanceof PassengerJet) {
			display = ((PassengerJet) this).toString();
		} else if (this instanceof BomberJet) {
			display = ((BomberJet) this).toString();
		} else {
			display = toString();
		}
		return display;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getMaxMachSpeed() {
		return maxMachSpeed;
	}

	public void setMaxMachSpeed(double maxMachSpeed) {
		this.maxMachSpeed = maxMachSpeed;
	}

	public int getRangeInKm() {
		return rangeInKm;
	}

	public void setRangeInKm(int rangeInKm) {
		this.rangeInKm = rangeInKm;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(maxMachSpeed, model, price, rangeInKm);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jet other = (Jet) obj;
		return Double.doubleToLongBits(maxMachSpeed) == Double.doubleToLongBits(other.maxMachSpeed)
				&& Objects.equals(model, other.model) && price == other.price && rangeInKm == other.rangeInKm;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [ model: " + model + ", max mach speed: " + maxMachSpeed + ", max range in km: " + rangeInKm
				+ ", price: " + price + " ]  |  " + pilot;
	}
	
	protected void printModelAndMessage(String message) {
		System.out.println(toString());
		printGreen("\t" + message + "\n");
	}
	
	public String getAsCSVLine() {
		// TODO Auto-generated method stub
		return getClass().getSimpleName() + ", " + model + ", " + maxMachSpeed + ", " + rangeInKm
		+ ", " + price + ", " + pilot.getAsCSVLine();
	}

}
