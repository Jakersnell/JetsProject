package com.skilldistillery.jets.app;

import static com.skilldistillery.jets.app.PrintColor.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import com.skilldistillery.jets.entities.*;

public class JetApp {
	protected AirField airField;
	protected Scanner input;

	public static void main(String[] args) {
		JetApp ja = new JetApp();
		ja.launch();

	}
	

	protected JetApp() {
		airField = new AirField();
		input = new Scanner(System.in);
	}
	
	protected void afterOutput() {
		printBlue("press enter to continue.");
		input.nextLine();
		for(int i=0; i<1000; i++) {
			System.out.println();
		}
	}

	protected void launch() {
		boolean safeToLoad = false;
		String userFile;
		while (!safeToLoad) {
			printBlue("Type in the name of the file you would like to load.\n" + "Enter 1 for default load file.\n"
					+ "enter 0 to quit.\n");
			userFile = input.nextLine();
			if (userFile.equals("1")) {
				userFile = "default.csv";
			} else if (userFile.equals("0")) {
				break;
			}
			if (safeToLoad = readJetCSV(userFile)) {
				afterOutput();
				userMenuLoop();
			}
		} 
		printGreen("Exiting program.");
	}

	protected void displayUserMenu() {
		String menu = 
				"JetApp Options:\n" 
				+ "1. List fleet\n" 
				+ "2. Fly all jets\n" 
				+ "3. View fastest jet\n"
				+ "4. View jet with longest range\n" 
				+ "5. Load all Cargo Jets\n" 
				+ "6. Dogfight!\n"
				+ "7. Add a jet to Fleet\n" 
				+ "8. Remove a jet from Fleet\n" 
				+ "9. Fly a jet in Fleet\n"
				+ "10. Hire a pilot for a Jet\n" 
				+ "11. Save current state\n" 
				+ "0. Quit\n";
		printBlue(menu);
	}

