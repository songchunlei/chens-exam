package com.chens.exam.wms.vo.service.impl;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.chens.exam.core.vo.AbstractTag;
import com.chens.exam.wms.vo.mapper.AbstractTagMapper;
import com.chens.exam.wms.vo.service.IAbstractTagService;

/**
 * 
 *  服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
public abstract class AbstractTagServiceImpl<M extends AbstractTagMapper<T>, T extends AbstractTag<T>> extends ServiceImpl<M, T> implements IAbstractTagService<T> {
	
}
