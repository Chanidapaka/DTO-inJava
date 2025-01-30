package sit.int202.dto_thu.repositories;

import org.springframework.data.repository.CrudRepository;
import sit.int202.dto_thu.entities.Order;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
