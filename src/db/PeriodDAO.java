package db;

import model.Period;
import model.Shift;

public interface PeriodDAO {
	public int savePeriod(Period currentPeriod, int scheduleId);
}
