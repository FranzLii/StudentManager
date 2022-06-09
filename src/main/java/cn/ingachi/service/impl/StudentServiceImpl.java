package cn.ingachi.service.impl;

import cn.ingachi.dto.StudentDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Student;
import cn.ingachi.service.StudentService;
import cn.ingachi.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author maisann
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-06-04 16:55:27
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<StudentDto> getStudentDtoList() {
        return studentMapper.getStudentDtoList();
    }

    @Override
    public StudentDto getStudentDtoById(Long id) {
        return studentMapper.getStudentDtoById(id);
    }
}




