package com.chens.exam.book.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.core.web.BaseController;
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
public class TrainingController extends BaseController {

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
    
    
    @RequestMapping("/update_training")
   	public String updateTraining(Training training){
 //   	training.setId(969096958142681089l);
    	training = trainingService.selectById(training.getId());
    	if(training != null){
    		training.setTrainingName("语文练习册");
        	training.setStatus("1");
        	training.setDescription("第三期培训练习");
        	boolean flag = trainingService.updateById(training);
        	if(flag){
        		return "修改成功";
        	}else{
        		return "修改失败";
        	}
    	}else{
    		return "数据不存在";
    	}
    	
    }
    
    @RequestMapping("/delete_training")
   	public String deleteTraining(Training training){
 //   	training.setId(969096958142681089l);
    	boolean flag = trainingService.deleteById(training.getId());
    	if(flag){
        	return "删除成功";  
    	}else{
    		return "删除失败";
    	}
    	
    }
	
}

