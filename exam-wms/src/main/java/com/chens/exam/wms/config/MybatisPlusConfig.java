package com.chens.exam.wms.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import com.chens.core.config.BaseMybatisPlusConfig;


@Configuration
@MapperScan(basePackages = {"com.chens.**.mapper"})
public class MybatisPlusConfig extends BaseMybatisPlusConfig{

}
