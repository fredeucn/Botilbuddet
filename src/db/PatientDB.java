package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Patient;

public class PatientDB implements PatientDAO {
	
	// remember " " spaces when splitting up the Query with +
	private static final String findPatientQuery = "SELECT patient.id, phone_number, patient.name, patient.email, patient_note FROM patient "
			+ "WHERE patient.id = ?";
	private PreparedStatement findPatient;

	public PatientDB() throws DataAccessException {
		try {
			Connection connection = ConnectDB.getInstance().getConnection();
			findPatient = connection.prepareStatement(findPatientQuery);
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not prepare statement");
		}
	}
	
	@Override
	public Patient findPatientById(int id) throws DataAccessException {
		try {
			findPatient.setInt(1, id);
			ResultSet resultSet = findPatient.executeQuery();
			Patient patient = null;
			if (resultSet.next()) {
				patient = buildObject(resultSet);
			}
			return patient;
		} catch (SQLException e) {
			throw new DataAccessException(e, "Could not find patient by id = " + id);
		}
	}
	
	private Patient buildObject(ResultSet resultSet) throws SQLException {
		Patient patient = new Patient(
				resultSet.getString("name"),
				resultSet.getString("email"),
				resultSet.getString("phone_number"),
				resultSet.getString("patient_note"),
				resultSet.getInt("id"));
		return patient;
	}
}