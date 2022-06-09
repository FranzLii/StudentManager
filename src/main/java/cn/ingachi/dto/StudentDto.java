package cn.ingachi.dto;

import cn.ingachi.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto extends Student {
    private Classes classes;
    private Major major;
    private Grade grade;
    private List<Score> scores;
}
