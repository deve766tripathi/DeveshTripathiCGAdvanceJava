package practice.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
	public static void main(String [] args) {
		List<Employee> emp=Arrays.asList(
				new Employee(101,"Alice",60000),
				new Employee(102,"Bob",70000),
				new Employee(103,"Devesh",40000),
				new Employee(104,"Alia",50000),
				new Employee(105,"Aliz",690000)
				);
		System.out.println("Employee with salary greater than 50000");
		emp.stream().filter(e -> e.getSalary()>50000).forEach(e -> System.out.println(e.getName()));
		double secondHighestSalary= emp.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0.0);
		System.out.println("\nSecond Highest Salary: "+secondHighestSalary);
		long totalEmployees=emp.stream().count();
		System.out.println("Total Employees: "+totalEmployees);
		
				}
}
