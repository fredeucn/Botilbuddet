package db;

import java.sql.SQLException;

import model.Shift;

public interface ShiftDAO {
	public void saveShift (Shift shift, int periodId) throws SQLException;
}
