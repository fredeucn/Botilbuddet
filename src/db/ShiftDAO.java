package db;

import model.Shift;

public interface ShiftDAO {
	public void saveShift (Shift shift, int periodId);
}
