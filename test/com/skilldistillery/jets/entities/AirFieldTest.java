package com.skilldistillery.jets.entities;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AirFieldTest {
    
    private AirField airField;

    @BeforeEach
    void setUp() throws Exception {
        airField = new AirField();
    }

    @Test
    void testAddJet() {
        Jet jet = new BomberJet("Boeing", 500, 2000, 100_000_000);
        airField.addJet(jet);
        assertEquals(1, airField.getNumJets());
    }

    @Test
    void testGetNumJets() {
        assertEquals(0, airField.getNumJets());
        Jet jet = new PassengerJet("Boeing", 500, 2000, 100_000_000);
        airField.addJet(jet);
        assertEquals(1, airField.getNumJets());
    }

    @Test
    void testConstructorWithCollection() {
        Jet jet1 = new BomberJet("Boeing", 500, 2000, 100_000_000);
        Jet jet2 = new BomberJet("Airbus", 450, 1800, 90_000_000);
        AirField airFieldWithCollection = new AirField(Arrays.asList(jet1, jet2));
        assertEquals(2, airFieldWithCollection.getNumJets());
    }

}
