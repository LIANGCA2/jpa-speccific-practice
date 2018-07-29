package com.oocl.jpaspecificpratice.responsity;

import com.oocl.jpaspecificpratice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{
}
