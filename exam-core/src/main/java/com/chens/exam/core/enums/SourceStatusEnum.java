package com.chens.exam.core.enums;
/**
 * 资源状态枚举
 * @author WDP
 *
 */
public enum SourceStatusEnum{
	DRAFT("草稿", "DRAFT"),
	SUBMIT("提交","SUBMIT"),
	ONLINE("上架","ONLINE"),
	OFFFLINE("下架","OFFFLINE"),
	ABANDON("废弃","ABANDON");
	
	private String display;
	private String code;
	
	private SourceStatusEnum(String display, String code) {
		this.display = display;
		this.code = code;
		
	}
	public String getDisplay() {
		return display;
	}

	public String getCode() {
		return code;
	}

	public void setDisplay(String display) {
		this.display = display;
	}

	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @Description: 通过编码获取枚举值
	 * @param @param code
	 * @param @return 参数描述
	 * @return YesNoEnum 返回类型
	 * @throws 异常说明
	 * 
	 * @author sunm
	 */
    public static SourceStatusEnum getYesNoEnumByCode(String code){           
        SourceStatusEnum[] enums = SourceStatusEnum.values();
        for(SourceStatusEnum item: enums){          
            if(item.getCode().equalsIgnoreCase(code)){
                return item;
            }
        }      
        return null;
    }
}
