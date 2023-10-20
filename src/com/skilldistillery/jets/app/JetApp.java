package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.skilldistillery.jets.entities.AirField;

public class JetApp {
	private AirField airField;
	private Scanner input;
	
	public static void main(String[] args) {
		JetApp ja = new JetApp();
		ja.launch();

	}
	
	public JetApp() {}
	
	private void launch()  {
		// populate jets with jets from list
		try (BufferedReader reader = new BufferedReader(new FileReader("jets.csv"))) {
			String line;
			String[] jetData;
			
			while((line = reader.readLine()) != null) {
				jetData = line.split(line);
			}
			
		} catch (IOException e) {
			System.err.println("A fatal error has occured.");
		}
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
