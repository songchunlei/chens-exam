package com.chens.exam.book;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @Author:chunlei.song@live.com
 * @Description:
 * @Date Create in 16:37 2018-2-27
 * @Modified By:
 */
//@ComponentScan(basePackages="com.chens.exam.book.controller")
@SpringBootApplication
public class BookApp {
	
	public static void main(String[] args){
		new SpringApplicationBuilder(BookApp.class).web(true).run(args);
		
	}
}
