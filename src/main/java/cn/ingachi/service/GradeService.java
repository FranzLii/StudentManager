package cn.ingachi.service;

import cn.ingachi.dto.GradeDto;
import cn.ingachi.entity.Grade;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author maisann
* @description 针对表【grade】的数据库操作Service
* @createDate 2022-06-04 16:55:27
*/
public interface GradeService extends IService<Grade> {
    public List<GradeDto> getGradeDtoList();
}
