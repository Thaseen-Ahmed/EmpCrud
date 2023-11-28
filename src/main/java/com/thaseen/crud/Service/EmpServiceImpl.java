package com.thaseen.crud.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.thaseen.crud.Model.Employee;
import com.thaseen.crud.Repository.EmpRepo;

@Service
public class EmpServiceImpl implements EmpService{
	    
	@Autowired
	private EmpRepo emprepo;

	public List<Employee> getAllEmployees() {
		
		return emprepo.findAll();
	}

	@Override
	public void saveEmployee(Employee emp) {
		this.emprepo.save(emp);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		
		Optional<Employee> option = emprepo.findById(id);
		Employee empl = null;
		
		if(option.isPresent()){
			empl = option.get();
			
		}
		else {
			throw new RuntimeException("Employee not found for id :: "+id);
			
		}
 			
		return empl;
	}

	@Override
	public void deleteEmployeeById(long id) {
		
		this.emprepo.deleteById(id);
		
	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize) {
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		return this.emprepo.findAll(pageable);
	}

}
