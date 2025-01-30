package sit.int202.dto_thu.repositories;

import org.springframework.data.repository.CrudRepository;
import sit.int202.dto_thu.entities.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
}
