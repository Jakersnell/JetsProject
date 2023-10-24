package com.skilldistillery.jets.entities;

public class Pilot extends Entity {
	private final String[] firstNames = { "John", "Katie", "Shufey", "Joe", "Michael", "Linda", "Peter", "Alice",
			"Chris", "Eve" };
	private final String[] lastNames = { "ValJean", "Pilotwoman", "loofen", "Pilotperson", "Skydriver", "Cloudsailor",
			"Airlifter", "Jetrunner", "Wingflyer", "Propelmaster" };

	private String firstName;
	private String lastName;
	private int age;

	public Pilot(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Pilot() {
		firstName = randomFromArray(firstNames);
		lastName = randomFromArray(lastNames);
		age = 25 + (int) (Math.random() * 10);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Pilot [ firstName: " + firstName + ", lastName: " + lastName + ", age: " + age + " ]";
	}

	public String getAsCSVLine() {
		return "pilot, " + firstName + ", " + lastName + ", " + age;
	}
}
