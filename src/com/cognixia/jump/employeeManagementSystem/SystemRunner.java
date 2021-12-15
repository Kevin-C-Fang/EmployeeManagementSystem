package com.cognixia.jump.employeeManagementSystem;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SystemRunner {

	public static void main(String[] args) {
		int option = 0;
		List<Employee> employees = new ArrayList<Employee>();
		Scanner scan = new Scanner(System.in);
		while(option != 5) {
			try {
				
					menu();
				
					option = userOption(scan);
					operations(option, employees, scan);
				
			} catch (InputMismatchException e) {
				System.out.println("You did not enter in an Interger");
			} catch (OptionNotIncluded e) {
				System.out.println(e.getMessage());
			} catch (DateTimeParseException e) {
				System.out.println("Could not parse through employement date input");;
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Employee not found");
			} finally {
				
			}
		}
		scan.close();

	}
	
	public static void operations(int operation, List<Employee> employees, Scanner scan) throws InputMismatchException, DateTimeParseException  {
		Employee employee;
		switch(operation) {
			case 1:
				employee = addNewEmployees(employees, scan);
				System.out.println("Sucesss: Added employee: \n" + employee);
				break;
			case 2:
				employee = updateEmployees(employees, scan);
				System.out.println("Sucesss: Updated employee: \n" + employee);
				break;
			case 3:
				employee = removeEmployees(employees, scan);
				System.out.println("Sucesss: Removed employee: \n" + employee);
				break;
			case 4:
				listEmployees(employees, scan);
				break;
		}
	}
	
	public static int userOption(Scanner scan) throws OptionNotIncluded, InputMismatchException {
		int userInput = 0;
		
		userInput = scan.nextInt();
		if(userInput < 1 || userInput > 5) {
			throw new OptionNotIncluded(userInput);
		} 
		return userInput;
	}
	
	public static Employee addNewEmployees(List<Employee> employees, Scanner scan) throws InputMismatchException, DateTimeParseException {
		String firstName;
		String lastName;
		LocalDate employmentDate;
		long salary;
		String department;
		
		System.out.println("Enter in first name: ");
		firstName = scan.next();
		System.out.println("Enter in last name: ");
		lastName = scan.next();
		System.out.println("Enter in employement date in format yyyy-mm-dd: ");
		String date = scan.next();
		employmentDate = LocalDate.parse(date);
		System.out.println("Enter in salary: ");
		salary = scan.nextLong();
		System.out.println("Enter in department: ");
		department = scan.next();
		
		Employee employee = new Employee(firstName, lastName, employmentDate, salary, department);
		employees.add(employee);
		return employee;
		
	}
	
	public static Employee updateEmployees(List<Employee> employees, Scanner scan) throws InputMismatchException{
		int id, operation;
		
		System.out.println("Enter in employee id");
		id = scan.nextInt();
		System.out.println("1. Change first name");
		System.out.println("2. Change last name");
		System.out.println("3. Change salary");
		System.out.println("4. Change department");
		System.out.println("\nSelect options by using numbers 1-4 and enter in employee information!");
		operation = scan.nextInt();
		System.out.println("Enter in new information");
		
		switch(operation) {
			case 1:
				String first = scan.next();
				employees.get(id - 1).setFirstName(first);
				break;
			case 2:
				String last = scan.next();
				employees.get(id - 1).setLastName(last);
				break;
			case 3:
				Long salary = scan.nextLong();
				employees.get(id - 1).setSalary(salary);
				break;
			case 4:
				String department = scan.next();
				employees.get(id - 1).setDepartment(department);
				break;
		}
		return employees.get(id-1);
	}
	
	public static Employee removeEmployees(List<Employee> employees, Scanner scan) throws InputMismatchException{
		int id;
		
		System.out.println("Enter in employee id");
		id = scan.nextInt();
		Employee employee = employees.get(id - 1);
		employees.remove(id-1);
		return employee;
	}
	public static void listEmployees(List<Employee> employees, Scanner scan) throws InputMismatchException{
		int operation;

		
		System.out.println("1. Find highest salary");
		System.out.println("2. List all employees");
		System.out.println("\nSelect options by using numbers 1-2 and enter in employee information!");
		operation = scan.nextInt();
		
		switch(operation) {
			case 1: 
				Employee highestSalary = employees.stream()
				 .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
				 .get();
				System.out.println("Employee with highest salary: " + highestSalary);
				break;
			case 2: 
				for(Employee employee : employees) {
					System.out.println(employee);
				}
				break;
		}
	}
	
	public static void menu() {
		System.out.println("***** Employee Management System *****");
		System.out.println("1. Add new employees");
		System.out.println("2. Update employee information");
		System.out.println("3. Remove employees");
		System.out.println("4. List employee information");
		System.out.println("\nSelect options by using numbers 1-4 and enter in employee information!");
		System.out.println("Select option 5 to exit!");
	}
	

}
