package com.skilldistillery.jets.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.*;

class JetAppTest {
	private JetApp jetApp;

	@BeforeEach
	public void setUp() {
		jetApp = new JetApp();
	}

	@AfterEach
	public void tearDown() {
		jetApp = null;
	}
	
	@Test
	public void test_parseJet_throws_on_invalid_jet_type() {
		Assertions.assertThrows(RuntimeException.class, () -> {
			jetApp.parseJet("null, ac130, 300, 1000, 103000");
		});
	}

	@Test 
	public void test_parseJet_returns_jet_on_valid_input() {
		Assertions.assertNotNull(jetApp.parseJet("bomber, b52, 300, 1000, 103000"));
	}
	
	@Test 
	public void test_createJet_returns_jet_on_valid_input() {
		Assertions.assertNotNull(jetApp.createJet("bomber", "b52", 300, 1000, 103000));
	}
}
