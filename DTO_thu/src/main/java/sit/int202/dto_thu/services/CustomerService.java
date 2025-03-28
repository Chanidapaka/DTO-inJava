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

    // ฟังก์ชันนี้จะดึงข้อมูลลูกค้าทั้งหมดจากฐานข้อมูล โดยจะใช้เมธอด findAll() ของ customerRepository ซึ่งจะคืนค่าเป็น List ของลูกค้าทั้งหมดที่มีในฐานข้อมูล
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    // ฟังก์ชันนี้ใช้สำหรับการค้นหาลูกค้าทั้งหมดที่มีการแบ่งหน้า (pagination) ซึ่งช่วยให้ข้อมูลไม่มากเกินไป
    //หากค่าของ page หรือ size เป็น null หรือมีค่าต่ำกว่า 0 จะใช้ค่าเริ่มต้น โดยจะตั้งค่าให้แสดงหน้าที่ 0 (หน้าแรก) และขนาดหน้าเป็น 10
    //หากค่าของ page และ size ถูกต้อง จะใช้ค่าดังกล่าวในการสร้าง PageRequest เพื่อแบ่งข้อมูลลูกค้าตามหน้าและขนาดที่กำหนด
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

    // ฟังก์ชันนี้จะค้นหาลูกค้าจากฐานข้อมูลตาม id ที่ระบุ
    //หากไม่พบลูกค้าที่มี id นี้ จะโยนข้อผิดพลาด ResourceNotFoundException และระบุข้อความว่าไม่พบลูกค้าด้วย id ที่ระบุ
    public Customer findById(Integer id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + id));
    }
}
