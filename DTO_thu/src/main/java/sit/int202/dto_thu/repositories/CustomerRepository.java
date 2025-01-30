package sit.int202.dto_thu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import sit.int202.dto_thu.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}

