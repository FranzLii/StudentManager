package cn.ingachi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Major;
import cn.ingachi.service.MajorService;
import cn.ingachi.mapper.MajorMapper;
import org.springframework.stereotype.Service;

/**
* @author maisann
* @description 针对表【major】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class MajorServiceImpl extends ServiceImpl<MajorMapper, Major>
    implements MajorService{

}




