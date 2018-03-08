package com.chens.exam.core.enums;
public enum NodeTypeEnum {
	 SOURCE_ROOT("资源树根节点类型","ROOT"); 
	
	private String name;
	private String code;
	private NodeTypeEnum(String name,String code){
		this.name = name;
		this.code = code;
	}
	/**
	 * 根据code 取name
	 * @param code
	 * @return
	 */
    public static String getName(String code) {  
        for (NodeTypeEnum mt : NodeTypeEnum.values()) {  
            if (mt.getCode().equals(code)) {  
                return mt.name;  
            }  
        }  
        return null;  
    } 
 /**
  * 根据name取code
  * @param name
  * @return
  */
    public static String getCode(String name) {  
        for (NodeTypeEnum mt : NodeTypeEnum.values()) {  
            if (mt.getName().equals(name)) {  
                return mt.code;  
            }  
        }  
        return null;  
    }
    
    public static NodeTypeEnum getSelf(String code) {  
        for (NodeTypeEnum mt : NodeTypeEnum.values()) {  
            if (mt.getCode().equals(code)) {  
                return mt;  
            }  
        }  
        return null;  
    } 
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
