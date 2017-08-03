package com.bpjoshi.java8.introduction;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import org.junit.Test;
/**
 * 
 * @author bpjoshi(Bhagwati Prasad)
 *
 */
public class EmployeeTest {
	@Test
	public void employeeOrderingBySalaryJava7Test() {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("Kanishk", "Delhi", 5, 2500));
		employeesList.add(new Employee("Sweta", "Delhi", 6, 5000));
		employeesList.add(new Employee("Bhaskar", "Noida", 8, 8000));
		employeesList.add(new Employee("Sumeet", "Noida", 10, 3500));
		
		// Java 7 way to sort on basis of decreasing order of their salaries
		Collections.sort(employeesList, new Comparator<Employee>() {
			public int compare(Employee emp1, Employee emp2) {
				return emp2.getSalary() - emp1.getSalary();
			}

		});
		
		assertEquals("Bhaskar", employeesList.get(0).getName());
	}
	
	/*@Test
	public void employeeOrderingBySalaryJava8Test() {
		//employeesListJava8.sort(comparing(Employee::getSalary));
	}*/
	
	@Test
	public void filterEmployeesByLocationJava7Test() {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("Kanishk", "Delhi", 5, 2500));
		employeesList.add(new Employee("Sweta", "Delhi", 6, 5000));
		employeesList.add(new Employee("Bhaskar", "Noida", 8, 8000));
		employeesList.add(new Employee("Sumeet", "Noida", 10, 3500));
		
		List<Employee> employeesFromDelhi=employeeByLocation(employeesList, "Delhi");
		
		assertTrue(employeesFromDelhi.get(0).getAddress().equalsIgnoreCase("Delhi"));
		assertTrue(employeesFromDelhi.size()==2);
	}
	
	//Java 7 code to filter employees by location
	public List<Employee> employeeByLocation(List<Employee> employeesList,String location ){
		List<Employee> employeesByLocation=new ArrayList<>();
		for(Employee emp: employeesList){
			if(emp.getAddress().equalsIgnoreCase(location)){
				employeesByLocation.add(emp);
			}
		}
		return employeesByLocation;
	}
	
	@Test
	public void filterEmployeesByFirstName() {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("Kanishk", "Delhi", 5, 2500));
		employeesList.add(new Employee("Sweta", "Delhi", 6, 5000));
		employeesList.add(new Employee("Bhaskar", "Noida", 8, 8000));
		employeesList.add(new Employee("Sumeet", "Noida", 10, 3500));
		List<Employee> employeesNamedKanishk=employeesByName(employeesList, "Kanishk");
		
		assertTrue(employeesNamedKanishk.size()==1);
	}
	//Java 7 code to filter out Kanishk named employees
	public List<Employee> employeesByName(List<Employee> employeesList, String name){
		List<Employee> employeesByName=new ArrayList<>();
		for(Employee emp: employeesList){
			if(emp.getName().equalsIgnoreCase("Kanishk")){
				employeesByName.add(emp);
			}
		}
		return employeesByName;
	}
	
	//Java 8's test
	@Test
	public void filterEmployeesByLocationJava8Test() {
		List<Employee> employeesList = new ArrayList<>();
		employeesList.add(new Employee("Kanishk", "Delhi", 5, 2500));
		employeesList.add(new Employee("Sweta", "Delhi", 6, 5000));
		employeesList.add(new Employee("Bhaskar", "Noida", 8, 8000));
		employeesList.add(new Employee("Sumeet", "Noida", 10, 3500));
		
		//Filtering employees using Method References
		List<Employee> filteredEmployees=filterEmployees(employeesList, EmployeeUtility::isEmployeeFromDelhi);
		assertNotNull(filteredEmployees);
		//Filtering employees using Lambdas on criterion salary ;-) 
		List<Employee> richEmployees=filterEmployees(employeesList, (Employee emp)->(emp.getSalary()>4000));
		assertTrue(richEmployees.size()==3);
		//You can even use || in the right hand side of lamda to filter on 2 criteria.
		//Demonstrate this during training.
	}
	
	//Java 8's single filter method
	List<Employee> filterEmployees(List<Employee> empList, Predicate<Employee> p){
		List<Employee> result=new ArrayList<>();
		for(Employee emp: empList){
			if(p.test(emp)){
				result.add(emp);
			}
		}
		return result;
	}
}
