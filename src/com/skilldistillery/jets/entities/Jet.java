package com.skilldistillery.jets.entities;

public abstract class Jet {
	private String model;
	private double maxMachSpeed;
	private int rangeInKm;
	private long price;
	
	public Jet(String model, double maxMachSpeed, int rangeInKm, long price) {
		this.model = model;
		this.maxMachSpeed = maxMachSpeed;
		this.rangeInKm = rangeInKm;
		this.price = price;
	}
	
	abstract void fly();

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
}
