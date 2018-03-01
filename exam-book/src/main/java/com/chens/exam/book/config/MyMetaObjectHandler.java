package com.chens.exam.book.config;

import java.util.Date;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;


/**
 *   自定义填充公共 创建人，创建时间，修改人、修改时间  字段  
 * @author WDP
 *
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

	@Override
	public void insertFill(MetaObject metaObject) {
		// 更多查看源码测试用例
        System.out.println("*************************");
        System.out.println("insert fill");
        System.out.println("*************************");

        // 测试下划线
//        Object testType = getFieldValByName("testType", metaObject);//mybatis-plus版本2.0.9+
//        System.out.println("testType=" + testType);
//        if (testType == null) {
//            setFieldValByName("testType", 3, metaObject);//mybatis-plus版本2.0.9+
//        }
        Date date = new Date();
        setFieldValByName("createTime", date, metaObject);
        setFieldValByName("updateTime", date, metaObject);
        
        setFieldValByName("createBy", "wdp", metaObject);
        setFieldValByName("updateBy", "wdp", metaObject);
        
	}

	@Override
	public void updateFill(MetaObject metaObject) {
		 //更新填充
        System.out.println("*************************");
        System.out.println("update fill");
        System.out.println("*************************");
        //mybatis-plus版本2.0.9+
        
        Date date = new Date();
        setFieldValByName("updateTime", date, metaObject);
        
        setFieldValByName("updateBy", "wdp", metaObject);

	}

}
