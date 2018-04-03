package com.chens.exam.wms.controller;


import com.baomidou.mybatisplus.annotations.TableName;
import com.chens.exam.core.enums.WfProcessDefinitionKeyEnum;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chens.bpm.controller.WfBaseController;
import com.chens.bpm.vo.WorkFlowRequestParam;
import com.chens.core.context.BaseContextHandler;
import com.chens.core.exception.BaseException;
import com.chens.core.exception.BaseExceptionEnum;
import com.chens.core.vo.Result;
import com.chens.exam.core.entity.wms.Source;
import com.chens.exam.wms.service.ISourceService;

/**
 * <p>
 * 资源素材表 前端控制器
 * </p>
 *
 * @author wdp123
 * @since 2018-03-06
 */
@Controller
@RequestMapping("/sourceController")
public class SourceController extends WfBaseController<ISourceService,Source> {

	@Override
	protected void init(Source source) {
		source.setProcessDefinitionKey(WfProcessDefinitionKeyEnum.SOURCE_APPROVE.getCode());
	}

		/*
		workFlowRequestParam = new WorkFlowRequestParam<Source>();
		workFlowRequestParam.setProcessDefinitionKey("SOURCE_APPROVE");//流程定义Key
		workFlowRequestParam.setVariableValue(source.getVariableValue());//前台传过来的下一环节选择
		workFlowRequestParam.setTaskId(source.getTaskId());//任务id
		workFlowRequestParam.setNextUserId(source.getNextUserId());//下一处理人
		workFlowRequestParam.setStartUserId(BaseContextHandler.getUserId());//发起人
		workFlowRequestParam.setStartUserName(BaseContextHandler.getName());//发起人姓名
		workFlowRequestParam.setTenantId(BaseContextHandler.getTenantId());//租户
		//workFlowRequestParam.setTableName("t_source");//表名
		TableName tableName = Source.class.getAnnotation(TableName.class);
		if(tableName!=null)
		{
			workFlowRequestParam.setTableName(tableName.value());//从注解获取类名
		}
		workFlowRequestParam.setBpmReason(source.getBpmReason());//审批意见
		workFlowRequestParam.setTaskName(source.getTaskName());
		workFlowRequestParam.setCurrentTaskDefinitionKey(source.getCurrentTaskDefinitionKey());
		workFlowRequestParam.setCurrentTaskDefinitionName(source.getCurrentTaskDefinitionName());
		workFlowRequestParam.setT(source);
		*/

	/**
	 * 提交资源
	 * @param source
	 * @return
	 */
	@PutMapping("/submit")
	public ResponseEntity<Result> submit(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("提交成功",service.submit(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}
	}
	
	/**
	 * 上架资源
	 * @param source
	 * @return
	 */
	@PutMapping("/online")
	public ResponseEntity<Result> online(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("上架成功",service.publish(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 下架资源
	 * @param source
	 * @return
	 */
	@PutMapping("/offline")
	public ResponseEntity<Result> offline(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("下架成功",service.offline(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}
	
	/**
	 * 废弃资源
	 * @param source
	 * @return
	 */
	@PutMapping("/abandon")
	public ResponseEntity<Result> abandon(@RequestBody Source source) {
			if(source != null && StringUtils.isNotBlank(source.getIdStr())){
				return doSuccess("废弃成功",service.abandon(source));
			} else {
				throw new BaseException(BaseExceptionEnum.REQUEST_NULL);
			}

	}

}

