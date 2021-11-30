package com.lhd.tams.module.classes.model.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lhd.tams.module.classes.model.data.ClassesDO;
import com.lhd.tams.module.classes.model.dto.ClassesSaveDTO;
import com.lhd.tams.module.classes.model.vo.ClassesListVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * @author snicker
 * @date 2021/11/18 19:26
 * @Describe
 */
@Mapper
public abstract class AbstractClassesConverter {

    public static AbstractClassesConverter INSTANCE = Mappers.getMapper(AbstractClassesConverter.class);

    public abstract Page<ClassesListVO> doPage2ListVoPage(IPage<ClassesDO> doPage);

    public abstract List<ClassesListVO> doList2ListVoList(List<ClassesDO> doList);

    public abstract ClassesListVO do2ListVO(ClassesDO dataObj);

    public abstract ClassesDO saveDto2DO(ClassesSaveDTO saveDTO);

}
