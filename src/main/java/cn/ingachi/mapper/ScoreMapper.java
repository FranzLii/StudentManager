package cn.ingachi.mapper;

import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Score;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author maisann
 * @description 针对表【score】的数据库操作Mapper
 * @createDate 2022-06-04 16:55:27
 * @Entity cn.ingachi.entity.Score
 */
public interface ScoreMapper extends BaseMapper<Score> {

    StudentDto getScoreAndRankingByIdStudentDto(@Param("id") Integer id);


    List<Map<String,Object>> getScoreMap(@Param("subjectName") String subjectName,@Param("classId") Integer classId);

    List<String> getScoreNamesByClassId(Integer id);
}




