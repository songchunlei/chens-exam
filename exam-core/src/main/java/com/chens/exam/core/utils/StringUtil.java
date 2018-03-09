package com.chens.exam.core.utils;

import java.util.ArrayList;
import java.util.List;

public final class StringUtil {
	/**
	 * id字符串转id List  
	 * @param idStr
	 * @return
	 */
    public static List<Long> string2List(String idStr) {  
    	String[] idArray = idStr.split(",");
		List<Long> idList = new ArrayList<Long>();
		for(int i = 0; i < idArray.length; i++){
			Long id = Long.valueOf(idArray[i]);
			idList.add(id);
		}
        return idList;
    }
 
  
}
