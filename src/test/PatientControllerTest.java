package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.PatientController;
import db.DataAccessException;

class PatientControllerTest {
	PatientController patientController;
	
	@BeforeEach
	void setUp() throws Exception {
		 patientController = new PatientController();
	}
	
	@Test
	void test() throws DataAccessException {
		assertEquals(patientController.findPatientById(2).getName(), "Sin Zypat Ent");
	}
	
}
