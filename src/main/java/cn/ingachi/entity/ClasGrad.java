package cn.ingachi.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName clas_grad
 */
@TableName(value ="clas_grad")
@Data
public class ClasGrad implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private Integer cid;

    /**
     * 
     */
    private Integer gid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}