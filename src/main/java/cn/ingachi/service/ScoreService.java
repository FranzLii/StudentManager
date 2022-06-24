package cn.ingachi.service;

import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Score;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
* @author maisann
* @description 针对表【score】的数据库操作Service
* @createDate 2022-06-04 16:55:27
*/
public interface ScoreService extends IService<Score> {
    StudentDto getStudentScoreAndRankingById(Integer id);
    List<Map<String,Object>> getScoreMap(String subjectName,Integer classId);

    List<String> getScoreNamesByClassId(Integer id);

}
