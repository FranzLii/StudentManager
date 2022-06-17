package cn.ingachi.dto;

import cn.ingachi.entity.Grade;
import cn.ingachi.entity.Major;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GradeDto extends Grade {
    private Major major;
}