	protected void userMenuLoop() {
		int userSelection;
		while (true) {
			try {
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
					break;
				case 4:
					airField.viewJetWithLongestRange();
					break;
				case 5:
					airField.loadAllCargoCarriers();
					break;
				case 6:
					airField.fightAllFighters();
					break;
				case 7:
					jetCreationMenu();
					break;
				case 8:
					airField.removeJet(getUserSelection("Type the number of the jet you would like to remove:",
							airField.getAllJets()));
					break;
				case 9:
					airField.flyJet(getUserSelection("Type the number of the jet you would like to fly",
							airField.getAllJets()));
					break;
				case 10:
					hirePilotMenu();
					break;
				case 11:
					saveStateMenu();
					break;
				case 0:
					return;
				default:
					printRed("Invalid Selection");
				}
				afterOutput();
			} catch (IllegalArgumentException e) {
				printRed("Invalid input.");
				afterOutput();
			}
		}

	}

	protected void jetCreationMenu() {
		String jetType = getUserSelection("Please choose a jet type",
				Arrays.asList("fighter", "bomber", "cargo", "passenger"));
		if (jetType == null)
			return;

		String jetModel = getUserInput("Please enter the model of your jet");
		if (jetModel == null)
			return;

		Double jetSpeed = getNumericInput("Please enter the mach speed of your jet", Double::parseDouble);
		if (jetSpeed == null)
			return;

		Integer jetRange = getNumericInput("Please enter the range of your jet in km", Integer::parseInt);
		if (jetRange == null)
			return;

		Long jetPrice = getNumericInput("Please enter the price of your jet", Long::parseLong);
		if (jetPrice == null)
			return;

		Jet userJet = createJet(jetType, jetModel, jetSpeed, jetRange, jetPrice);
		airField.addJet(userJet);
	}

	protected void hirePilotMenu() {
		Pilot pilot;
		ArrayList<Pilot> pilots = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			pilot = new Pilot();
			pilots.add(pilot);
		}
		Jet userSelectedJet = getUserSelection("Please select a jet to assign a pilot to.", airField.getAllJets());
		Pilot userSelectedPilot = getUserSelection("Enter the number of the pilot you would like to hire.", pilots);
		userSelectedJet.setPilot(userSelectedPilot);
	}

	protected <T> T getUserSelection(String message, List<T> options) {
		if (options.isEmpty()) {
			printRed("There are no items to select from!");
			return null;
		}
		while (true) {
			printBlue(message);
			printBlue("Enter 0 to exit this menu without performing an action.");
			for (int i = 0; i < options.size(); i++) {
				printBlue(String.format("\t(%d) %s", i + 1, options.get(i)));
			}
			String rawEntry = input.nextLine();
			if (isQuit(rawEntry))
				return null;
			try {
				int index = Integer.parseInt(rawEntry) - 1;
				if (index >= 0 && index < options.size()) {
					return options.get(index);
				}
			} catch (NumberFormatException e) {
				printRed("Invalid entry, Please only enter an Integer selection.");
				afterOutput();
			}
		}
	}

	protected String getUserInput(String message) {
		printBlue(message);
		String rawEntry = input.nextLine();
		return isQuit(rawEntry) ? null : rawEntry;
	}

	protected <T> T getNumericInput(String message, Function<String, T> parser) {
		while (true) {
			printBlue(message);
			String rawEntry = input.nextLine();
			if (isQuit(rawEntry))
				return null;

			try {
				return parser.apply(rawEntry);
			} catch (NumberFormatException e) {
				printRed("Invalid entry");
				afterOutput();
			}
		}
	}

	protected boolean isQuit(String input) {
		return input.equals("0") || input.toLowerCase().equals("quit");
	}

	protected Jet createJet(String type, String model, double speed, int range, long price) {
		switch (type) {
		case "fighter":
		case "fighterjet":
			return new FighterJet(model, speed, range, price);
		case "bomber":
		case "bomberjet":
			return new BomberJet(model, speed, range, price);
		case "cargo":
		case "cargojet":
			return new CargoJet(model, speed, range, price);
		case "passenger":
		case "passengerjet":
			return new PassengerJet(model, speed, range, price);
		default:
			return null;
		}
	}

	protected boolean readJetCSV(String filename) {
		try {
			List<String> lines = Files.readAllLines(Paths.get(filename));
			lines.remove(0);
			for (String line : lines) {
				airField.addJet(parseJet(line));
			}
			return true;

		} catch (FileNotFoundException e) {
			printRed("file " + filename + " not found.");
		} catch (NoSuchFileException e) {
			printRed("file " + filename + " not found.");
		} catch (IOException e) {
			printRed("A fatal IO error has occurred: " + e.getMessage());
			afterOutput();
		} catch (IllegalArgumentException e) {
			printRed("Error in parsing '" + filename + "', is the data correct?\n" + e.getMessage());
			afterOutput();
		}
		return false;
	}

	protected void saveStateMenu() {
		String filename;
		while (true) {
			filename = getUserInput("Please enter the name of the file you would like to save to.");
			if (filename == null) {
				return;
			} else if (Files.exists(Paths.get(filename))) {
				printRed("You cannot save to " + filename + " this file already exists.");
				afterOutput();
			} else {
				break;
			}
		}
		List<String> lines = airField.getStateAsCSV();
		try {
			Files.createFile(Paths.get(filename)); // Create the file
			Files.write(Paths.get(filename), lines); // Write to the file
		} catch (IOException e) {
			printRed("A fatal error occured.");
			afterOutput();
		}

	}

	protected Jet parseJet(String line) throws IllegalArgumentException {
		String[] jetData = parseCSVLine(line);
		Jet returnJet = null;

		String model = jetData[1];
		double speed = Double.parseDouble(jetData[2]);
		int range = Integer.parseInt(jetData[3]);
		long price = Long.parseLong(jetData[4]);

		String type = jetData[0].toLowerCase();

		returnJet = createJet(type, model, speed, range, price);
		if (returnJet == null) {
			throw new IllegalArgumentException("Could not match Jet Type: " + type);
		}
		return returnJet;
	}

	protected String[] parseCSVLine(String line) {
		String[] parseData = line.split(",");
		for (int i = 0; i < parseData.length; i++) {
			parseData[i] = parseData[i].trim();
		}
		return parseData;
	}

}
