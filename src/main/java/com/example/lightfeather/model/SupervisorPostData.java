package com.example.lightfeather.model;

public class SupervisorPostData {

	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private Supervisor supervisor;
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
	public Supervisor getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(Supervisor sup) {
		supervisor = sup;
	}
	@Override
	public String toString() {
		return "SupervisorPostData [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", Supervisor=" + supervisor + "]";
	}
	
	
	
}
