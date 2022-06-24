package cn.ingachi.service.impl;

import cn.ingachi.dto.StudentDto;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ingachi.entity.Score;
import cn.ingachi.service.ScoreService;
import cn.ingachi.mapper.ScoreMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
* @author maisann
* @description 针对表【score】的数据库操作Service实现
* @createDate 2022-06-04 16:55:27
*/
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreMapper, Score>
    implements ScoreService{

    @Autowired
    private ScoreMapper scoreMapper;

    @Override
    public StudentDto getStudentScoreAndRankingById(Integer id) {
       return scoreMapper.getScoreAndRankingByIdStudentDto(id);
    }

    @Override
    public List<Map<String, Object>> getScoreMap(String subjectName, Integer classId) {
        return scoreMapper.getScoreMap(subjectName,classId);
    }

    @Override
    public List<String> getScoreNamesByClassId(Integer id) {
        return scoreMapper.getScoreNamesByClassId(id);
    }
}




