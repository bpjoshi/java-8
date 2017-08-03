package com.bpjoshi.java8.introduction;
/**
 * 
 * @author bpjoshi(Bhagwati Prasad)
 *
 */
public class EmployeeUtility {
	public static boolean isEmployeeFromDelhi(Employee emp){
		return "Delhi".equalsIgnoreCase(emp.getAddress());
	}
	
	public static boolean isEmployeeRich(Employee emp){
		return emp.getSalary()>3000?true:false;
	}
	
}

