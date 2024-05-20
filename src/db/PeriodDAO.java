package db;

import java.sql.SQLException;

import model.Period;
import model.Shift;

public interface PeriodDAO {
	public void savePeriod(Shift shift, int scheduleId) throws SQLException;
}
