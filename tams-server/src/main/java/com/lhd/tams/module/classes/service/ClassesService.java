package com.lhd.tams.module.classes.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.lhd.tams.module.classes.model.dto.ClassesPageQuery;
import com.lhd.tams.module.classes.model.dto.ClassesSaveDTO;
import com.lhd.tams.module.classes.model.vo.ClassesListVO;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/18 19:31
 * @Describe
 */
public interface ClassesService {

    IPage<ClassesListVO> pageClasses(ClassesPageQuery pageQuery);

    List<ClassesListVO> refList();

    ClassesListVO getClassesById(Long id);

    boolean saveClasses(ClassesSaveDTO saveDTO);

    boolean updateClassesById(Long id, ClassesSaveDTO saveDTO);

    boolean updateClassesEnableStateById(Long id, Integer enableState);
}
