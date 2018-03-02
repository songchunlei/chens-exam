package com.chens.exam.book.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.chens.exam.core.enums.YesNoEnum;


/**
 *   自定义填充公共 创建人，创建时间，修改人、修改时间  字段  
 * @author WDP
 *
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {
	
	 private Logger logger = LogManager.getLogger(MyMetaObjectHandler.class);

	@Override
	public void insertFill(MetaObject metaObject) {
		// 更多查看源码测试用例
//		logger.info("*************************insert fill*************************");
        Date date = new Date();
        setFieldValByName("createTime", date, metaObject);
        setFieldValByName("updateTime", date, metaObject); 
        //等人员sessionn确定后修改
        setFieldValByName("createBy", "wdp", metaObject);
        setFieldValByName("updateBy", "wdp", metaObject);
        setFieldValByName("tenantId", "AAAAASSSADD", metaObject);
        setFieldValByName("isDelete", YesNoEnum.NO.getCode(), metaObject);
        
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		 //更新填充
        logger.info("*************************update fill*************************");
        //mybatis-plus版本2.0.9+  
        Date date = new Date();
        setFieldValByName("updateTime", date, metaObject);
        //
        setFieldValByName("updateBy", "www", metaObject);

	}

}
