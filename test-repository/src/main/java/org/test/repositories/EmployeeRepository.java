package org.test.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.test.modals.Employee;

@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}