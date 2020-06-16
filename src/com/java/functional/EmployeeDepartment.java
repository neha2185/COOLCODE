package com.java.functional;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeDepartment {

	public static void main(String[] args) {
		//deptname, noOfEmployees
		Department account = new Department("Account", 75);
		Department hr = new Department("HR", 50);
		Department ops = new Department("OP", 25);
		Department tech = new Department("Tech", 150);
		
		//empname, age, city, dept
		List<Employee> employeeList = Arrays.asList(new  Employee("David", 32, "Matara", account), 
                new  Employee("Brayan", 25, "Galle", hr),
                new  Employee("JoAnne", 45, "Negombo", ops),
                new  Employee("Jake", 65, "Galle", hr),
                new  Employee("Brent", 55, "Matara", hr),
                new  Employee("Allice", 23, "Matara", ops),
                new  Employee("Austin", 30, "Negombo", tech),
                new  Employee("Gerry", 29, "Matara", tech),
                new  Employee("Scote", 20, "Negombo", ops),
                new  Employee("Branden", 32, "Matara", account),
                new  Employee("Iflias", 31, "Galle", hr));
		
		//Find all employees who lives in ‘Matara’ city, sort them by their name and print the names of employees.
		employeeList.stream()
			.filter(e -> e.getCity().equalsIgnoreCase("Matara"))
			.sorted(Comparator.comparing(Employee::getName))
			.forEach(e -> System.out.println(e.getName()));

		//Find distinct department names that employees work for.
		employeeList.stream()
			.map(e -> e.getDepartment().getDepartmentName())
			.distinct()
			.forEach(System.out::println);
		
		//Find the department names that these employees work for, where the number of employees in the department is over 50.
		employeeList.stream()
			.filter(e -> e.getDepartment().getNoOfEmployees() > 50)
			.map(e -> e.getDepartment().getDepartmentName())
			.distinct()
			.forEach(System.out::println);

		//Create a comma separate string of department names sorted alphabetically.
		System.out.println(employeeList.stream()
			.map(e -> e.getDepartment().getDepartmentName())
			.sorted()
			.distinct()
			.collect(Collectors.joining(",")));
		
		//Are there any employees from HR Department?
		boolean isAnyHR = employeeList.stream()
			.anyMatch(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("HR"));
		System.out.println(isAnyHR ? "HR Present" : "HR Absent");

		//Print all employee’s name who are working for account department.
		employeeList.stream()
			.filter(e -> e.getDepartment().getDepartmentName().equalsIgnoreCase("Account"))
			.map(Employee::getName)
			.forEach(System.out::println);
		
		//What is the highest number of of employees in all departments and its name
		employeeList.stream()
			.map(Employee::getDepartment)
			.max(Comparator.comparing(Department::getNoOfEmployees))
			.ifPresent(d -> System.out.println(d.getNoOfEmployees() + ", deptName: " + d.getDepartmentName())); 
		
		//Find the total number of employees in all the departments.
		employeeList.stream()
			.map(e -> e.getDepartment().getNoOfEmployees())
			.distinct()
			.reduce(Integer::sum)
			.ifPresent(System.out::println);
	}
}

class Employee {
	private String name;
	private Integer age;
	private String city;
	private Department department;

	public Employee(String name, Integer age, String city, Department department) {
		this.name = name;
		this.age = age;
		this.city = city;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
}

class Department {
	private String departmentName;
	private Integer noOfEmployees;

	public Department(String departmentName, Integer noOfEmployees) {
		this.departmentName = departmentName;
		this.noOfEmployees = noOfEmployees;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public Integer getNoOfEmployees() {
		return noOfEmployees;
	}

	public void setNoOfEmployees(Integer noOfEmployees) {
		this.noOfEmployees = noOfEmployees;
	}
}
