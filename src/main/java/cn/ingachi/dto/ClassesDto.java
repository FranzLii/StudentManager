package cn.ingachi.dto;

import cn.ingachi.entity.Classes;
import cn.ingachi.entity.Grade;
import cn.ingachi.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ClassesDto extends Classes {
    private Grade grade;
    private Major major;
}
