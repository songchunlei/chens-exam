package com.chens.exam.wms.vo.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.core.constants.CommonConstants;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.util.FolderUtil;
import com.chens.exam.core.constants.ExamConstants;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.core.enums.FolderTypeEnum;
import com.chens.exam.core.vo.AbstractFolder;
import com.chens.core.vo.FolderFileInfo;
import com.chens.exam.wms.service.ISourceService;
import com.chens.exam.wms.vo.mapper.AbstractFolderMapper;
import com.chens.exam.wms.vo.service.IAbstractFolderService;
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
public abstract class AbstractFolderServiceImpl<M extends AbstractFolderMapper<T>, T extends AbstractFolder<T>>  extends ServiceImpl<M, T> implements IAbstractFolderService<T> {

    /**
     *默认为资源文件夹
     */
    protected String folderType = FolderTypeEnum.SOURCE.getCode();

    @Autowired
    private ISourceService sourceService;

    //初始化
    protected abstract void init();

    @Override
    public FolderFileInfo selectForderById(String id) {

        FolderFileInfo forderFileInfo;

        //初始化
        init();

        //1. 寻找父文件夹
        if(CommonConstants.BASE_TREE_ROOT.equals(id))
        {
            //当id为根目录，初始化
            forderFileInfo = FolderUtil.getRootForder(CommonConstants.BASE_TREE_ROOT_NAME);
        }
        else
        {
            T t = this.selectById(id);
            if(t==null)
            {
                throw new BaseException(BaseExceptionEnum.NO_DATA);
            }
            //获取当前文件夹信息
            forderFileInfo = t.getForderFileInfo();
            //当前文件夹是父文件夹时，不往上找一层
            T parent = this.selectById(t.getParentId());
            if (parent != null)
            {
                forderFileInfo.setParent(parent.getForderFileInfo());
            }
        }

        //2. 获取当前文件夹下的文件夹
        EntityWrapper<T> wrapper = new EntityWrapper<T>();
        wrapper.eq(ExamConstants.FORDER_COLUMN_PARENT_ID,id);
        List<T> childForderTemps = this.selectList(wrapper);
        List<FolderFileInfo> childForders = new ArrayList<>();
        for (T temp:childForderTemps)
        {
            childForders.add(temp.getForderFileInfo());
        }
        if(childForders!=null && childForders.size()>0)
        {
            forderFileInfo.setChildren(childForders);
        }


        //3. 获取当前文件夹下的文件
        List<FolderFileInfo> forderInfos = new ArrayList<>();
        if(FolderTypeEnum.SOURCE.getCode().equals(folderType))
        {
            Source source = new Source();
            source.setForderId(id);
            EntityWrapper<Source> wrapperE = new EntityWrapper<>(source);
            List<Source> sourceList = sourceService.selectList(wrapperE);
            for (Source temp:sourceList) {
                forderInfos.add(temp.getForderInfo());
            }
            forderFileInfo.setFiles(forderInfos);
        }
        return forderFileInfo;
    }
}
