package cn.ingachi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Classes;
import cn.ingachi.service.ClassesService;
import cn.ingachi.mapper.ClassesMapper;
import org.springframework.stereotype.Service;

/**
* @author maisann
* @description 针对表【classes】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, Classes>
    implements ClassesService{

}




