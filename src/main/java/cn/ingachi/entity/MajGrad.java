package cn.ingachi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName maj_grad
 */
@TableName(value ="maj_grad")
@Data
public class MajGrad implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer mid;

    /**
     * 
     */
    private Integer gid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}