package com.lhd.tams.module.classes.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lhd.tams.common.consts.EnableStateEnum;
import com.lhd.tams.module.classes.dao.ClassesMapper;
import com.lhd.tams.module.classes.model.convert.AbstractClassesConverter;
import com.lhd.tams.module.classes.model.data.ClassesDO;
import com.lhd.tams.module.classes.model.dto.ClassesPageQuery;
import com.lhd.tams.module.classes.model.dto.ClassesSaveDTO;
import com.lhd.tams.module.classes.model.vo.ClassesListVO;
import com.lhd.tams.module.classes.service.ClassesService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/18 19:31
 * @Describe
 */
@Service
public class ClassesServiceImpl extends ServiceImpl<ClassesMapper, ClassesDO> implements ClassesService {

    @Override
    public IPage<ClassesListVO> pageClasses(ClassesPageQuery pageQuery) {

        LambdaQueryWrapper<ClassesDO> queryWrapper = Wrappers.<ClassesDO>lambdaQuery()
                .eq(pageQuery.getEnableState() != null, ClassesDO::getEnableState, pageQuery.getEnableState())
                .orderByAsc(ClassesDO::getName);

        IPage<ClassesDO> doPage = page(new Page<>(pageQuery.getCurrent(), pageQuery.getSize()), queryWrapper);

        IPage<ClassesListVO> voPage = AbstractClassesConverter.INSTANCE.doPage2ListVoPage(doPage);

        return voPage;
    }

    @Override
    public List<ClassesListVO> refList() {

        LambdaQueryWrapper<ClassesDO> queryWrapper = Wrappers.<ClassesDO>lambdaQuery()
                .eq(ClassesDO::getEnableState, EnableStateEnum.ENABLED.getCode())
                .orderByAsc(ClassesDO::getName);

        List<ClassesDO> doList = list(queryWrapper);

        List<ClassesListVO> voList = AbstractClassesConverter.INSTANCE.doList2ListVoList(doList);

        return voList;
    }

    @Override
    public ClassesListVO getClassesById(Long id) {

        ClassesDO dataObj = getById(id);

        ClassesListVO vo = AbstractClassesConverter.INSTANCE.do2ListVO(dataObj);

        return vo;
    }

    @Override
    public boolean saveClasses(ClassesSaveDTO saveDTO) {

        ClassesDO dataObj = AbstractClassesConverter.INSTANCE.saveDto2DO(saveDTO);

        return save(dataObj);
    }

    @Override
    public boolean updateClassesById(Long id, ClassesSaveDTO saveDTO) {

        ClassesDO dataObj = AbstractClassesConverter.INSTANCE.saveDto2DO(saveDTO);
        dataObj.setId(id);

        return updateById(dataObj);
    }

    @Override
    public boolean updateClassesEnableStateById(Long id, Integer enableState) {

        ClassesDO dataObj = new ClassesDO();
        dataObj.setId(id);
        dataObj.setEnableState(enableState);

        return updateById(dataObj);
    }

}
