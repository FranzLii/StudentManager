package cn.ingachi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Grade;
import cn.ingachi.service.GradeService;
import cn.ingachi.mapper.GradeMapper;
import org.springframework.stereotype.Service;

/**
* @author maisann
* @description 针对表【grade】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
    implements GradeService{

}




