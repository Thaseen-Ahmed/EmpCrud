package com.thaseen.crud.Service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.thaseen.crud.Model.Employee;

public interface EmpService {

	 List<Employee> getAllEmployees();
	 
	 void saveEmployee(Employee emp);
	 
	 Employee getEmployeeById(long id);
	 
	 void deleteEmployeeById(long id);
	 
	 Page<Employee> findPaginated(int pageNo, int pageSize);
	
}
