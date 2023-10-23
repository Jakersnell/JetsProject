package com.skilldistillery.jets.entities;

import static com.skilldistillery.jets.app.Util.randomFromArray;

public class CargoJet extends Jet implements CargoCarrier {
	private final String[] loadCargoResponses = { "loading up!", "getting loaded!", "loading!" };
	private final String[] flyingResponses = { "airborne and heading to destination!", "soaring through the skies!",
			"taking off with cargo!", "flying high and fast!" };

	public CargoJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}

	@Override
	public void loadCargo() {
		printModelAndMessage(getModel() + " " + randomFromArray(loadCargoResponses));
	}

	@Override
	void fly() {
		printModelAndMessage("Cargo jet model " + getModel() + " " + randomFromArray(flyingResponses));
	}

}
