package sit.int202.dto_thu.services;


import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import sit.int202.dto_thu.entities.Customer;
import sit.int202.dto_thu.repositories.CustomerRepository;


import java.util.List;

@Service
public class CustomerService {
    @Autowired //--> เอา Repository มา
    private CustomerRepository customerRepository;

    // Method to find all customers (returns List of all customers)
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // Method to find customers with pagination support
    public Page<Customer> findAll(Integer page, Integer size) {
        // เช็คว่า page หรือ size เป็นค่าผิดหรือไม่ (เป็น null หรือค่าต่ำกว่า 0)
        if (page == null || page < 0 || size == null || size < 0) {
            // กำหนดค่าเริ่มต้นเป็นหน้าแรก (page = 0) และขนาดหน้าเป็น 10
            return customerRepository.findAll(PageRequest.of(0, (int) (customerRepository.count()))); // default pagination
        } else {
            // ถ้า page และ size ถูกต้องก็ให้ใช้ค่าเหล่านั้นในการสร้าง PageRequest
            return customerRepository.findAll(PageRequest.of(page, size));
        }
    }


    // Method to find a customer by ID
    public Customer findById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }
}
