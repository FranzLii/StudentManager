package cn.ingachi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName score
 */
@TableName(value ="score")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Score implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String score;

    /**
     * 
     */
    private Long sid;


    @TableField(exist = false)
    private Integer ranking;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}