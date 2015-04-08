package com.xt.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/*
 * 得到当前时间
 * */
public class UtilTime {
	
	public static String getTime(){
		
		Date nowDate = new Date();
		SimpleDateFormat format = 
				new SimpleDateFormat("yyyy年MM月dd日HH:mm:ss");
		
		String time = format.format(nowDate);
		
		return time;
	}
	
}
