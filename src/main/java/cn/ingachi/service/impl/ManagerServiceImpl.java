package cn.ingachi.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Manager;
import cn.ingachi.service.ManagerService;
import cn.ingachi.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

/**
* @author maisann
* @description 针对表【manager】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{

}




