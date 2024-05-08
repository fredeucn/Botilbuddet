package db;

import model.Shift;

public interface PeriodDAO {
	public int savePeriod(Shift currentPeriod, int scheduleId);
}
