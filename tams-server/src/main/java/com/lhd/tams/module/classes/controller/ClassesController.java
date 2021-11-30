package com.lhd.tams.module.classes.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhd.tams.common.base.BaseController;
import com.lhd.tams.common.model.ApiResult;
import com.lhd.tams.module.classes.model.dto.ClassesPageQuery;
import com.lhd.tams.module.classes.model.dto.ClassesSaveDTO;
import com.lhd.tams.module.classes.model.vo.ClassesListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/18 19:35
 * @Describe
 */
@Api(tags = "班级")
@RequestMapping("classes")
@RestController
public class ClassesController extends BaseController {

    @Autowired
    private com.lhd.tams.module.classes.service.ClassesService ClassesService;

    @ApiOperation(value = "分页列表", response = ClassesListVO.class)
    @GetMapping
    public ResponseEntity<ApiResult<IPage<ClassesListVO>>> pageClasses(ClassesPageQuery pageQuery) {

        return success(ClassesService.pageClasses(pageQuery));
    }

    @ApiOperation(value = "参照列表", response = ClassesListVO.class)
    @GetMapping("list/ref")
    public ResponseEntity<ApiResult<List<ClassesListVO>>> refList() {

        return success(ClassesService.refList());
    }

    @ApiOperation(value = "详情", response = ClassesListVO.class)
    @GetMapping("{id}")
    public ResponseEntity<ApiResult<ClassesListVO>> getClassesById(@PathVariable("id") Long id) {

        return success(ClassesService.getClassesById(id));
    }

    @ApiOperation(value = "新增")
    @PostMapping
    public ResponseEntity<ApiResult<?>> saveClasses(@Validated @RequestBody ClassesSaveDTO saveDTO) {

        return successOrFail(ClassesService.saveClasses(saveDTO));
    }

    @ApiOperation(value = "修改")
    @PutMapping("{id}")
    public ResponseEntity<ApiResult<?>> updateClassesById(@PathVariable("id") Long id, @Validated @RequestBody ClassesSaveDTO saveDTO) {

        return successOrFail(ClassesService.updateClassesById(id, saveDTO));
    }

    @ApiOperation(value = "停启用")
    @PutMapping("{id}/enable-state/{enableState}")
    public ResponseEntity<ApiResult<?>> updateClassesEnableStateById(@PathVariable("id") Long id, @PathVariable("enableState") Integer enableState) {

        return successOrFail(ClassesService.updateClassesEnableStateById(id, enableState));
    }

}
