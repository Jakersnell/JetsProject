package com.skilldistillery.jets.entities;

public class CargoJet extends Jet implements CargoCarrier {

	public CargoJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}
	@Override
	public void loadCargo() {
		// TODO Auto-generated method stub
		
	}
	@Override
	void fly() {
		// TODO Auto-generated method stub
		
	}
	
}
