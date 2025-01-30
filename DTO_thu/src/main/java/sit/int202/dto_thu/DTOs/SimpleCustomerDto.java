package sit.int202.dto_thu.DTOs;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.jaxb.SpringDataJaxb;

import java.util.List;

@Getter
@Setter
public class SimpleCustomerDto {
    private Integer id;
    private String customerName;
    private String country;
    private Double creditCardNumber;
    @JsonIgnore
    private EmployeeNameDto sales; // --> จาก employee มาเป็น ฟิวส์ salesRepEmployeeNumber
//    private String salesLastName;
//    private String salesFirstName;
    public String getSalePerson() {
        return sales==null? "-" : (sales.getFirstName() + " " + sales.getLastName());
        //{
        //    "id": 112,
        //    "customerName": "Signal Gift Stores",
        //    "country": "USA",
        //    "creditCardNumber": null,
        //    "salePerson": "Leslie Thompson"
        //} อันที่เราเห็น
    }

    private List<OrderDto> orders;
    //{
    //    "id": 112,
    //    "customerName": "Signal Gift Stores",
    //    "country": "USA",
    //    "creditCardNumber": null,
    //    "orders": [
    //        {
    //            "id": 10278,
    //            "status": "Shipped"
    //        },
    //        {
    //            "id": 10124,
    //            "status": "Shipped"
    //        },
    //        {
    //            "id": 10346,
    //            "status": "Shipped"
    //        }
    //    ],
    //    "salePerson": "Leslie Thompson"
    //}
}
