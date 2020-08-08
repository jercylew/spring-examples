package com.javatpoint;  
/**
 * Demo Model
 */
public class Emp1000 {
	private int id;
	private String firstName;
	private String lastName;
	
	public Emp1000(int id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Emp1000() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	
	public String toString() {
		return String.format("Employee{id:%d, name:%s %s}", this.id,
				this.firstName, this.lastName);
	}
}  