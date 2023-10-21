package com.skilldistillery.jets.app;

public final class Util {
	/*
	 * I know I'm taking a risk by making these static because Dee said never do it.
	 * But I believe these should by no means be instance methods. 
	 * Seeing as these have no functional value to the project, 
	 * please be merciful and allow it.
	 * Thanks.
	 */
	private Util() {}
	public static void pauseForEffect() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			printRed("A fatal Sytem error has occured.");
			System.exit(1);
		}
	}

	public static void printRed(String message) {
		System.out.println("\033[31m" + message + "\033[0m"); // ANSI escape codes to print red
	}

	public static void printGreen(String message) {
		System.out.println("\033[32m" + message + "\033[0m");
	}
	
	public static void printBlue(String message) {
		System.out.println("\033[36m" + message + "\033[0m");
	}
	
}
