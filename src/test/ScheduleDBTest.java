package test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import model.Period;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import db.ScheduleDB;
import model.Employee;
import model.Schedule;



class ScheduleDBTest {
	ScheduleDB scheduleDB;
	Schedule testSchedule;
	Period testPeriod;
	Employee testEmployee;
	
	@BeforeEach
	void setUp() throws Exception {
		 scheduleDB = new ScheduleDB();
		 LocalDateTime testStartDate = LocalDate.of(2024, 9, 18).atStartOfDay();
		 LocalDateTime testEndDate = LocalDate.of(2024, 9, 18).atTime(0, 0, 0);
		 
		 testEmployee = new Employee("testFyr", "leder", "test@her.dk", "39393939", "testvej 39", 0, 66);
		 testPeriod = new Period(testStartDate, testEndDate, testEmployee);
		 
				 
		 testSchedule = new Schedule("Test schedule", "Schedule for testing");
		 testSchedule.setDate(LocalDate.now());
		 
		 testSchedule.addPeriod(testPeriod);
	}
	
	@Test
	void test1() {
		assertTrue(scheduleDB != null);
		assertDoesNotThrow(()-> scheduleDB.saveSchedule(testSchedule));
	}
	
	@Test
	void test2() {
		assertDoesNotThrow(()-> testSchedule.addPeriod(testPeriod));
	}

}
