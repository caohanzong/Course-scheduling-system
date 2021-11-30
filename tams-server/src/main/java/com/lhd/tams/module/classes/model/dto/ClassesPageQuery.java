package com.lhd.tams.module.classes.model.dto;

import com.lhd.tams.common.model.BasePageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author snicker
 * @date 2021/11/18 19:23
 * @Describe
 */
@ApiModel(value = "班级分页查询参数")
@Data
public class ClassesPageQuery extends BasePageQuery {
    @ApiModelProperty(value = "停启用状态")
    private Integer enableState;
}
