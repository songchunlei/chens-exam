package com.chens.exam.book.config;

import com.chens.core.config.BaseMybatisPlusConfig;
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
@MapperScan(basePackages = {"com.chens.exam.book.mapper*","com.chens.bpm.mapper*"})
public class MybatisPlusConfig extends BaseMybatisPlusConfig {
	   
}
