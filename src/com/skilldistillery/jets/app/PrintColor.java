package com.skilldistillery.jets.app;

public final class PrintColor {
	/*
	 * I know I'm taking a risk by making these static because Dee said never do it.
	 * But I believe these should by no means be instance methods. Seeing as these
	 * are not core to the functionality of the project, and are only utility
	 * functions for un-required elements, please be merciful and allow it... Thanks.
	 */
	private PrintColor() {
	}

	public static void printRed(String message) {
		System.out.println("\033[31m" + message + "\033[0m");
	}

	public static void printGreen(String message) {
		System.out.println("\033[32m" + message + "\033[0m");
	}

	public static void printBlue(String message) {
		System.out.println("\033[36m" + message + "\033[0m");
	}

}
