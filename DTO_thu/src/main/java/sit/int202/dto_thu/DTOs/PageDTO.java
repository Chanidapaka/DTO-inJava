package sit.int202.dto_thu.DTOs;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO<T> {
    private List<T> content;
    private Boolean last;
    private Boolean first;
    private Integer totalPages;
    private Integer size;

    @JsonIgnore //--> ฟิลด์ นี้ไม่ถูกแปลงเป็นไฟล์ json แต่ถูกเก็บ
    private Integer number;

    public Integer getPage() {
        return number;
    }
}
