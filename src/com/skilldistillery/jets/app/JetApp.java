package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;
import com.skilldistillery.jets.entities.BomberJet;
import com.skilldistillery.jets.entities.CargoJet;
import com.skilldistillery.jets.entities.FighterJet;
import com.skilldistillery.jets.entities.Jet;

public class JetApp {
	private AirField airField;
	private Scanner input;
	
	public static void main(String[] args) {
		JetApp ja = new JetApp();
		ja.launch();

	}
	
	public JetApp() {}
	
	private void launch()  {

		try (BufferedReader reader = new BufferedReader(new FileReader("jets.csv"))) {
			String line;
			
			
			reader.readLine(); 
			while((line = reader.readLine()) != null) {
				airField.addJet(parseJet(line));
			}
			
		} catch (Exception e) {
			System.err.println("A fatal error has occured.\n" + e.getMessage());
		}
	}
	
	private Jet parseJet(String line) throws Exception {
		String[] jetData = line.replace(" ", "").split(",");
		Jet returnJet = null;
		try {
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
				throw new ParseException("Could not match Jet Type: " + type, 65);
			}
		} catch (Exception e) {
			throw new ParseException(e.getMessage(), 68);
		}
		
		
		return returnJet;
	}
	
	private void displayUserMenu() {
		String menu = "\n1. List fleet\n"
		+ "2. Fly all jets\n"
		+ "3. View fastest jet\n"
		+ "4. View jet with longest range\n"
		+ "5. Load all Cargo Jets\n"
		+ "6. Dogfight!\n"
		+ "7. Add a jet to Fleet\n"
		+ "8. Remove a jet from Fleet\n"
		+ "9. Quit";
		
		System.out.println(menu);
	}

}
