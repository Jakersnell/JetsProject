package com.skilldistillery.jets.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import com.skilldistillery.jets.app.JetComp;

public class AirField {
	private ArrayList<Jet> fleet;

	public AirField() {
		fleet = new ArrayList<Jet>();
	}
	
	public AirField(Collection<Jet> jets) {
		this();
		fleet.addAll(jets);
	}

	public void addJet(Jet jet) {
		fleet.add(jet);
	}
	
	public void removeJet(int index) {
		fleet.remove(index);
	}

	public void displayAll() {
		for (int i=0; i<fleet.size();i++) {
			System.out.printf("jet #%d --- %s%n", i+1, fleet.get(i));
		}
	}

	public void flyAll() {
		for (Jet jet : fleet) {
			jet.fly();
		}
	}

	public void viewFastestJet() {
		System.out.println(Collections.max(fleet, JetComp.speedComparator));
	}
	
	public void viewJetWithLongestRange() {
		System.out.println(Collections.max(fleet, JetComp.rangeComparator));
	}
	
	public void loadAllCargoCarriers() {
		for (Jet jet : fleet) {
			if (jet instanceof CargoCarrier && jet != null) {
				((CargoCarrier)jet).loadCargo();
			}
		}
	}
	
	public void fightAllFighters() {
		for (Jet jet : fleet) {
			if (jet instanceof CombatReady && jet != null) {
				((CombatReady)jet).fight();
			}
		}
	}

	// will need to find a way to collect all the jets at
	// the bottom of the array list
	// if the list looks like this
	// [some, some, null, some, some]
	// convert it to
	// [some, some, some, some, null]
}
