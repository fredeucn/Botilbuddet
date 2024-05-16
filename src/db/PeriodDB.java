package db;

import model.Period;

public class PeriodDB implements PeriodDAO{
	ShiftDB shiftDB;
	
	@Override
	public int savePeriod(Period currentPeriod, int scheduleId) {
		// TODO Auto-generated method stub
		shiftDB.saveShift(currentPeriod, scheduleId);
		return 0;
	}

}
