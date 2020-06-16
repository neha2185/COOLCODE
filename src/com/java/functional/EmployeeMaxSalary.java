package com.java.functional;

import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeMaxSalary {

	public static void main(String[] args) {
		Stream<Employee1> streamEmp = Stream.of(new Employee1("Neha", 35, 213124, "Pune"),
				  new Employee1("Abhi", 36, 3450, "NYC"),
				  new Employee1("Abhi123", 89, 743, "NYC"),
				  new Employee1("Abhijit", 26, 167359, "London"),
				  new Employee1("Patil", 21, 124, "Pune"),
				  new Employee1("Patil1", 27, 3217, "Pune"),
				  new Employee1("Kukku", 25, 45718, "Pune"),
				  new Employee1("Duddu", 40, 23487, "Pune"),
				  new Employee1("Baby", 41, 8973, "Pune"),
				  new Employee1("chota baby", 90, 11000, "Pune"));
		
		//Print top 3 empname and salary whose salary is highest
		/*streamEmp
			.sorted(Comparator.comparing(Employee1::getSalary).reversed())
			.limit(3)
			.forEach(e -> System.out.println(e.getName() + ", " + e.getSalary()));
		streamEmp.close();
		*/
		//city wise topmost salary
		streamEmp
			.collect(Collectors.groupingBy(Employee1::getCity, Collectors.maxBy(Comparator.comparing(Employee1::getSalary))))
			.forEach((k,v) -> System.out.println(k + ": " + v.map(Employee1::getSalary).get()));
		streamEmp.close();
	}
}

class Employee1 {
	private String name;
	private Integer age;
	private Integer salary;
	private String city;
	
	public Employee1(String name, Integer age, Integer salary, String city) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.city = city;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
