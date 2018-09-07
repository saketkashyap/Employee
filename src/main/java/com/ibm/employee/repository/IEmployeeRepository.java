package com.ibm.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.yaml.snakeyaml.events.Event.ID;

import com.ibm.employee.entities.Employee;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, ID> {

	@Query("select e from Employee e where e.id= :id")
	public Employee findEmployeeById(@Param("id") long id);
}
