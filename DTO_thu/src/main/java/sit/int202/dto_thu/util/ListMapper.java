package sit.int202.dto_thu.util;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import sit.int202.dto_thu.DTOs.PageDTO;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapper {
    private static final ListMapper listMapper = new ListMapper();

    private ListMapper() { }

    // แปลงจาก List<S> ไปเป็น List<T> โดยใช้ ModelMapper
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).collect(Collectors.toList());
    }

    public static ListMapper getInstance() {
        return listMapper;
    }

    // แปลงจาก Page<S> ไปเป็น PageDTO<T>
    public <S, T> PageDTO<T> toPageDTO(Page<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        PageDTO<T> page = modelMapper.map(source, PageDTO.class);

        // แปลงข้อมูลใน content ไปเป็น List<T> โดยใช้ mapList
        page.setContent(mapList(source.getContent(), targetClass, modelMapper));

        // ตั้งค่าอื่นๆ ของ page
        page.setLast(source.isLast());
        page.setFirst(source.isFirst());
        page.setTotalPages(source.getTotalPages());
        page.setSize(source.getSize());
        page.setNumber(source.getNumber());

        return page;
    }
}
