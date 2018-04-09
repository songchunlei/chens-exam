package com.chens.exam.wms.vo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.enums.ForderTypeEnum;
import com.chens.exam.core.vo.AbstractForder;
import com.chens.exam.core.vo.ForderInfo;
import com.chens.exam.wms.service.ISourceService;
import com.chens.exam.wms.vo.mapper.ForderMapper;
import com.chens.exam.wms.vo.service.IForderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 文件夹表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public abstract class AbstractForderServiceImpl<M extends ForderMapper<T>, T extends AbstractForder<T>>  extends ServiceImpl<M, T> implements IForderService<T> {

    @Autowired
    private ISourceService sourceService;

    @Override
    public T selectForderById(String id) {
        T t = this.selectById(id);
        if(t==null)
        {
            throw new BaseException(BaseExceptionEnum.QUERY_ERROR);
        }
        //1. 寻找父文件夹
        if(t.getLvl()!=1)
        {
            //当前文件夹是父文件夹时，不往上找一层
            t.setParentForder(this.selectById(t.getParentId()));
        }

        //2. 获取当前文件夹下的文件夹
        EntityWrapper<T> wrapper = new EntityWrapper<T>();
        wrapper.eq(ExamConstants.FORDER_COLUMN_PARENT_ID,t.getId());
        t.setChildForders(this.selectList(wrapper));

        //3. 获取当前文件夹下的文件
        List<ForderInfo> forderInfos = new ArrayList<>();
        if(ForderTypeEnum.SOURCE.getCode().equals(t.getForderType()))
        {
            Source source = new Source();
            source.setForderId(t.getId());
            EntityWrapper<Source> wrapperE = new EntityWrapper<>(source);
            List<Source> sourceList = sourceService.selectList(wrapperE);
            for (Source temp:sourceList) {
                forderInfos.add(temp.getForderInfo());
            }
            t.setFiles(forderInfos);
        }
        return t;
    }
}
