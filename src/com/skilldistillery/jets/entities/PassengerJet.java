package com.skilldistillery.jets.entities;
import static com.skilldistillery.jets.app.Util.randomFromArray;

public class PassengerJet extends Jet {
	private int passengers = (int)(Math.random() * 50 + 10);
	private final String[] destinations = {"Tokyo", "Seoul", "Sydney", "Toronto", "New York"};
	
	public PassengerJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}

	@Override
	void fly() {
		printModelAndMessage("This model " + getModel() + " passenger jet is flying its " + passengers + " passengers to " + randomFromArray(destinations) + "!");
	}
}
