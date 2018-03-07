package com.chens.exam.wms;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author:chunlei.song@live.com
 * @Description:
 * @Date Create in 16:37 2018-2-27
 * @Modified By:
 */
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = { "com.chens.exam.wms*" })
@EnableTransactionManagement
@EnableFeignClients
public class WmsApp {
	public static void main(String[] args){
		new SpringApplicationBuilder(WmsApp.class).web(true).run(args);
		
	}
}
