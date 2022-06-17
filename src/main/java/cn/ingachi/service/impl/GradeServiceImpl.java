package cn.ingachi.service.impl;

import cn.ingachi.dto.GradeDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Grade;
import cn.ingachi.service.GradeService;
import cn.ingachi.mapper.GradeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author maisann
* @description 针对表【grade】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
    implements GradeService{

    @Autowired
    private GradeMapper gradeMapper;
    @Override
    public List<GradeDto> getGradeDtoList() {
        return gradeMapper.getGradeDtoList();
    }
}




