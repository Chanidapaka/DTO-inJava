package sit.int202.dto_thu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.dto_thu.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
