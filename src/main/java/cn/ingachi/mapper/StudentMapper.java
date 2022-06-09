package cn.ingachi.mapper;

import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author maisann
* @description 针对表【student】的数据库操作Mapper
* @createDate 2022-06-04 16:55:27
* @Entity cn.ingachi.entity.Student
*/
public interface StudentMapper extends BaseMapper<Student> {

    List<StudentDto> getStudentDtoList();

    StudentDto getStudentDtoById(Long id);


}




