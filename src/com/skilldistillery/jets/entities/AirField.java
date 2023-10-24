package com.skilldistillery.jets.entities;

import static com.skilldistillery.jets.app.PrintColor.printGreen;
import static com.skilldistillery.jets.app.PrintColor.printRed;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;


public class AirField {
	private final SpeedComparator speedComparator = new SpeedComparator();
	private final RangeComparator rangeComparator = new RangeComparator();

	private final class SpeedComparator implements Comparator<Jet> {
		@Override
		public int compare(Jet jet1, Jet jet2) {
			return Double.compare(jet1.getMaxMachSpeed(), jet2.getMaxMachSpeed());
		}
	}

	private final class RangeComparator implements Comparator<Jet> {
		@Override
		public int compare(Jet jet1, Jet jet2) {
			return Double.compare(jet1.getRangeInKm(), jet2.getRangeInKm());
		}
	}

	private ArrayList<Jet> fleet;

	public AirField() {
		fleet = new ArrayList<Jet>();
	}

	public void removeJet(Jet jet) {
		fleet.remove(jet);
	}

	public AirField(Collection<Jet> jets) {
		this();
		fleet.addAll(jets);
	}

	public List<Jet> getAllJets() {
		return fleet;
	}

	public void assignPilotToJet(int indexOfJet, Pilot pilot) {
		fleet.get(indexOfJet).setPilot(pilot);
		;
	}

	public boolean isEmpty() {
		return fleet.isEmpty();
	}

	public void addJet(Jet jet) {
		fleet.add(jet);
	}

	public int getNumJets() {
		return fleet.size();
	}

	public void flyJet(Jet jet) {
		if (jet != null) {
			jet.fly();
		}
	}

	public void displayAll() {
		callOnAll((jet) -> {
			System.out.println(jet);
		});
	}

	public void flyAll() {
		callOnAll(Jet::fly);
	}

	public void viewFastestJet() {
		System.out.println("Fastest jet:");
		printGreen("\t" + Collections.max(fleet, speedComparator).getDisplayAsSelf());
	}

	public void viewJetWithLongestRange() {
		System.out.println("Jet with longest range:");
		printGreen("\t" + Collections.max(fleet, rangeComparator).getDisplayAsSelf());
	}

	public void loadAllCargoCarriers() {
		callOnAllOfType(CargoJet::loadCargo, CargoJet.class);
	}

	public void fightAllFighters() {
		callOnAllOfType(FighterJet::fight, FighterJet.class);
	}

	private <T extends Jet> void callOnAll(Consumer<Jet> method) {
		callOnAllOfType(method, Jet.class);
	}

	private <T extends Jet> void callOnAllOfType(Consumer<T> method, Class<T> type) {
		if (isEmpty()) {
			printRed("The airfield is empty!");
			return;
		}

		for (Jet jet : fleet) {
			if (type.isInstance(jet)) {
				method.accept(type.cast(jet));
			}
		}
	}

	public List<String> getStateAsCSV() {
		List<String> representations = new ArrayList<>();
		for (Jet jet : fleet) {
			representations.add(jet.getAsCSVLine());
		}
		return representations;
	}

}
