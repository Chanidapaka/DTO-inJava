package sit.int202.dto_thu;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DtoThuApplication {

    public static void main(String[] args) {
        SpringApplication.run(DtoThuApplication.class, args);
    }

    @Bean //เอาAutowire มาใช้ได้
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
