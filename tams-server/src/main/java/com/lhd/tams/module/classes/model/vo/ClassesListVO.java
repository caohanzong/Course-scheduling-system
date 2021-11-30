package com.lhd.tams.module.classes.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author snicker
 * @date 2021/11/18 19:25
 * @Describe
 */
@ApiModel(value = "班级列表返回结果")
@Data
public class ClassesListVO {
    @ApiModelProperty(value = "id")
    private Long id;

    @ApiModelProperty(value = "班级名")
    private String name;

    @ApiModelProperty(value = "停启用状态")
    private Integer enableState;
}
