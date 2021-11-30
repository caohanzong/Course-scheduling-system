package com.lhd.tams.module.classes.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author snicker
 * @date 2021/11/18 19:24
 * @Describe
 */
@ApiModel(value = "班级分页查询参数")
@Data
public class ClassesSaveDTO {
    @ApiModelProperty(value = "班级名")
    private String name;
}
