package model;

public class Patient {
	private String name;
	private String email;
	private String phoneNumber;
	private String patientNote;
	private int patientId;
	
	public Patient(String name, String email, String phoneNumber, String patientNote, int patientId) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.patientNote = patientNote;
		this.patientId = patientId;
	}
	
	
	
	@Override
	public String toString() {
		return "Patient [name=" + name + ", email=" + email + ", phoneNumber=" + phoneNumber + ", patientNote="
				+ patientNote + ", patientId=" + patientId + "]";
	}



	public String getEmail() {
		return email;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPatientId() {
		return patientId;
	}
	
	public String getPatientNote() {
		return patientNote;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	
	public void setPatientNote(String patientNote) {
		this.patientNote = patientNote;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
