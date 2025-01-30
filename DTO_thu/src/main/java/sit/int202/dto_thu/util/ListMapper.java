package sit.int202.dto_thu.util;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class ListMapper {
    private static final ListMapper listMapper = new ListMapper();
    private ListMapper() { }

    // แปลงจาก List<S> ไปเป็น List<T> โดยใช้ ModelMapper
    public <S, T> List<T> mapList(List<S> source, Class<T> targetClass, ModelMapper modelMapper) {
        return source.stream().map(entity -> modelMapper.map(entity, targetClass)).toList();
    }
    public static ListMapper getInstance() {
        return listMapper;

    }

    // แปลงจาก Page<S> ไปเป็น PageDto<T>
    public <S, T> PageDto<T> toPageDTO(Page<S> source, Class<T> targetClass,ModelMapper modelMapper) {
        PageDto<T> page = modelMapper.map(source, PageDto.class);
        // แปลงข้อมูลใน content ไปเป็น List<T> โดยใช้ mapList
        page.setContent(mapList(source.getContent(), targetClass, modelMapper));
        return page;
    }
    }
}
