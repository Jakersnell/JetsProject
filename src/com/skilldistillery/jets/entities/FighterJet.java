package com.skilldistillery.jets.entities;
public class FighterJet extends Jet implements CombatReady {
	private final String[] fighterJetGuns = {"20mm Cannon", "30mm Gatling Gun", "AIM-9 Sidewinder", "M61 Vulcan", "AIM-120 AMRAAM"};
	private final String[] flyingResponses = {"breaking the sound barrier!", "engaging afterburners!", "performing a barrel roll!", "ascending to combat altitude!", "patrolling the skies!"};

	public FighterJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}

	@Override
	public void fight() {
		printModelAndMessage("This model " + getModel() + " FighterJet is fighting with its " + randomFromArray(fighterJetGuns));
	}

	@Override
	void fly() {
		printModelAndMessage("This " + getModel() + " fighter is " + randomFromArray(flyingResponses));
		
	}



}
