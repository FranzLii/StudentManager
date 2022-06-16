package cn.ingachi.service.impl;

import cn.ingachi.dto.ClassesDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Classes;
import cn.ingachi.service.ClassesService;
import cn.ingachi.mapper.ClassesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author maisann
* @description 针对表【classes】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes>
    implements ClassesService{

    @Autowired
    private ClassesMapper classesMapper;
    @Override
    public List<ClassesDto> getClassesDtoList() {
        return classesMapper.getClassesDtoList();
    }
}




