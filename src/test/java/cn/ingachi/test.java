package cn.ingachi;


import cn.ingachi.dto.StudentDto;
import cn.ingachi.entity.Score;
import cn.ingachi.mapper.ScoreMapper;
import cn.ingachi.mapper.StudentMapper;
import cn.ingachi.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class test {

    @Autowired
    private ScoreMapper scoreMapper;

    @Test
    public void testStudentMapper(){
//        StudentDto scoreAndRankingByIdStudentDto = scoreMapper.getScoreAndRankingByIdStudentDto(1);
//        for (Score score : scoreAndRankingByIdStudentDto.getScores()) {
//            System.out.println(score);
        }
    }

}
