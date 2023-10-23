package com.skilldistillery.jets.entities;

import static com.skilldistillery.jets.app.Util.randomFromArray;

public class BomberJet extends Jet implements CombatReady {

	private final String[] payloadTypes = { "MK-82 General Purpose", "GBU-12 Paveway II", "CBU-97 Sensor Fuzed Weapon",
			"BLU-109 Penetrator", "MOAB - Mother of All Bombs" };
	private final String[] flyingResponses = { "heading to target zone!", "deploying countermeasures!",
			"maintaining stealth profile!", "cruising at high altitude!", "evading enemy radar!" };
	private final String[] bombingResponses = { "releasing payload!", "bombs away!", "target locked, dropping!",
			"precision strike initiated!", "carpet bombing in progress!" };

	public BomberJet(String model, double maxMachSpeed, int rangeInKm, long price) {
		super(model, maxMachSpeed, rangeInKm, price);
	}

	@Override
	public void fight() {
		printModelAndMessage("Bomber jet model " + getModel() + " payload " + randomFromArray(payloadTypes) + ", "
				+ randomFromArray(bombingResponses));

	}

	@Override
	void fly() {
		printModelAndMessage("Bomber model " + getModel() + " " + randomFromArray(flyingResponses));

	}

}
