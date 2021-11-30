package com.lhd.tams.module.classes.model.data;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author snicker
 * @date 2021/11/18 19:21
 * @Describe
 */
@Data
@TableName("t_classes")
public class ClassesDO {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 停启用状态
     */
    private Integer enableState;
}
