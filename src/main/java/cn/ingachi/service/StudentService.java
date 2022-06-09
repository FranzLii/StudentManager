package cn.ingachi.service;

import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author maisann
 * @description 针对表【student】的数据库操作Service
 * @createDate 2022-06-04 16:55:27
 */
public interface StudentService extends IService<Student> {
    List<StudentDto> getStudentDtoList();
    StudentDto getStudentDtoById(Long id);
}
