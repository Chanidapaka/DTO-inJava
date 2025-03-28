package sit.int202.dto_thu.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sit.int202.dto_thu.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
