package com.chens.exam.book.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.enums.DBType;
import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;


@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan("com.chens.exam.book.mapper*")
public class MybatisPlusConfig {
	
	 private Logger logger = LogManager.getLogger(MybatisPlusConfig.class);
	
	 /*
	    * 分页插件，自动识别数据库类型
	    */
	   @Bean
	   public PaginationInterceptor paginationInterceptor() {
		   logger.info("******开始加载分页********");		   
		   PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
	       paginationInterceptor.setDialectType(DBType.MYSQL.getDb());
	       logger.info("******结束加载分页********");
	       return paginationInterceptor;
	   }
	   
}
