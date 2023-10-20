package com.skilldistillery.jets.entities;

public class FighterJet extends Jet implements CombatReady {

	public FighterJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}

	@Override
	public void fight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void fly() {
		// TODO Auto-generated method stub
		
	}

}
