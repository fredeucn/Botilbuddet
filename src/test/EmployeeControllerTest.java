package test;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import controller.EmployeeController;
import db.DataAccessException;



class EmployeeControllerTest {
	EmployeeController employeeController;
	
	@BeforeEach
	void setUp() throws Exception {
		 employeeController = new EmployeeController();
	}
	@Test
	void test() throws DataAccessException {
		assertEquals(employeeController.findEmployeeById(3).getName(), "Lea Litter");
	}

}
