package com.xt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * �õ���ǰʱ��
 * */
public class UtilTime {
	
	public static String getTime(){
		
		Date nowDate = new Date();
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy��MM��dd��HH:mm:ss");
		
		String time = format.format(nowDate);
		
		return time;
	}
	
}
