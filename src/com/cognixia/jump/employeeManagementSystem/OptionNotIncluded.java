package com.cognixia.jump.employeeManagementSystem;

public class OptionNotIncluded extends Exception {
	private static final long serialVersionUID = 1L;
	
	public OptionNotIncluded(int option) {
		super("Sorry, you chose " + option + " which does not exists. "
				+ "You must choose options 1-4 and enter in user information.");
	}
}
