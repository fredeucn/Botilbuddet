package model;

public class Employee {
	private String name;
	private String employeeType;
	private String email;
	private String phoneNumber;
	private String address;
	private float salary;
	private int employeeId;
	
	public Employee(String name, String employeeType, String email, String phoneNumber, String address, float salary, int employeeId) {
		this.name = name;
		this.employeeType = employeeType;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.salary = salary;
		this.employeeId = employeeId;
	}
	
	@Override
	public String toString() {
		return "Employee [name=" + name + ", employeeType=" + employeeType + ", email=" + email + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", salary=" + salary + ", employeeId=" + employeeId + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
