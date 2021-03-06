package cn.ingachi.service;

import cn.ingachi.dto.ClassesDto;
import cn.ingachi.entity.Classes;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author maisann
* @description 针对表【classes】的数据库操作Service
* @createDate 2022-06-04 16:55:27
*/
public interface ClassesService extends IService<Classes> {
    List<ClassesDto> getClassesDtoList();
}
