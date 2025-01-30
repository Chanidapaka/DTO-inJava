package sit.int202.dto_thu.controllers;


import lombok.Getter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sit.int202.dto_thu.DTOs.PageDTO;
import sit.int202.dto_thu.DTOs.SimpleCustomerDto;
import sit.int202.dto_thu.entities.Customer;
import sit.int202.dto_thu.services.CustomerService;
import sit.int202.dto_thu.util.ListMapper;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    @Autowired //ในที่นี้คือการ Inject CustomerService และ ModelMapper มาใช้ใน Controller
    private CustomerService customerService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ListMapper listMapper;

    @GetMapping("")
    public ResponseEntity<Object> findAllCustomers(
            @RequestParam(required = false) Integer pageNo,
            @RequestParam(required = false) Integer pageSize
    ) {
        if(pageNo == null || pageSize == null){
            List<Customer> customerList = customerService.findAll();
//            return ResponseEntity.ok(customerList.stream()
//                    .map(c -> modelMapper.map(c, SimpleCustomerDto.class)).toList());
            return ResponseEntity.ok(
                    listMapper.mapList(customerList, SimpleCustomerDto.class, modelMapper));
        }else{
            // หากระบุ pageNo และ pageSize จะใช้การแบ่งหน้า
            Page<Customer> page = customerService.findAll(pageNo, pageSize); // ดึงข้อมูลลูกค้าตามการแบ่งหน้า

            // แปลงข้อมูลใน content ไปเป็น SimpleCustomerDto
            //PageDTO<SimpleCustomerDto> pageDto = modelMapper.map(page, PageDTO.class);

            // แปลงแต่ละรายการใน content ของ page ไปเป็น SimpleCustomerDto
//            pageDto.setContent(page.getContent().stream()
//                    .map(c -> modelMapper.map(c, SimpleCustomerDto.class)).toList());
            return ResponseEntity.ok(listMapper.toPageDTO(page, SimpleCustomerDto.class, modelMapper));  // ส่งคืน PageDTO ที่มีข้อมูลที่แปลงแล้ว
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<SimpleCustomerDto> getAllCustomers(@PathVariable int id) {
        // ค้นหาลูกค้าจาก id
        Customer customer = customerService.findById(id);

        return ResponseEntity.ok(modelMapper.map(customer, SimpleCustomerDto.class)); //--> ได้ obj. มา mapper
    }
}
