package cn.ingachi.mapper;

import cn.ingachi.dto.GradeDto;
import cn.ingachi.entity.Grade;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author maisann
* @description 针对表【grade】的数据库操作Mapper
* @createDate 2022-06-04 16:55:27
* @Entity cn.ingachi.entity.Grade
*/
public interface GradeMapper extends BaseMapper<Grade> {
    List<GradeDto> getGradeDtoList();


}




