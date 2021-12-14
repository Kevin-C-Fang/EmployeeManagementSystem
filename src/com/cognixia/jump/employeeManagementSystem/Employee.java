package com.cognixia.jump.employeeManagementSystem;

import java.time.LocalDate;

public class Employee {
	private String firstName;
	private String lastName;
	private static int idCounter = 1;
	private int employeeId;
	LocalDate employmentDate;
	private long salary;
	private String department;
	
	public Employee() {
		super();
	}
	
	public Employee(String firstName, String lastName, int employeeId, LocalDate employmentDate, long salary, String department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.employeeId = idCounter++;
		this.employmentDate = employmentDate;
		this.salary = salary;
		this.department = department;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getSalary() {
		return salary;
	}

	public void setSalary(long salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public LocalDate getEmploymentDate() {
		return employmentDate;
	}

	@Override
	public String toString() {
		return "Employee [firstName=" + firstName + ", lastName=" + lastName + ", employeeId=" + employeeId
				+ ", employmentDate=" + employmentDate + ", salary=" + salary + ", department=" + department + "]";
	}
}
