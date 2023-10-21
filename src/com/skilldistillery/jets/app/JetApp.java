package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import com.skilldistillery.jets.entities.*;

public class JetApp {
	private AirField airField;
	private Scanner input;

	public static void main(String[] args) {
		JetApp ja = new JetApp();
		ja.launch();

	}

	private JetApp() {
		airField = new AirField();
		input = new Scanner(System.in);
	}

	private void launch() {
		if (readJetCSV()) {
			int userSelection;
			boolean running = true;
			while (running) {
				displayUserMenu();
				userSelection = Integer.parseInt(input.nextLine());

				switch (userSelection) {
				case 1:
					airField.displayAll();
					break;
				case 2:
					airField.flyAll();
					break;
				case 3:
					airField.viewFastestJet();
				case 4:
				case 5:
				case 6:
				case 7:
				case 8:
				case 9:
					System.out.println();
				default:
					Util.printRed("Invalid Selection");
				}

			}
		}
	}

	private boolean readJetCSV() {
		boolean success = true;
		try (BufferedReader reader = new BufferedReader(new FileReader("jets.csv"))) {
			String line;

			reader.readLine();
			while ((line = reader.readLine()) != null) {
				airField.addJet(parseJet(line));
			}

		} catch (IOException e) {
			Util.printRed("A fatal IO error has occured.");
			success = false;
		} catch (IllegalArgumentException e) {
			Util.printRed("Error in parsing 'jets.csv', is the data correct?");
			success = false;
		}
		return success;
	}

	private Jet parseJet(String line) throws IllegalArgumentException {
		String[] jetData = line.replace(" ", "").split(",");
		Jet returnJet = null;

		String model = jetData[1];
		double speed = Double.parseDouble(jetData[2]);
		int range = Integer.parseInt(jetData[3]);
		long price = Long.parseLong(jetData[4]);

		String type = jetData[0];

		switch (type) {
		case "bomber":
			returnJet = new BomberJet(model, speed, range, price);
			break;
		case "fighter":
			returnJet = new FighterJet(model, speed, range, price);
			break;
		case "cargo":
			returnJet = new CargoJet(model, speed, range, price);
			break;
		default:
			throw new IllegalArgumentException("Could not match Jet Type: " + type);
		}

		return returnJet;
	}

	private void displayUserMenu() {
		String menu = "1. List fleet\n"
				+ "2. Fly all jets\n"
				+ "3. View fastest jet\n"
				+ "4. View jet with longest range\n"
				+ "5. Load all Cargo Jets\n"
				+ "6. Dogfight!\n"
				+ "7. Add a jet to Fleet\n"
				+ "8. Remove a jet from Fleet\n"
				+ "9. Quit";
		Util.printBlue(menu);
	}

}
