package com.thaseen.crud.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thaseen.crud.Model.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Long>{

}
