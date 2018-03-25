package com.chens.exam.core.utils;

import java.util.ArrayList;
import java.util.List;

public final class StringUtil {
	/**
	 * id字符串转id List  
	 * @param idStr
	 * @return
	 */
    public static List<String> string2List(String idStr) {  
    	String[] idArray = idStr.split(",");
		List<String> idList = new ArrayList<String>();
		for(int i = 0; i < idArray.length; i++){
			idList.add(idArray[i]);
		}
        return idList;
    }
 
  
}
