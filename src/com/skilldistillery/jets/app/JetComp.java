package com.skilldistillery.jets.app;

import java.util.Comparator;

import com.skilldistillery.jets.entities.Jet;

public final class JetComp {
	public static final SpeedComparator speedComparator = new SpeedComparator();
	public static final RangeComparator rangeComparator = new RangeComparator();

	private static final class SpeedComparator implements Comparator<Jet> {
		@Override
		public int compare(Jet jet1, Jet jet2) {
			return Double.compare(jet1.getMaxMachSpeed(), jet2.getMaxMachSpeed());
		}
	}
	
	private static final class RangeComparator implements Comparator<Jet> {
		@Override
		public int compare(Jet jet1, Jet jet2) {
			return Double.compare(jet1.getRangeInKm(), jet2.getRangeInKm());
		}
	}
}
