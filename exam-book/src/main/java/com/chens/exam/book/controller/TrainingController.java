package com.chens.exam.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.exam.book.entity.Training;
import com.chens.exam.book.service.TrainingService;

/**
 * <p>
 * 练习册 前端控制器
 * </p>
 *
 * @author wdp
 * @since 2018-03-01
 */
@RestController
@RequestMapping("/trainingController")
public class TrainingController {

	@Autowired
	private TrainingService trainingService;

    @RequestMapping("/save_training")
   	public String saveTraining(Training training){
    	
    	training.setTrainingName("数学练习册");
    	training.setStatus("0");
    	training.setTenantId("AANDSDOR6SDFDSFSD");
    	training.setDescription("第三期培训练习");
    	boolean flag = trainingService.insert(training);
    	if(flag){
    		return "新增成功";
    	}else{
    		return "新增失败";
    	}
    }
	
}

