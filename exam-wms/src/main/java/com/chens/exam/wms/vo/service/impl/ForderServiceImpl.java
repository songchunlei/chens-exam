package com.chens.exam.wms.vo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.enums.ForderTypeEnum;
import com.chens.exam.core.vo.Forder;
import com.chens.exam.wms.vo.mapper.ForderMapper;
import com.chens.exam.wms.vo.service.IForderService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * <p>
 * 文件夹表 服务实现类
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
public class ForderServiceImpl<FILE,FILESERVICE extends IService,M extends ForderMapper<FILE,T>, T extends Forder<FILE,T>>  extends ServiceImpl<M, T> implements IForderService<FILE,T> {

    @Autowired
    private FILESERVICE filService;

    @Override
    public T selectForderById(String id) {
        T t = this.selectById(id);

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
        if(ForderTypeEnum.SOURCE.getCode().equals(t.getForderType()))
        {
            EntityWrapper<FILE> wrapperE = new EntityWrapper<FILE>();
            wrapperE.eq(ExamConstants.FORDER_FILE_COLUMN_FORDER_ID,t.getId());
            t.setFiles(filService.selectList(wrapperE));
        }
        return this.selectById(id);
    }
}
