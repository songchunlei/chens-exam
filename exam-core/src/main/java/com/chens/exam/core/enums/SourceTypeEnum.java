package com.chens.exam.core.enums;
/**
 * 资源类型枚举
 * @author WDP
 *
 */
public enum SourceTypeEnum{
	IMAGE_TEXT("图文", "IMAGE_TEXT"), 
	FILE("文件","FILE"),
	LINK("链接","LINK");
	
	private String display;
	private String code;
	
	private SourceTypeEnum(String display, String code) {
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
    public static SourceTypeEnum getYesNoEnumByCode(String code){           
        SourceTypeEnum[] enums = SourceTypeEnum.values();
        for(SourceTypeEnum item: enums){          
            if(item.getCode().equalsIgnoreCase(code)){
                return item;
            }
        }      
        return null;
    }
}
