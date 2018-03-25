package com.chens.exam.core.enums;

public enum TopIdEnum{
	TOP_SOURCE("全部资源", "1000000000000000000L");
	
	private String display;
	private String code;
	
	private TopIdEnum(String display, String code) {
		this.display = display;
		this.code = code;
		
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}



	public String getCode() {
		return code;
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
    public static TopIdEnum getYesNoEnumBycode(String code){           
    	TopIdEnum[] enums = TopIdEnum.values();
        for(TopIdEnum item: enums){          
            if(item.getCode().equals(code)){
                return item;
            }
        }      
        return null;
    }
}
