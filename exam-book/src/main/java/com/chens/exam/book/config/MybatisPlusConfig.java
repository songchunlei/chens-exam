package com.chens.exam.book.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.entity.GlobalConfiguration;
import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.mapper.LogicSqlInjector;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import com.chens.exam.core.enums.YesNoEnum;


@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan("com.chens.exam.book.mapper*")
public class MybatisPlusConfig {
	 /*
	    * 分页插件，自动识别数据库类型
	    */
	   @Bean
	   public PaginationInterceptor paginationInterceptor() {
		   PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
	       paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
	       return paginationInterceptor;
	   }
	   
	   /**
	    * mybatis-plus公共配置
	    * @return
	    */
	   @Bean
	   public GlobalConfiguration globalConfiguration() {
		    GlobalConfiguration configuration = new GlobalConfiguration(new LogicSqlInjector());
		    //逻辑删除
		    configuration.setLogicDeleteValue(YesNoEnum.YES.getCode());
		    configuration.setLogicNotDeleteValue(YesNoEnum.NO.getCode());
		    //ID生产策略
		    configuration.setIdType(IdType.UUID.getKey());
		    //公共字段自动填充
		    configuration.setMetaObjectHandler(new MyMetaObjectHandler());
		    return configuration;
	   }
}
