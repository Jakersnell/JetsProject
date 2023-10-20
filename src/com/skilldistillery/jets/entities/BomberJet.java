package com.skilldistillery.jets.entities;

public class BomberJet extends Jet implements CombatReady {

	public BomberJet(String model, double maxMachSpeed, int rangeInKm, long price) {
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
