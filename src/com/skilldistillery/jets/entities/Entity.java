package com.skilldistillery.jets.entities;

public abstract class Entity {
	protected <T> T randomFromArray(T[] items) {
		return items[(int) (Math.random() * items.length)];
	}
}
