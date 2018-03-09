package com.chens.exam.wms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import com.baomidou.mybatisplus.spring.boot.starter.MybatisPlusProperties;
import com.chens.core.config.BaseMybatisPlusConfig;


@Configuration
@EnableConfigurationProperties(MybatisPlusProperties.class)
@MapperScan("com.chens.exam.wms.mapper*")
public class MybatisPlusConfig extends BaseMybatisPlusConfig{

	   
}
