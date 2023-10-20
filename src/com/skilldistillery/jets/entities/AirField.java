package com.skilldistillery.jets.entities;

import java.util.ArrayList;

public class AirField {
	private ArrayList<Jet> fleet;
	
	public AirField() {}
	public AirField(Jet initJet) {
		this();
		fleet.add(initJet);
	}
	
	public void addJet(Jet jet) {
		fleet.add(jet);
	}
	
	// will need to find a way to collect all the jets at 
	// the bottom of the array list
	// if the list looks like this
	// [some, some, null, some, some]
	// convert it to
	// [some, some, some, some, null]
}
