package sit.int202.dto_thu.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SimpleCustomerDto {
    private Integer id;
    private String customerName;
    private String country;
    private Double creditCardNumber;
}
