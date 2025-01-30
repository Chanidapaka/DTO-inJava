package sit.int202.dto_thu.controllers;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sit.int202.dto_thu.DTOs.SimpleCustomerDto;
import sit.int202.dto_thu.entities.Customer;
import sit.int202.dto_thu.services.CustomerService;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired //ในที่นี้คือการ Inject CustomerService และ ModelMapper มาใช้ใน Controller
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/{id}")
    public ResponseEntity<SimpleCustomerDto> getAllCustomers(@PathVariable int id) {
        // ค้นหาลูกค้าจาก id
        Customer customer = customerService.findById(id);

        return ResponseEntity.ok(modelMapper.map(customer, SimpleCustomerDto.class)); //--> ได้ obj. มา mapper
    }
}
