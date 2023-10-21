package com.skilldistillery.jets.entities;

public class JetImpl extends Jet {

	

	public JetImpl(String model, double maxMachSpeed, int rangeInKm, long price, Pilot pilot) {
		super(model, maxMachSpeed, rangeInKm, price, pilot);
		// TODO Auto-generated constructor stub
	}

	public JetImpl(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	void fly() {
		// TODO Auto-generated method stub
	}

	@Override
	void displaySelf() {
		// TODO Auto-generated method stub
		
	}

}
